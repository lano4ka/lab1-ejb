/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.enterprise.event.Observes;
import javax.inject.Named;
import javax.interceptor.Interceptors;

/**
 *
 * @author пк
 */
@Singleton
@LocalBean
@Named
public class NewSessionBean {

    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    @Interceptors(InterceptorClass.class)
    public int incrementCount() {
        
        return count++;
    }

    public void listenCounter(@Observes EventClass eventClass) {
        incrementCount();
    }
}
