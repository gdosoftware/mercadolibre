/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdosoftware.mercadolibre.api;

import com.gdosoftware.mercadolibre.domain.MLQuestion;
import com.gdosoftware.mercadolibre.domain.MLQuestionResponse;
import com.gdosoftware.mercadolibre.domain.MLQuestions;
import com.mercadolibre.sdk.MeliException;


/**
 *
 * @author Daniel Gago
 */
public interface QuestionOperations {
    public enum Status {ANSWERED,UNANSWERED, BANNED,CLOSED_UNANSWERED,DELETED,DISABLED,UNDER_REVIEW};
    
    public MLQuestions getQuestionsBySeller(Status status)  throws MeliException;
    public MLQuestions getQuestionsByItemAndBuyer(String itemId, Long buyerId, Status status) throws MeliException;
    public MLQuestions getQuestionsByItem(String itemId, Status status) throws MeliException;
    public MLQuestion getQuestion(Long questionId) throws MeliException;
    public void deleteQuestion(Long questionId) throws MeliException;
    public MLQuestionResponse answer (Long questionId, String answer) throws MeliException;
    public void postQuestion(String itemId, String question) throws MeliException;
}
