/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdosoftware.mercadolibre.api.impl;

import com.gdosoftware.mercadolibre.api.ItemOperations;
import com.gdosoftware.mercadolibre.domain.MLItem;
import com.gdosoftware.mercadolibre.domain.MLItems;
import com.mercadolibre.sdk.Meli;
import com.mercadolibre.sdk.MeliException;


/**
 *
 * @author Daniel Gago
 */
public class ItemTemplate extends AbstractMercadoLibreOperations implements ItemOperations{
    
    public ItemTemplate(Meli meli) {
        super(meli);
    }

    @Override
    public MLItem getMLItem(String itemId) throws MeliException {
        return getForObject("/items/"+itemId, MLItem.class);
    }

    @Override
    public MLItems getMLItems() throws MeliException {
         return getForObject("/users/"+meli.getUserId()+"/items/search", MLItems.class, createParamsWithToken().add("status", "active"));
        
    }
    
}
