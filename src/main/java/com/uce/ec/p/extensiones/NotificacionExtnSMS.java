package com.uce.ec.p.extensiones;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped 
public class NotificacionExtnSMS implements NotificacionExtension {

    @Override
    public void enviar(String msg, String destinatario) {
        System.out.println("[SMS extn] Enviando SMS a:"+ destinatario);
        System.out.println("    Mensaje: "+ msg);
        System.out.println("//SMS enviado con exito");
    }
}
