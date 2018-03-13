/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdosoftware.mercadolibre.api;

import com.mercadolibre.sdk.AuthorizationFailure;
import com.mercadolibre.sdk.Meli.AuthUrls;

/**
 *
 * @author Daniel Gago
 */
public interface ConnectionOperations {
    public String getAuthUrl(String callback, AuthUrls authUrl);
    public void authorize(String code, String redirectUri) throws AuthorizationFailure;
}
