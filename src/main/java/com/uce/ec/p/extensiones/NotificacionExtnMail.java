package com.uce.ec.p.extensiones;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
public class NotificacionExtnMail implements NotificacionExtension {

    @Override
    public void enviar(String msg, String destinatario) {
        System.out.println("[Mail extn] Enviando correo a:"+ destinatario);
        System.out.println("    Mensaje: "+ msg);
        System.out.println("//Correo enviado con exito");
    }
    
}
