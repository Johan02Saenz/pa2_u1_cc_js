package com.uce.ec.p.interceptor;

import com.uce.ec.p.paquete.Pedido;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Mail
@Interceptor
@Priority ((Interceptor.Priority.APPLICATION+1))
public class MailInterceptor {

    @AroundInvoke
    public Object interceptar(InvocationContext contex) throws Exception {
        Pedido pedido = (Pedido) contex.getParameters()[0];
        String asunto = "Confirmacion de pedido";
        String cuerpo = "Estimado " + pedido.getCliente() + ", su pedido de " + pedido.getProducto()
                + " por un total de $" + pedido.getTotal() + " ha sido realizado con exito.";
        Object resul = contex.proceed();

        System.out.println("-> [Mail] Enviando correo a: " + pedido.getCorreo());
        System.out.println("Asunto: " + asunto);
        System.out.println("Cuerpo: " + cuerpo);
        System.out.println("Correo enviado con exito");
        return resul;
    }

}
