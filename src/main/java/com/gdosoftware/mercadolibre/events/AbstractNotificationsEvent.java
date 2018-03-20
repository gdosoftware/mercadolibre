/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdosoftware.mercadolibre.events;

import com.gdosoftware.mercadolibre.api.MercadoLibre;
import com.gdosoftware.mercadolibre.connect.ConnectionPoolRepository;
import com.gdosoftware.mercadolibre.domain.MLNotify;
import java.util.Optional;
import org.springframework.context.ApplicationEvent;

/**
 *
 * @author Daniel Gago
 */
public abstract class AbstractNotificationsEvent  extends ApplicationEvent{
   
    
    protected MercadoLibre mercadoLibre;
    
                    
    public AbstractNotificationsEvent(Object source, ConnectionPoolRepository connRepo) {
        super(source);
        Optional.ofNullable(connRepo).ifPresent((cpr) -> {
            this.mercadoLibre = cpr.getApi(getNotification().getUser_id());
        });
    }
    
    private MLNotify getNotification(){
        return (MLNotify) this.source;
    }

    public String getResource() {
        return getNotification().getResource();
    }

    public Long getUser_id() {
        return getNotification().getUser_id();
    }

    public String getTopic() {
        return getNotification().getTopic();
    }

    public String getReceived() {
        return getNotification().getReceived();
    }

    public String getSent() {
        return getNotification().getSent();
    }

    public int getAttempts() {
        return getNotification().getAttempts();
    }
    
    public String getResourceId(){
        return getNotification().getResourceId();
    }
        
    public MercadoLibre getApi(){
        return mercadoLibre;
    }
    
    
    
    
}
