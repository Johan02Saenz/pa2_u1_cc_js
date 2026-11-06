package com.uce.ec.p.Interceptor;

import com.uce.ec.p.anotaciones.Auditoria;
import com.uce.ec.p.model.Cuenta;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor
@Auditoria
@Priority (2003)
public class AuditoriaInter {

    @AroundInvoke
    public Object interceptar(InvocationContext contex) throws Exception {
        Cuenta ctO = (Cuenta) contex.getParameters()[0], ctD = (Cuenta) contex.getParameters()[2];
        double monto = (double) contex.getParameters()[1];
        System.out.printf(
                "[Auditoria] EL cliente: %s con cuenta %d ha iniciado una transferencia para la cuenta %d a nombre del cliente: %s %n",
                ctO.getCliente(), ctO.getNumero(), ctD.getNumero(), ctD.getCliente());
        Object resul = contex.proceed();
        System.out.printf(
                "[Auditoria] EL cliente: %s con cuenta %d ha realizado con exito transferencia con el monto : %.2f para la cuenta %d a nombre del cliente: %s %n",
                ctO.getCliente(), ctO.getNumero(), monto, ctD.getNumero(), ctD.getCliente());
        return resul;
    }
}
