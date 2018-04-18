/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdosoftware.mercadolibre.api;

/**
 *
 * @author Daniel Gago
 */
public interface MercadoLibre {
    public ConnectionOperations getConnectionOperations();
    public CredentialOperations getCredentialOperations();
    public UserOperations getUserOperations();
    public ItemOperations getItemOperations();
    public ShippingOperations getShippingOperations();
    public QuestionOperations getQuestionOperations();
    public SiteOperations getSiteOperations();
    public MercadoLibre copy();
    
}
