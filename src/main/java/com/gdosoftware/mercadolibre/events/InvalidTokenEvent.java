/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdosoftware.mercadolibre.events;

import com.mercadolibre.sdk.Meli;
import org.springframework.context.ApplicationEvent;

/**
 *
 * @author Daniel Gago
 */
public class InvalidTokenEvent extends ApplicationEvent{
    
    public InvalidTokenEvent(Object source) {
        super(source);
    }
    
    public Meli getMeli(){
        return (Meli) this.source;
    }
    
}
