/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdosoftware.mercadolibre.api.impl;

import com.gdosoftware.mercadolibre.api.CategoryOperations;
import com.gdosoftware.mercadolibre.domain.MLCategory;
import com.mercadolibre.sdk.Meli;
import com.mercadolibre.sdk.MeliException;

/**
 *
 * @author Daniel Gago
 */
public class CategoryTemplate extends AbstractMercadoLibreOperations implements CategoryOperations{

    public CategoryTemplate(Meli meli) {
        super(meli);
    }

    @Override
    public MLCategory[] getRootCategory(String site) throws MeliException {
         
         return getForObject("/sites/"+site+"/categories", MLCategory[].class);
    }

    @Override
    public MLCategory getCategory(String id) throws MeliException {
       
        return getForObject("/categories/"+id, MLCategory.class);
    }
    
}
