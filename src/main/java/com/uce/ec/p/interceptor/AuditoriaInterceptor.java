package com.uce.ec.p.interceptor;

import java.lang.reflect.Parameter;

import com.uce.ec.p.paquete.AuditoriaService;
import com.uce.ec.p.paquete.Pedido;

import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Auditoria
@Interceptor
@Priority((Interceptor.Priority.APPLICATION+3))
public class AuditoriaInterceptor {

    @Inject
    private AuditoriaService auditoriaService;

    @AroundInvoke // sirve para interceptar la ejecución de métodos de negocio dentro de un bean o
                  // una clase interceptora.
    public Object interceptar(InvocationContext context) throws Exception {

        String methodName = context.getMethod().getName();
        System.out.println("-> [Auditoria]-> Nombre del metodo: " + methodName);
        System.out.println("-> [Auditoria] -> Ejecutacion de lo que haga el interceptor");
        Parameter[] parametros = context.getMethod().getParameters();
        for (Parameter p : parametros) {
            System.out.println("Parametros: " + p.getName());
        }
        Object[] valores = context.getParameters();
        Pedido pedido = (Pedido) valores[0];
        String cliente = pedido.getCliente();
        double total = pedido.getTotal();
        String correo = pedido.getCorreo();
        this.auditoriaService.guardarEnLaBAse(cliente, total, correo);
        // Todo lo previo se ejecuta antes de ejecutar el metodo interceptar
        Object resultado = context.proceed(); // Ejecuta el metodo interceptado

        System.out.println("-> [Auditoria]Retorno :\"" + resultado.toString() + "\"");
        System.out.println("-> [Auditoria] -> Mensaje posterior a la ejecucion del metodo");
        return resultado;
    }
}
