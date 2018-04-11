/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdosoftware.mercadolibre.domain;

import java.io.Serializable;

/**
 *
 * @author Daniel Gago
 */
public class MLQuestion implements Serializable{
    
    private Long id;
    private Long seller_id;
    private String text;
    private String status;
    private String item_id;
    private String date_created;
    private Boolean hold;
    private Boolean deleted_from_listing;
    private MLAnswer answer;
    private MLFrom from;
    //Custom prop
    private Boolean newQuestion=true;
   
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

  
    public Long getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(Long seller_id) {
        this.seller_id = seller_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public Boolean getHold() {
        return hold;
    }

    public void setHold(Boolean hold) {
        this.hold = hold;
    }

    public Boolean getDeleted_from_listing() {
        return deleted_from_listing;
    }

    public void setDeleted_from_listing(Boolean deleted_from_listing) {
        this.deleted_from_listing = deleted_from_listing;
    }

    public MLAnswer getAnswer() {
        return answer;
    }

    public void setAnswer(MLAnswer answer) {
        this.answer = answer;
    }

   
    public MLFrom getFrom() {
        return from;
    }

    public void setFrom(MLFrom from) {
        this.from = from;
    }

    public Boolean getNewQuestion() {
        return newQuestion;
    }

    public void setNewQuestion(Boolean newQuestion) {
        this.newQuestion = newQuestion;
    }

    @Override
    public String toString() {
        return "MLQuestion{" + "id=" + id + ", seller_id=" + seller_id + ", text=" + text + ", status=" + status + ", item_id=" + item_id + ", date_created=" + date_created + ", hold=" + hold + ", deleted_from_listing=" + deleted_from_listing + ", answer=" + answer + ", from=" + from + ", newQuestion=" + newQuestion + '}';
    }

   

 
    

}
