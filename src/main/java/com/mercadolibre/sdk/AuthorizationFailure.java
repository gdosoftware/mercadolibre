/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mercadolibre.sdk;

public class AuthorizationFailure extends Exception {
    private static final long serialVersionUID = 8688100047490895706L;

    public AuthorizationFailure(String message) {
	super(message);

    }     

    public AuthorizationFailure(Throwable cause) {
	super(cause);
    }
}
