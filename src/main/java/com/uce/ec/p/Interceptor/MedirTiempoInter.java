package com.uce.ec.p.Interceptor;

import com.uce.ec.p.anotaciones.MedirTiempo;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor 
@MedirTiempo 
@Priority (1999)
public class MedirTiempoInter {

    @AroundInvoke 
    public Object interceptar(InvocationContext contex)throws Exception{
        long init = System.currentTimeMillis();
        Object resul= contex.proceed();
        long fin = System.currentTimeMillis()- init;
        System.out.println("[Redimiento] La ejecucion de la tranferencia tuvo una duracion de :"+ fin);
        return resul;
    }
}
