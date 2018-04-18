/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdosoftware.mercadolibre.controller;

import com.gdosoftware.mercadolibre.MercadoLibreFactory;
import com.gdosoftware.mercadolibre.api.ConnectionPoolRepository;
import com.gdosoftware.mercadolibre.api.CredentialOperations;
import com.gdosoftware.mercadolibre.api.MercadoLibre;
import com.gdosoftware.mercadolibre.domain.MLNotify;
import com.gdosoftware.mercadolibre.events.EventsFactory;
import com.gdosoftware.mercadolibre.events.QuestionEvent;
import com.mercadolibre.sdk.AuthorizationFailure;
import com.mercadolibre.sdk.Meli;
import com.mercadolibre.sdk.MeliException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;

/**
 *
 * @author Daniel Gago
 */
@Controller
@RequestMapping("ml")
public class MLController {
    
    
    @Value("${com.gdosoftware.mercadolibre.applicationid}")
    private Long applicationId;
    @Value("${com.gdosoftware.mercadolibre.secretkey}")
    private String secretKey;
    @Value("${com.gdosoftware.mercadolibre.authcallback}")
    private String authCallbackUrl;
    
    @Autowired
    private MercadoLibre meliService;
       
    @Autowired
    private ApplicationEventPublisher publisher;
    
    @Autowired
    private ConnectionPoolRepository connRepo;
    
    
    @RequestMapping(value ="signin" ,method = RequestMethod.GET)
    public String signin(@RequestParam(value = "site") Meli.AuthUrls site){

        String authorizeUrl = meliService.getConnectionOperations().getAuthUrl(authCallbackUrl, site);
        return "redirect:"+authorizeUrl;
    }
    
    
    @RequestMapping(value ="authcallback" ,method = RequestMethod.GET)
    public String authorizedCallback(@RequestParam(value = "code", required = false) String code,
                                     @RequestParam(value = "state", required = false) String state,
                                     HttpServletRequest request) throws AuthorizationFailure, ServletException, MeliException{
       
        meliService.getConnectionOperations().authorize(code, authCallbackUrl);
        CredentialOperations co = meliService.getCredentialOperations();
        Authentication auth = new PreAuthenticatedAuthenticationToken(co.getUserId(),null);
        auth.setAuthenticated(false);
        SecurityContextHolder.getContext().setAuthentication(auth);

        return "redirect:/successLogin";
       
    }
    
     @RequestMapping(value="notifications", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity  mlNotify(@RequestBody MLNotify notify, HttpServletRequest request){
        
         System.out.println("NOtifications: "+notify.toString());
         MercadoLibre mercadolibre = MercadoLibreFactory.create(applicationId, secretKey, notify.getUser_id());
         publisher.publishEvent(EventsFactory.create(notify, mercadolibre));
         
         return new ResponseEntity<>(HttpStatus.OK);   
    }
    
    
    
}
