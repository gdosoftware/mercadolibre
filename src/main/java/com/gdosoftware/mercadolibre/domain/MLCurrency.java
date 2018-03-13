/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdosoftware.mercadolibre.domain;

/**
 *
 * @author Daniel Gago
 */
public class MLCurrency {
    private String id;
    private String symbol;
    private String description;
    private Integer decimal_places;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDecimal_places() {
        return decimal_places;
    }

    public void setDecimal_places(Integer decimal_places) {
        this.decimal_places = decimal_places;
    }
    
    
}
