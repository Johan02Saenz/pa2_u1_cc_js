package com.uce.ec.p.interceptor;

import com.uce.ec.p.paquete.Pedido;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor
@SMS
@Priority((Interceptor.Priority.APPLICATION + 2))
public class SMSInterceptor {

    @AroundInvoke
    public Object interceptar(InvocationContext contex) throws Exception {
        Pedido pedido = (Pedido) contex.getParameters()[0];
        String cuerpo = "Estimado " + pedido.getCliente() + ", su pedido de " + pedido.getProducto()
                + " por un total de $" + pedido.getTotal() + " ha sido realizado con exito.";
        Object resul = contex.proceed();

        System.out.println("-> [SMS] Enviando SMS a: " + pedido.getTelefono());
        System.out.println("Mensaje: " + cuerpo);
        System.out.println("SMS enviado con exito");
        return resul;
    }

}
