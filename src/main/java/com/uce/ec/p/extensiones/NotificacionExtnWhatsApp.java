package com.uce.ec.p.extensiones;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class NotificacionExtnWhatsApp implements NotificacionExtension {

    @Override
    public void enviar(String msg, String destinatario) {
        System.out.println("[WhatsApp extn] Enviando WhatsApp a:" + destinatario);
        System.out.println("    Mensaje: " + msg);
        System.out.println("//WhatsApp enviado con exito");

    }

}
