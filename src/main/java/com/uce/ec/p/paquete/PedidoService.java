package com.uce.ec.p.paquete;

import com.uce.ec.p.interceptor.Auditoria;
import com.uce.ec.p.interceptor.Mail;
import com.uce.ec.p.interceptor.MedirTiempo;
import com.uce.ec.p.interceptor.SMS;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped // Se delega el control al contenedor ArC
public class PedidoService {
    //cuarto envio de mail y el tercero  SMS con prioridad aplication

    @Auditoria 
    @MedirTiempo 
    @Mail 
    @SMS 
    public String realizar(Pedido pedido, String otherParameter) {

        try {
            Thread.sleep(1500);
        } catch (Exception e) {
        }

        System.out.println("::::::::::::::::::::::::::::: \nRealizando pedido....");
        System.out.println("Pedido realizado para el cliente: " + pedido.getCliente());
        System.out.println("Producto: " + pedido.getProducto());
        System.out.println("Total: " + pedido.getTotal());
        System.out.println("Correo: " + pedido.getCorreo());
        System.out.println("Telefono: " + pedido.getTelefono());
        System.out.println("Pedido realizado con exito. \n ::::::::::::::::::::::::::::: ");

        return "[PedidoService] Se ha ejecutado correctamente" ;
    }

}
