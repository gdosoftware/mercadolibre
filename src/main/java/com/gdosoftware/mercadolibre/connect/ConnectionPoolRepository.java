/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdosoftware.mercadolibre.connect;

import com.gdosoftware.mercadolibre.api.MercadoLibre;
import com.gdosoftware.mercadolibre.api.impl.MercadoLibreTemplate;

/**
 *
 * @author Daniel Gago
 */
public interface ConnectionPoolRepository {
   public String getAccessToken(Long userId);
   public String getRefreshToken(Long userId);
   public Long getExpiresIn(Long userId);
   public void save(Long userId, String accessToken, String refreshToken, Long expiresIn);
   public void delete(Long userId);
   public default MercadoLibre getApi(Long userId){
       return new MercadoLibreTemplate(userId, getAccessToken(userId), getRefreshToken(userId), getExpiresIn(userId));
   }
}
