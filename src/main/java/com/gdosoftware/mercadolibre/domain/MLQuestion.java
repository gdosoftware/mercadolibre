/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdosoftware.mercadolibre.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel Gago
 */
public class MLQuestion {
    
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
    //custom
    private String suggested;
    
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

    public String getSuggested() {
        return suggested;
    }

    public void setSuggested(String suggested) {
        this.suggested = suggested;
    }

    public MLFrom getFrom() {
        return from;
    }

    public void setFrom(MLFrom from) {
        this.from = from;
    }

    

   
//
//    public String elpasedTime() {
//        String result="";
//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
//            Date ini = sdf.parse(date_created);
//            Date today = new Date();
//            Long diff = today.getTime() - ini.getTime();
//            int days = (int) (diff / 86400000) ;
//            int hours = (int) (diff / 3600000);
//            int minutes = (int) (diff / 60000 );
//            if( days == 1) 
//                   result = "Hace 1 dia";
//            else
//                if( days > 1)
//                    result = "Hace "+days+" dias";
//                else
//                    if(hours == 1)
//                        result = "Hace 1 Hora";
//                    else
//                        if (hours > 1)
//                           result = "Hace "+hours+" Horas";
//                         else
//                            if(minutes == 1)
//                                result = "Hace 1 Minuto";
//                            else
//                                result = "Hace "+minutes+" Minutos";
//            
//        } catch (ParseException ex) {
//            Logger.getLogger(MLQuestion.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return result;
//    }
    

}
