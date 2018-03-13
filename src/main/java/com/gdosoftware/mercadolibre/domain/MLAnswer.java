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
public class MLAnswer {
    private String text;
    private String status;
    private String date_created;

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

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    @Override
    public String toString() {
        return "MLAnswer{" + "text=" + text + ", status=" + status + ", date_created=" + date_created + '}';
    }
    
    
}
