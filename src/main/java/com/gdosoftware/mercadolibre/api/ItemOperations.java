/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdosoftware.mercadolibre.api;

import com.gdosoftware.mercadolibre.domain.MLItem;
import com.gdosoftware.mercadolibre.domain.MLItems;
import com.mercadolibre.sdk.MeliException;

/**
 *
 * @author Daniel Gago
 */
public interface ItemOperations {
    
     public MLItem getMLItem (String itemId) throws MeliException;
     public MLItems getMLItems() throws MeliException;
    
}
