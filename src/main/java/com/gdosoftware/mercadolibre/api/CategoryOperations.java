/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdosoftware.mercadolibre.api;

import com.gdosoftware.mercadolibre.domain.MLCategory;
import com.mercadolibre.sdk.MeliException;

/**
 *
 * @author Daniel Gago
 */
public interface CategoryOperations {
    
    public MLCategory[] getRootCategory(String site) throws MeliException;
    public MLCategory getCategory(String id) throws MeliException;
    
}
