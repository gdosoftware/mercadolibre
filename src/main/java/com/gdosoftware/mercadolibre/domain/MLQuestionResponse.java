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
public class MLQuestionResponse implements Serializable{
   private Long id;
   private MLAnswer answer;
   private String date_created;
   private Boolean deleted_from_listing;
   private Boolean hold;
   private String item_id;
   private Long seller_id;
   private String status;
   private String text;
   
   //en caso de error
   
   private String message;
   private String error;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MLAnswer getAnswer() {
        return answer;
    }

    public void setAnswer(MLAnswer answer) {
        this.answer = answer;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public Boolean getDeleted_from_listing() {
        return deleted_from_listing;
    }

    public void setDeleted_from_listing(Boolean deleted_from_listing) {
        this.deleted_from_listing = deleted_from_listing;
    }

    public Boolean getHold() {
        return hold;
    }

    public void setHold(Boolean hold) {
        this.hold = hold;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public Long getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(Long seller_id) {
        this.seller_id = seller_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "MLQuestionResponse{" + "id=" + id + ", answer=" + answer + ", date_created=" + date_created + ", deleted_from_listing=" + deleted_from_listing + ", hold=" + hold + ", item_id=" + item_id + ", seller_id=" + seller_id + ", status=" + status + ", text=" + text + ", message=" + message + ", error=" + error + '}';
    }
   
   

}
