/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdosoftware.mercadolibre.api.impl;

import com.gdosoftware.mercadolibre.api.ConnectionPoolRepository;
import com.google.gson.Gson;
import com.mercadolibre.sdk.AuthorizationFailure;
import com.mercadolibre.sdk.Meli;
import com.mercadolibre.sdk.MeliException;
import com.ning.http.client.FluentStringsMap;
import com.ning.http.client.Response;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Daniel Gago
 */
public abstract class AbstractMercadoLibreOperations {
    
    @Autowired
    private ConnectionPoolRepository connRepo;
      
    protected Meli meli;
    
    
    protected final int LIMIT = 50;

    public AbstractMercadoLibreOperations(Meli meli) {
        this.meli = meli;
    }

    protected FluentStringsMap createParamsWithToken(){
        if(meli.getExpiresIn() < System.currentTimeMillis()){//esto sirve para uso online
            try {
                meli.refreshAccessToken();
                connRepo.UpdateCredentials(meli.getUserId(), meli.getAccessToken(), meli.getRefreshToken(), meli.getExpiresIn());
            } catch (AuthorizationFailure ex) {
                Logger.getLogger(AbstractMercadoLibreOperations.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        FluentStringsMap params = new FluentStringsMap();
        return params.add("access_token", meli.getAccessToken());
    }
    
    protected FluentStringsMap createParams(){
        return new FluentStringsMap();
    }
    
    protected <T> T getForObject(String path, Class<T> clazz) throws MeliException{
        Gson gson = new Gson();
        Response response = meli.get(path);
        try {
            return gson.fromJson(response.getResponseBody(), clazz);
        } catch (IOException ex) {
            Logger.getLogger(AbstractMercadoLibreOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
   }
    
   protected <T> T getForObject(String path, Class<T> clazz, FluentStringsMap params) throws MeliException{
        Gson gson = new Gson();
        Response response = meli.get(path,params);
        try {
            return gson.fromJson(response.getResponseBody(), clazz);
        } catch (IOException ex) {
            Logger.getLogger(AbstractMercadoLibreOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
   }
   
  
   
   protected <T> T postForObject(String path, Class<T> clazz, FluentStringsMap params, String body) throws MeliException{
        Gson gson = new Gson();
        Response response = meli.post(path,params,body);
        try {
            return gson.fromJson(response.getResponseBody(), clazz);
        } catch (IOException ex) {
            Logger.getLogger(AbstractMercadoLibreOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
   }
   
    protected void postForObject(String path, FluentStringsMap params, String body) throws MeliException{
        Gson gson = new Gson();
        Response response = meli.post(path,params,body);
       
   }
   
    protected void delete(String path, FluentStringsMap params) throws MeliException{
        Gson gson = new Gson();
        Response response = meli.delete(path,params);
   }
}
