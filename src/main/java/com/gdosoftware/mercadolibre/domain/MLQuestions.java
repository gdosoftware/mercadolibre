/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdosoftware.mercadolibre.domain;

/**
 *
 * @author Daniel Gago
 */
public class MLQuestions {
    private Integer total;
    private Integer limit;
    private MLQuestion[] questions;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public MLQuestion[] getQuestions() {
        return questions;
    }

    public void setQuestions(MLQuestion[] questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(MLQuestion q : questions){
            sb.append(q.toString());
            sb.append("\n");
            sb.append("\n");
        }
        return sb.toString();
    }
    
    
}
