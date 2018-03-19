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
public class MLFrom {
    private Long id;
    private Integer answered_questions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAnswered_questions() {
        return answered_questions;
    }

    public void setAnswered_questions(Integer answered_questions) {
        this.answered_questions = answered_questions;
    }
    
    
}
