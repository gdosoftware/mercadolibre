/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdosoftware.mercadolibre.events;

import com.gdosoftware.mercadolibre.connect.ConnectionPoolRepository;


/**
 *
 * @author Daniel Gago
 */
public class MessagesEvent extends AbstractMLNotificationsEvent{
    
    public MessagesEvent(Object source, ConnectionPoolRepository connRepo) {
        super(source, connRepo);
    }
    
}
