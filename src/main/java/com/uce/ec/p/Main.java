package com.uce.ec.p;

import com.uce.ec.p.extensiones.NotificacionExtnMail;
import com.uce.ec.p.extensiones.NotificacionExtnSMS;
import com.uce.ec.p.extensiones.NotificacionExtnWhatsApp;
import com.uce.ec.p.paquete.Compra;
import com.uce.ec.p.paquete.CompraService;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main implements QuarkusApplication {

    @Inject 
    private NotificacionExtnMail notificacionExtnMail;

    @Inject 
    private NotificacionExtnSMS notificacionExtnSMS;

    
    @Inject 
    private NotificacionExtnWhatsApp notificacionExtnWhatsApp;

    @Inject
    private CompraService compraService;

    public static void main(String[] args) {
        Quarkus.run(Main.class, args);
    }

    @Override
    public int run(String... args) {
        System.out.println("---------------------------\nIniciando la app Quarkus\n---------------------------");
        Compra compra = new Compra("Johan Saenz", "Audifonos Soundcore q11i", 35, "johan@gmail.com", "0123456789");
        Compra compra1 = new Compra("Johan Saenz", "Tanzu Jade", 40, "johan@gmail.com", "0123456789");
         Compra compra2 = new Compra("Johan Saenz", "Monster Ultra", 3, "johan@gmail.com", "0123456789");
        compraService.realizar(compra, this.notificacionExtnMail );
        compraService.realizar(compra1, this.notificacionExtnSMS );
        compraService.realizar(compra2, this.notificacionExtnWhatsApp);
        return 0;
    }
}
