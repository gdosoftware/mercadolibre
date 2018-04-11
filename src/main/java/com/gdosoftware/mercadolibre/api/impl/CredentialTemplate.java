/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdosoftware.mercadolibre.api.impl;

import com.gdosoftware.mercadolibre.api.CredentialOperations;
import com.mercadolibre.sdk.AuthorizationFailure;
import com.mercadolibre.sdk.Meli;


/**
 *
 * @author Daniel Gago
 */
public class CredentialTemplate extends AbstractMercadoLibreOperations implements CredentialOperations{

    public CredentialTemplate(Meli meli) {
        super(meli);
    }

    @Override
    public Long getUserId() {
        return meli.getUserId();
    }

    @Override
    public String getAccessToken() {
        return meli.getAccessToken();
    }

    @Override
    public String getRefreshToken() {
        return meli.getRefreshToken();
    }

    @Override
    public String getTokenType() {
        return meli.getTokenType();
    }

    @Override
    public Long getExpiresIn() {
        return meli.getExpiresIn();
    }

    @Override
    public String getScope() {
        return meli.getScope();
    }

    @Override
    public void setAccessToken(String accessToken) {
        meli.setAccessToken(accessToken);
    }

    @Override
    public void setRefreshToken(String refreshToken) {
        meli.setRefreshToken(refreshToken);
    }

    @Override
    public void setExpiresIn(Long expiresIn) {
        meli.setExpiresIn(expiresIn);
    }

    @Override
    public void setUserId(Long userId) {
        meli.setUserId(userId);
    }

  
   
    
}
