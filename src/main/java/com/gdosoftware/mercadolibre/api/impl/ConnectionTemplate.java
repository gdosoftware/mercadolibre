/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdosoftware.mercadolibre.api.impl;

import com.gdosoftware.mercadolibre.api.ConnectionOperations;
import com.mercadolibre.sdk.AuthorizationFailure;
import com.mercadolibre.sdk.Meli;

/**
 *
 * @author Daniel Gago
 */
public class ConnectionTemplate extends AbstractMercadoLibreOperations implements ConnectionOperations{

    public ConnectionTemplate(Meli meli) {
        super(meli);
    }

    @Override
    public String getAuthUrl(String callback, Meli.AuthUrls authUrl) {
        return meli.getAuthUrl(callback, authUrl);
    }

    @Override
    public void authorize(String code, String redirectUri) throws AuthorizationFailure{
        meli.authorize(code, redirectUri);
    }

    @Override
    public void refreshToken(String refreshToken) throws AuthorizationFailure{
        meli.setRefreshToken(refreshToken);
        meli.refreshAccessToken();
    }

   
    
}
