/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdosoftware.mercadolibre;

import com.gdosoftware.mercadolibre.api.MercadoLibre;
import com.gdosoftware.mercadolibre.api.impl.MercadoLibreTemplate;

/**
 *
 * @author Daniel Gago
 */
public class MercadoLibreFactory {
   
    public static MercadoLibre create(Long applicationId, String secretKey){
        return new MercadoLibreTemplate(applicationId, secretKey);
    }
     
    
    public static MercadoLibre create(Long applicationId, String secretKey, Long userId){
        return new MercadoLibreTemplate(applicationId, secretKey, userId);
    }
}
