/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdosoftware.mercadolibre.api.impl;

import com.gdosoftware.mercadolibre.api.SiteOperations;
import com.gdosoftware.mercadolibre.domain.MLCategory;
import com.gdosoftware.mercadolibre.domain.MLCountry;
import com.gdosoftware.mercadolibre.domain.MLCurrency;
import com.mercadolibre.sdk.Meli;
import com.mercadolibre.sdk.MeliException;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Daniel Gago
 */
public class SiteTemplate extends AbstractMercadoLibreOperations implements SiteOperations{
    
    public SiteTemplate(Meli meli) {
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

    @Override
    public List<MLCountry> getAvailableCountries() throws MeliException{
        MLCountry[] countries = getForObject("/classified_locations/countries", MLCountry[].class);
        return Arrays.asList(countries);
    }

    @Override
    public MLCurrency getCurrency(String currencyId) throws MeliException{
        return getForObject("/currencies/"+currencyId, MLCurrency.class);
    }
    
}
