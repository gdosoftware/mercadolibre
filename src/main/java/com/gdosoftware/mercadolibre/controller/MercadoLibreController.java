/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdosoftware.mercadolibre.controller;

import com.gdosoftware.mercadolibre.api.CredentialOperations;
import com.mercadolibre.sdk.AuthorizationFailure;
import com.mercadolibre.sdk.Meli;
import org.springframework.beans.factory.annotation.Autowired;
import com.gdosoftware.mercadolibre.api.MercadoLibre;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.gdosoftware.mercadolibre.connect.ConnectionPoolRepository;
import com.gdosoftware.mercadolibre.domain.MLNotify;
import com.gdosoftware.mercadolibre.domain.MLUser;
import com.gdosoftware.mercadolibre.events.CreatedOrdersEvent;
import com.gdosoftware.mercadolibre.events.ItemsEvent;
import com.gdosoftware.mercadolibre.events.MessagesEvent;
import com.gdosoftware.mercadolibre.events.OrdersEvent;
import com.gdosoftware.mercadolibre.events.PaymentsEvent;
import com.gdosoftware.mercadolibre.events.PicturesEvent;
import com.gdosoftware.mercadolibre.events.QuestionsEvent;
import com.mercadolibre.sdk.MeliException;
import java.util.Optional;
import javax.annotation.PostConstruct;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Daniel Gago
 */
@Controller
public class MercadoLibreController {
   
    @Autowired
    private MercadoLibre meli;
   
    @Autowired
    private String rootUrl;
    
    @Autowired
    private String successUrl;
        
    @Autowired
    private ApplicationEventPublisher appEventPublisher;
    
    @Autowired
    private ApplicationContext appContext;
    
    private ConnectionPoolRepository connRepo;

    
    @RequestMapping(value ="/signin" ,method = RequestMethod.GET)
    public String signin(@RequestParam(value = "site") Meli.AuthUrls site){

        String authorizeUrl = meli.getConnectionOperations().getAuthUrl(rootUrl+"/authcallback", site);
        return "redirect:"+authorizeUrl;
    }
    
    @RequestMapping(value ="/authcallback" ,method = RequestMethod.GET)
    public String authorizedCallback(@RequestParam(value = "code", required = false) String code,
                                     HttpServletRequest request) throws AuthorizationFailure, ServletException, MeliException{
       
        meli.getConnectionOperations().authorize(code, rootUrl+"/authcallback");
        CredentialOperations co = meli.getCredentialOperations();

        if(connRepo != null)
            connRepo.save(co.getUserId(), co.getAccessToken(), co.getRefreshToken(), co.getExpiresIn());

 //       request.login(co.getUserId().toString(), null);
       // MLUser user = meli.getUserOperations().getUserMe();
        Authentication auth = new PreAuthenticatedAuthenticationToken(co.getUserId(),null);
        auth.setAuthenticated(false);
        SecurityContextHolder.getContext().setAuthentication(auth);

        return "redirect:"+successUrl;
       
    }
    
     @RequestMapping(value="/notifications", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity  mlNotify(@RequestBody MLNotify notify){
       
        switch(notify.getTopic()){//estos eventos son asincronicos
            case "orders":
                appEventPublisher.publishEvent(new OrdersEvent(notify,connRepo));
                break;
            case "items":
                appEventPublisher.publishEvent(new ItemsEvent(notify,connRepo));
                break;
            case "created_orders":
                appEventPublisher.publishEvent(new CreatedOrdersEvent(notify,connRepo));
                break;
            case "questions":
                appEventPublisher.publishEvent(new QuestionsEvent(notify,connRepo));
                break;
            case "pictures":
                appEventPublisher.publishEvent(new PicturesEvent(notify,connRepo));
                break;
            case "payments":
                appEventPublisher.publishEvent(new PaymentsEvent(notify,connRepo));
                break;
            case "messages":
                appEventPublisher.publishEvent(new MessagesEvent(notify,connRepo));
                break;
        }
         System.out.println("Estoy por devolver el status 200 de notificaciones");
         return new ResponseEntity<>(HttpStatus.OK);   
    }
    
   @PostConstruct
   public void populateConnectionPoolRepository(){//no se inyecat el ConnectionPoolRepository x q puede ser nulo
        Optional.ofNullable(appContext.getBean(ConnectionPoolRepository.class)).ifPresent((cpr) -> {
                this.connRepo = cpr;
        });
   }
    
}
