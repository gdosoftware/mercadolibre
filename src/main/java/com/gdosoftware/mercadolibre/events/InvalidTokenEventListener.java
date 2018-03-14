/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdosoftware.mercadolibre.events;

import com.gdosoftware.mercadolibre.connect.ConnectionPoolRepository;
import com.mercadolibre.sdk.AuthorizationFailure;
import com.mercadolibre.sdk.Meli;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author Daniel Gago
 */
@Component
public class InvalidTokenEventListener implements ApplicationListener<InvalidTokenEvent>  {

        
    @Autowired
    private ApplicationContext сontext;
    
    @Override
    public void onApplicationEvent(InvalidTokenEvent event) {
        System.out.println("Comenzo tratamiento de evento");
        Meli meli = event.getMeli();
        try {
            meli.refreshAccessToken();
            ConnectionPoolRepository connRepo = сontext.getBean(ConnectionPoolRepository.class);// no se inyecta porque sino esta defindo falla
            if(connRepo != null)
                connRepo.save(meli.getUserId(), meli.getAccessToken(), meli.getRefreshToken(), meli.getExpiresIn());
        } catch (AuthorizationFailure ex) {
            Logger.getLogger(InvalidTokenEventListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
