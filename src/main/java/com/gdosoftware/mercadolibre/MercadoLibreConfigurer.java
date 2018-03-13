/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdosoftware.mercadolibre;

import com.gdosoftware.mercadolibre.api.MercadoLibre;
import com.gdosoftware.mercadolibre.api.impl.MercadoLibreTemplate;
import com.gdosoftware.mercadolibre.connect.ConnectionRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;

/**
 *
 * @author Daniel Gago
 */
public abstract class MercadoLibreConfigurer {
    
    
    public abstract Long getClientId(Environment env);
    public abstract String getClientSecret(Environment env);
    public abstract ConnectionRepository getConnectionRepository();
    public abstract String getCallbackUrl(Environment env);
    public abstract String getSuccessPage();
    
    @Bean
    @Scope(value="session", proxyMode=ScopedProxyMode.INTERFACES)
    public MercadoLibre populateApi(Environment env){
        return new MercadoLibreTemplate(getClientId(env),getClientSecret(env));
    }
    
    @Bean
    public ConnectionRepository populateConnectionRepository(){
        return getConnectionRepository();
    }
    
    @Bean(name = "callbackUrl")
    public String populateCallbackUrl(Environment env){
        return getCallbackUrl(env);
    }
    
    @Bean(name = "successPage")
    public String populateSuccessPage(){
        return getSuccessPage();
    }
    
   
}
