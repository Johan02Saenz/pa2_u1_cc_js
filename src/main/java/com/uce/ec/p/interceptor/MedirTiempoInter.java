package com.uce.ec.p.interceptor;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@MedirTiempo 
@Interceptor 
@Priority((Interceptor.Priority.APPLICATION+4))
public class MedirTiempoInter {

    @AroundInvoke 
    public Object interceptar(InvocationContext contex) throws Exception{

        long init = System.currentTimeMillis();
       System.out.println();
        long fin = System.currentTimeMillis();
        System.out.println("-> [Interceptor]El metodo demoro: " + (fin-init));
        Object resul = contex.proceed();

        return resul;

    }
    
}
