package com.uce.ec.p.Interceptor;

import com.uce.ec.p.anotaciones.VerificarSaldo;
import com.uce.ec.p.model.Cuenta;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor
@VerificarSaldo
@Priority (2001)
public class VerificarSaldoInter {

    @AroundInvoke
    public Object interceptar(InvocationContext contex) throws Exception {
        Cuenta ctO = (Cuenta) contex.getParameters()[0];
        double monto = (double) contex.getParameters()[1];
        Object resul;
        System.out.println("[Saldo] Verificando saldo disponible...");
        try{
            Thread.sleep(2000);
        }catch(Exception e){

        }
        if (ctO.getSaldo() < monto) {
            throw new Exception("[Saldo] El saldo es insuficiente para realizar esta transferencia");
        } else {
            System.out.println("[Saldo] Hay suficiente saldo, procediento a realizar la transferencia");
            resul = contex.proceed();
        }

        return resul;
    }

}
