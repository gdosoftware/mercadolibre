/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdosoftware.mercadolibre.api.impl;

import com.mercadolibre.sdk.Meli;
import com.mercadolibre.sdk.MeliException;
import com.gdosoftware.mercadolibre.api.QuestionOperations;
import com.gdosoftware.mercadolibre.domain.MLQuestion;
import com.gdosoftware.mercadolibre.domain.MLQuestionResponse;
import com.gdosoftware.mercadolibre.domain.MLQuestions;
import com.ning.http.client.FluentStringsMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Daniel Gago
 */
public class QuestionTemplate extends AbstractMercadoLibreOperations implements QuestionOperations{

    public QuestionTemplate(Meli meli) {
        super(meli);
    }
    
    @Override
    public List<MLQuestion> getQuestionsBySeller(Status status) throws MeliException{
        List<MLQuestion> questions = new ArrayList<>();
        int offset = 0;
        int total = Integer.MAX_VALUE;
        
        while (total > offset ){
            FluentStringsMap params = createParamsWithToken().add("seller_id", meli.getUserId().toString())
                                                             .add("status",status.name())
                                                             .add("limit",String.valueOf(LIMIT))
                                                             .add("offset",String.valueOf(offset));
            MLQuestions mlquestions = getForObject("/questions/search", MLQuestions.class, params);
            questions.addAll(Arrays.asList(mlquestions.getQuestions()));
            total = mlquestions.getTotal();
            offset += 50;
        }
        
        return questions;
       
    }
    
     @Override
    public List<MLQuestion> getQuestionsByItemAndBuyer(String itemId, Long buyerId, Status status) throws MeliException {
        List<MLQuestion> questions = new ArrayList<>();
        int offset = 0;
        int total = Integer.MAX_VALUE;
        
        while (total > offset ){
            FluentStringsMap params = createParamsWithToken().add("item", itemId)
                                                             .add("status",status.name())  
                                                             .add("from",buyerId.toString())
                                                             .add("limit",String.valueOf(LIMIT))
                                                             .add("offset",String.valueOf(offset));
            MLQuestions mlquestions = getForObject("/questions/search", MLQuestions.class, params);
            questions.addAll(Arrays.asList(mlquestions.getQuestions()));
            total = mlquestions.getTotal();
            offset += 50;
        }
        
        return questions;
        
    }

    @Override
    public  List<MLQuestion> getQuestionsByItem(String itemId, Status status) throws MeliException {
        
        List<MLQuestion> questions = new ArrayList<>();
        int offset = 0;
        int total = Integer.MAX_VALUE;
        
        while (total > offset ){
            FluentStringsMap params = createParamsWithToken().add("item", itemId)
                                                             .add("status",status.name())  
                                                             .add("limit",String.valueOf(LIMIT))
                                                             .add("offset",String.valueOf(offset));
            MLQuestions mlquestions = getForObject("/questions/search", MLQuestions.class, params);
            questions.addAll(Arrays.asList(mlquestions.getQuestions()));
            total = mlquestions.getTotal();
            offset += 50;
        }
        
        return questions;
    }

    @Override
    public void deleteQuestion(Long questionId) throws MeliException {
        delete("/questions/"+questionId, createParamsWithToken());
    }

    @Override
    public MLQuestionResponse answer(Long questionId, String answer) throws MeliException {
        String ans = answer.replace("\n", " ").replace("\r", "");
        return postForObject("/answers", MLQuestionResponse.class, createParamsWithToken(), "{\"question_id\":"+questionId+",\"text\":\""+ans+"\"}");
    }

    @Override
    public void postQuestion(String itemId, String question) throws MeliException {
        
        postForObject("/questions/"+itemId, createParams(), "{\"item_id\":"+itemId+",\"text\":\""+question+"\"}");
    }

    @Override
    public MLQuestion getQuestion(Long questionId) throws MeliException {
        return getForObject("/questions/"+questionId, MLQuestion.class, createParamsWithToken());
    }

    
}
