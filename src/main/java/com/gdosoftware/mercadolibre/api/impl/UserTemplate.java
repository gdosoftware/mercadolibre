/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdosoftware.mercadolibre.api.impl;

import com.mercadolibre.sdk.Meli;
import com.mercadolibre.sdk.MeliException;
import com.gdosoftware.mercadolibre.api.UserOperations;
import com.gdosoftware.mercadolibre.domain.MLUser;

/**
 *
 * @author Daniel Gago
 */
public class UserTemplate extends AbstractMercadoLibreOperations implements UserOperations{
    

    public UserTemplate(Meli meli) {
        super(meli);
    }

    @Override
    public MLUser getUserMe() throws MeliException{
        return getForObject("/users/me", MLUser.class, createParamsWithToken());
    }

    @Override
    public MLUser getPublicInfo(Long userId) throws MeliException{
        return getForObject("/users/"+userId, MLUser.class);
    }

    @Override
    public MLUser getUser(Long userId) throws MeliException{
        return getForObject("/users/"+userId, MLUser.class, createParamsWithToken());
    }
    
   
       
}
