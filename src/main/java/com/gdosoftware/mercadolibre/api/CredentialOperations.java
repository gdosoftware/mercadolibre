/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdosoftware.mercadolibre.api;

import com.gdosoftware.mercadolibre.connect.Connection;
import com.mercadolibre.sdk.AuthorizationFailure;

/**
 *
 * @author Daniel Gago
 */
public interface CredentialOperations {
    public Long getUserId();
    public String getAccessToken();
    public String getRefreshToken();
    public String getTokenType();
    public Long getExpiresIn();
    public String getScope();
    public void refreshToken() throws AuthorizationFailure;
    public Connection getConnectionData();
}
