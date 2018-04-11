/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdosoftware.mercadolibre.domain;

import java.io.Serializable;

/**
 *
 * @author Daniel Gago
 */
public class MLItems implements Serializable{
    
    private MLPaging paging;
    private  String[] results;

    public MLPaging getPaging() {
        return paging;
    }

    public void setPaging(MLPaging paging) {
        this.paging = paging;
    }
   
    public String[] getResults() {
        return results;
    }

    public void setResults(String[] results) {
        this.results = results;
    }

    
    
    
}
