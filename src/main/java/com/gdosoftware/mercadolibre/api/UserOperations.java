/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdosoftware.mercadolibre.api;

import com.gdosoftware.mercadolibre.domain.MLUser;
import com.mercadolibre.sdk.MeliException;

/**
 *
 * @author Daniel Gago
 */
public interface UserOperations {
    public MLUser getUserMe() throws MeliException;
    public MLUser getPublicInfo(Long userId) throws MeliException;
    public MLUser getUser(Long userId) throws MeliException;
}
