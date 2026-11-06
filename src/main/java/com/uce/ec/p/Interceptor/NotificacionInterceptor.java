package com.uce.ec.p.Interceptor;

import java.time.LocalDateTime;

import com.uce.ec.p.anotaciones.Notificacion;
import com.uce.ec.p.model.Cuenta;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Notificacion
@Interceptor
@Priority(2000)
public class NotificacionInterceptor {

    @AroundInvoke
    public Object interceptar(InvocationContext contex) throws Exception {
        Cuenta origen = (Cuenta) contex.getParameters()[0], destino = (Cuenta) contex.getParameters()[2];
        Object resultado = contex.proceed();
        System.out.println("|---------------------------------------------------------|");
        System.out.println("        Envio de Notificacion por correo");
        System.out.println("|---------------------------------------------------------|");
        System.out.println("La transferencia se ha realizado con exito");
        System.out.println("Para: " + origen.getCorreo() + " | " + destino.getCorreo());
        System.out.println("Cuenta de origen: " + origen.getNumero());
        System.out.println("A nombre de : " + origen.getCliente());
        System.out.println("Monto transferido: " + contex.getParameters()[1].toString());
        System.out.println("Cuenta de destino: " + destino.getNumero());
        System.out.println("A nombre de : " + destino.getCliente());
        System.out.println("Fecha y hora: " + LocalDateTime.now().toString());
        System.out.println("|---------------------------------------------------------|");
        return resultado;
    }
}
