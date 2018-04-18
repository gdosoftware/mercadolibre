/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdosoftware.mercadolibre.events;

import com.gdosoftware.mercadolibre.api.ConnectionPoolRepository;
import com.gdosoftware.mercadolibre.api.MercadoLibre;
import com.gdosoftware.mercadolibre.api.impl.MercadoLibreTemplate;
import com.gdosoftware.mercadolibre.domain.MLNotify;
import java.util.Optional;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEvent;

/**
 *
 * @author Dani
 */
public abstract class AbstractNotificationEvent extends ApplicationEvent{
    
    
    @Value("${com.gdosoftware.mercadolibre.applicationid}")
    private Long applicationId;
    
    @Value("${com.gdosoftware.mercadolibre.secretkey}")
    private String secretKey;
    
    @Autowired
    protected ConnectionPoolRepository connRepo;
                    
    protected MercadoLibre mercadoLibre;
    
    
    public AbstractNotificationEvent(Object source) {
        super(source);
        this.connRepo = connRepo;
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
    
    @PostConstruct
    public void populateMercadoLibre(){
        Long userId = getUser_id();
        this.mercadoLibre = new MercadoLibreTemplate(applicationId,secretKey,userId);
        this.mercadoLibre.getCredentialOperations().setAccessToken(connRepo.getAccessToken(userId));
        this.mercadoLibre.getCredentialOperations().setRefreshToken(connRepo.getRefreshToken(userId));
        this.mercadoLibre.getCredentialOperations().setExpiresIn(connRepo.getExpiresIn(userId));
    }
    
    
}
