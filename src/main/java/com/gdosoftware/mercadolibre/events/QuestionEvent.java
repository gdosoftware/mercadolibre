/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdosoftware.mercadolibre.events;

import com.gdosoftware.mercadolibre.api.MercadoLibre;
import com.gdosoftware.mercadolibre.domain.MLQuestion;
import com.mercadolibre.sdk.MeliException;

/**
 *
 * @author Dani
 */

public class QuestionEvent extends AbstractNotificationEvent{
    
    public QuestionEvent(Object source) {
        super(source);
    }
            
}
