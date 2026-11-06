package com.uce.ec.p.logica;

import com.uce.ec.p.anotaciones.Auditoria;
import com.uce.ec.p.anotaciones.MedirTiempo;
import com.uce.ec.p.anotaciones.Notificacion;
import com.uce.ec.p.anotaciones.VerificarSaldo;
import com.uce.ec.p.model.Cuenta;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped

public class TransferenciaService {

    @Notificacion 
    @MedirTiempo 
    @Auditoria 
    @VerificarSaldo 
    public void execute(Cuenta origen, double monto, Cuenta destino) {
        origen.setSaldo(origen.getSaldo() - monto);
        System.out.println("[Transferencia] Metodo ejecutado");
        destino.setSaldo(destino.getSaldo() + monto);
    }

}
