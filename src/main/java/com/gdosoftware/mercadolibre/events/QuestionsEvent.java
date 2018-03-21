/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdosoftware.mercadolibre.events;

import com.gdosoftware.mercadolibre.connect.ConnectionPoolRepository;
import com.gdosoftware.mercadolibre.domain.MLQuestion;
import com.mercadolibre.sdk.MeliException;
import java.util.Optional;


/**
 *
 * @author Daniel Gago
 */
public class QuestionsEvent extends AbstractMLNotificationsEvent{
    
    public QuestionsEvent(Object source, ConnectionPoolRepository connRepo) {
        super(source, connRepo);
    }
    
    public MLQuestion getQuestion() throws MeliException{
               
        if(mercadoLibre != null)
            return mercadoLibre.getQuestionOperations().getQuestion(Long.parseLong(getResourceId()));
        
        return null;        
    }
    
}
