/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gdosoftware.mercadolibre.domain;

import java.io.Serializable;

/**
 *
 * @author Daniel
 */
public class MLNotify implements Serializable{
   private String resource;
   private Long user_id;
   private String topic;
   private String received;
   private String sent;
   private int attempts;

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getReceived() {
        return received;
    }

    public void setReceived(String received) {
        this.received = received;
    }

    public String getSent() {
        return sent;
    }

    public void setSent(String sent) {
        this.sent = sent;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }
    
    public String getResourceId(){
        return resource.split("/")[2];
    }           
    
    public String getUid(){
        return "ML"+getResourceId();
    }

    @Override
    public String toString() {
        return "MLNotify{" + "resource=" + resource + ", user_id=" + user_id + ", topic=" + topic + ", received=" + received + ", sent=" + sent + ", attempts=" + attempts + '}';
    }
    
   
   
}
