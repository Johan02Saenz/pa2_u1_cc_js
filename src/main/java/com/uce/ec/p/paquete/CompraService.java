package com.uce.ec.p.paquete;

import com.uce.ec.p.extensiones.NotificacionExtension;
import com.uce.ec.p.interfaz.Notificacion;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped
public class CompraService {

    public void realizar(Compra compra, NotificacionExtension notiExt) {
        System.out.println("Realizando Compra....");
        System.out.println("Pedido realizado para el cliente: " + compra.getCliente());
        System.out.println("Producto: " + compra.getProducto());
        System.out.println("Total: " + compra.getTotal());
        System.out.println("Correo: " + compra.getCorreo());
        System.out.println("Telefono: " + compra.getTelefono());
        System.out.println("Pedido realizado con exito. \n ::::::::::::::::::::::::::::: ");
        String cuerpo = "\n     Estimado " + compra.getCliente() + ", su pedido de " + compra.getProducto()
                + " por un total de $" + compra.getTotal() + " ha sido realizado con exito.";

        /*
         * Programacion del envio de la notificacion
         * Recibir una implementacion de la interfaz como un parametro para garantizar
         * la extenciabilidad
         */

        notiExt.enviar(cuerpo, compra.getCliente());

    }
}
