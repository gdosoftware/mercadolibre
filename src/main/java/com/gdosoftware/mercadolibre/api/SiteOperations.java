/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdosoftware.mercadolibre.api;

import com.gdosoftware.mercadolibre.domain.MLCategory;
import com.gdosoftware.mercadolibre.domain.MLCountry;
import com.gdosoftware.mercadolibre.domain.MLCurrency;
import com.mercadolibre.sdk.MeliException;
import java.util.List;

/**
 *
 * @author Daniel Gago
 */
public interface SiteOperations {
  public MLCategory[] getRootCategory(String site) throws MeliException;
  public MLCategory getCategory(String id) throws MeliException;
  public List<MLCountry> getAvailableCountries() throws MeliException;
  public MLCurrency getCurrency(String currencyId) throws MeliException;
  
}
