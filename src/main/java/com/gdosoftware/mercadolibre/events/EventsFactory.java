/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdosoftware.mercadolibre.events;

import com.gdosoftware.mercadolibre.api.MercadoLibre;
import com.gdosoftware.mercadolibre.api.impl.MercadoLibreTemplate.Operations;
import com.gdosoftware.mercadolibre.domain.MLNotify;

/**
 *
 * @author Daniel Gago
 */
public class EventsFactory {
    public static AbstractNotificationEvent create(MLNotify notify){
        if (notify.getTopic().equals(Operations.ITEMS.name())){
                
        }
        if (notify.getTopic().equals(Operations.ORDERS.name())){
                
        }
        if (notify.getTopic().equals(Operations.QUESTIONS.name())){
                return new QuestionEvent(notify);
        }
        if (notify.getTopic().equals(Operations.SHIPPING.name())){
                
        }
        return null;
    }
}
