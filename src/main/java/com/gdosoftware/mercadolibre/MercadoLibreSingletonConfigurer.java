/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdosoftware.mercadolibre;

import com.gdosoftware.mercadolibre.api.MercadoLibre;
import com.gdosoftware.mercadolibre.api.impl.MercadoLibreTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

/**
 *
 * @author Dani
 */
public abstract class MercadoLibreSingletonConfigurer extends AbstractMercadoLibreConfigurer{
    
    @Bean
    public MercadoLibre populateApi(Environment env){
        return new MercadoLibreTemplate();
    }
    
}
