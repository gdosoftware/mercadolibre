/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdosoftware.mercadolibre.connect;

import com.gdosoftware.mercadolibre.api.MercadoLibre;

/**
 *
 * @author Daniel Gago
 */
public interface ConnectionRepository {
   public MercadoLibre getApi(Long userId);
   public Connection getConnection(Long userId);
   public void saveConnection(Connection conecction);
}
