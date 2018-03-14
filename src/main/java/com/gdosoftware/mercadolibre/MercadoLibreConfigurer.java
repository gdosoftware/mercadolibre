/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdosoftware.mercadolibre;

import com.gdosoftware.mercadolibre.api.MercadoLibre;
import com.gdosoftware.mercadolibre.api.impl.MercadoLibreTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import com.gdosoftware.mercadolibre.connect.ConnectionPoolRepository;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

/**
 *
 * @author Daniel Gago
 */
public abstract class MercadoLibreConfigurer {
    
    
    public abstract Long getApplicationId(Environment env);
    public abstract String getApplicationSecret(Environment env);
    public abstract ConnectionPoolRepository getConnectionPoolRepository();
    public abstract String getCallbackUrl(Environment env);
    public abstract String getSuccessUrl();
    
    @Bean
    @Scope(value="session", proxyMode=ScopedProxyMode.INTERFACES)
    public MercadoLibre populateApi(Environment env){
        return new MercadoLibreTemplate(getApplicationId(env),getApplicationSecret(env));
    }
    
    @Bean
    public ConnectionPoolRepository populateConnectionRepository(){
        return getConnectionPoolRepository();
    }
    
    @Bean(name = "callbackUrl")
    public String populateCallbackUrl(Environment env){
        return getCallbackUrl(env);
    }
    
    @Bean(name = "successUrl")
    public String populateSuccessPage(){
        return getSuccessUrl();
    }
    
    @Bean(name = "applicationEventMulticaster")
    public ApplicationEventMulticaster simpleApplicationEventMulticaster() {
        SimpleApplicationEventMulticaster eventMulticaster 
          = new SimpleApplicationEventMulticaster();
         
        eventMulticaster.setTaskExecutor(new SimpleAsyncTaskExecutor());
        return eventMulticaster;
    }
    
   
}
