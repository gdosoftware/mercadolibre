/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdosoftware.mercadolibre.api.impl;

import com.mercadolibre.sdk.Meli;
import com.gdosoftware.mercadolibre.api.ConnectionOperations;
import com.gdosoftware.mercadolibre.api.CredentialOperations;
import com.gdosoftware.mercadolibre.api.ItemOperations;
import com.gdosoftware.mercadolibre.api.MercadoLibre;
import com.gdosoftware.mercadolibre.api.QuestionOperations;
import com.gdosoftware.mercadolibre.api.ShippingOperations;
import com.gdosoftware.mercadolibre.api.SiteOperations;
import com.gdosoftware.mercadolibre.api.UserOperations;
import java.io.Serializable;

/**
 *
 * @author Daniel Gago
 */
public class MercadoLibreTemplate  implements MercadoLibre, Serializable{
    
   
    public enum Operations {ITEMS,ORDERS,QUESTIONS,SHIPPING}
  
    private Meli meli;
    
    

    public MercadoLibreTemplate(Long applicationid, String secretkey) {
        meli = new Meli(applicationid,secretkey);
    }
    
    public MercadoLibreTemplate(Long applicationid, String secretkey, Long userId) {
        this(applicationid, secretkey);
        meli.setUserId(userId);
    }
    
    

    @Override
    public UserOperations getUserOperations() {
        return new UserTemplate(meli);
    }

    @Override
    public ItemOperations getItemOperations() {
        return new ItemTemplate(meli);
    }

    @Override
    public ShippingOperations getShippingOperations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public QuestionOperations getQuestionOperations() {
        return new QuestionTemplate(meli);
    }
 

    @Override
    public ConnectionOperations getConnectionOperations() {
        return new ConnectionTemplate(meli);
    }

    @Override
    public CredentialOperations getCredentialOperations() {
        return new CredentialTemplate(meli);
    }

    @Override
    public SiteOperations getSiteOperations() {
        return new SiteTemplate(meli);
    }

    

}
