/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author пк
 */
public class InterceptorClass {

    @AroundInvoke
    Object intercept(InvocationContext ctx) throws Exception {
        Object[] parameters = ctx.getParameters();
        String param = (String) parameters[0];
        param = param + "Smirnova";
        parameters[0] = param;
        ctx.setParameters(parameters);
        try {
            return ctx.proceed();
        } catch (Exception e) {
            System.out.println("Error calling ctx.proceed in modifyGreeting()");
            return null;
        }
    }

}
