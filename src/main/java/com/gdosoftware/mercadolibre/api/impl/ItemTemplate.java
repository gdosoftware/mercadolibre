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
import com.ning.http.client.FluentStringsMap;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Daniel Gago
 */
public class ItemTemplate extends AbstractMercadoLibreOperations implements ItemOperations{
    
    public ItemTemplate(Meli meli) {
        super(meli);
    }

    @Override
    public MLItem getItem(String itemId) throws MeliException {
        return getForObject("/items/"+itemId, MLItem.class);
    }

     @Override
    public MLItem getItem(String itemId, String attributes) throws MeliException {
        return getForObject("/items/"+itemId, MLItem.class, createParams().add("attributes", attributes));
    }
    
    @Override
    public List<MLItem> getItems() throws MeliException {
        return getItems(null);
    }
    
    @Override
    public List<MLItem> getItems(String attributes) throws MeliException {
        List<MLItem> items = new ArrayList<>();
        int offset = 0;
        int total = Integer.MAX_VALUE;
        
        while (total > offset ){
            FluentStringsMap params = createParamsWithToken().add("status","active")
                                                             .add("limit",String.valueOf(LIMIT))
                                                             .add("offset",String.valueOf(offset));
            
            MLItems list = getForObject("/users/"+meli.getUserId()+"/items/search", MLItems.class, params);
            if(list.getResults() != null){
                for(String it : list.getResults()){
                    items.add(getItem(it, attributes));
                }    
                total = list.getPaging().getTotal();
                offset += 50;
            }
        }
       
        return items;
    }
    
}
