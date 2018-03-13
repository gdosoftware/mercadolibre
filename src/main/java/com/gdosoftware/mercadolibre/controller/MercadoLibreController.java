/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdosoftware.mercadolibre.controller;

import com.mercadolibre.sdk.AuthorizationFailure;
import com.mercadolibre.sdk.Meli;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.gdosoftware.mercadolibre.api.MercadoLibre;
import com.gdosoftware.mercadolibre.connect.ConnectionRepository;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Daniel Gago
 */
@Controller
public class MercadoLibreController {
   
    @Autowired
    private MercadoLibre meli;
   
    @Autowired
    private String callbackUrl;
    
    @Autowired
    private String successPage;
    
       
    @Autowired
    private ConnectionRepository conRepo;

    
    @RequestMapping(value ="/signin" ,method = RequestMethod.GET)
    public String signin(@RequestParam(value = "site") Meli.AuthUrls site){

        String authorizeUrl = meli.getConnectionOperations().getAuthUrl(callbackUrl, site);
        return "redirect:"+authorizeUrl;
    }
    
    @RequestMapping(value ="/authcallback" ,method = RequestMethod.GET)
    public String authorizedCallback(@RequestParam(value = "code", required = false) String code,
                                     HttpServletRequest request) throws AuthorizationFailure{
       
            meli.getConnectionOperations().authorize(code, callbackUrl);
            conRepo.saveConnection(meli.getCredentialOperations().getConnectionData());
            try {
                request.login(meli.getCredentialOperations().getUserId().toString(), null);
            } catch (ServletException ex) {
                Logger.getLogger(MercadoLibreController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return "redirect:"+successPage;
       
    }
    
   
    
}
