/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdosoftware.mercadolibre.api.impl;

import com.mercadolibre.sdk.Meli;
import com.gdosoftware.mercadolibre.api.CategoryOperations;
import com.gdosoftware.mercadolibre.api.ConnectionOperations;
import com.gdosoftware.mercadolibre.api.CredentialOperations;
import com.gdosoftware.mercadolibre.api.ItemOperations;
import com.gdosoftware.mercadolibre.api.MercadoLibre;
import com.gdosoftware.mercadolibre.api.QuestionOperations;
import com.gdosoftware.mercadolibre.api.ShippingOperations;
import com.gdosoftware.mercadolibre.api.UserOperations;

/**
 *
 * @author Daniel Gago
 */
public class MercadoLibreTemplate extends Meli implements MercadoLibre{
    

    public MercadoLibreTemplate(Long clientId, String clientSecret) {
        super(clientId, clientSecret);
    }

    @Override
    public UserOperations getUserOperations() {
        return new UserTemplate(this);
    }

    @Override
    public ItemOperations getItemOperations() {
        return new ItemTemplate(this);
    }

    @Override
    public ShippingOperations getShippingOperations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public QuestionOperations getQuestionOperations() {
        return new QuestionTemplate(this);
    }

    @Override
    public CategoryOperations getCategoryOperations() {
       return new CategoryTemplate(this);
    }

    @Override
    public ConnectionOperations getConnectionOperations() {
        return new ConnectionTemplate(this);
    }

    @Override
    public CredentialOperations getCredentialOperations() {
        return new CredentialTemplate(this);
    }

    
    
    
}
