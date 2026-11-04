package com.uce.ec.p.paquete;

import com.uce.ec.p.interceptor.Auditoria;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped // Se delega el control al contenedor ArC
public class PedidoService {

    @Auditoria
    public String realizar(Pedido pedido, String otherParameter) {
        long init = System.currentTimeMillis();
        try {
            Thread.sleep(15000);
        } catch (Exception e) {
        }

        System.out.println("::::::::::::::::::::::::::::: \nRealizando pedido....");
        System.out.println("Pedido realizado para el cliente: " + pedido.getCliente());
        System.out.println("Producto: " + pedido.getProducto());
        System.out.println("Total: " + pedido.getTotal());
        System.out.println("Correo: " + pedido.getCorreo());
        System.out.println("Telefono: " + pedido.getTelefono());
        System.out.println("Pedido realizado con exito. \n ::::::::::::::::::::::::::::: ");
        long fin = System.currentTimeMillis() - init;
        return "[PedidoService] Se ha ejecutado correctamente \n Tiempo de ejecucion : " + fin;
    }

}
