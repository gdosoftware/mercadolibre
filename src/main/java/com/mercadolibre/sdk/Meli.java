/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mercadolibre.sdk;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.ExecutionException;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.AsyncHttpClient.BoundRequestBuilder;
import com.ning.http.client.FluentStringsMap;
import com.ning.http.client.Response;
import java.io.Serializable;
/**
 * 
 * @author
 * cambios desde version original
 * cambio userId de String a Long
 *  * 
 * agrego system.currentMillis 
 * this.expiresIn = jsonElementExpires != null ? Long.parseLong(object.get(
                                            "expires_in").getAsString())*1000+ System.currentTimeMillis(): null;
  * hago meli serializable para soportar spring redis session
  * afrego setters para userId, accessToken, refreshToken, expiresIn
  * AsyncHttpClient se crea y cierra en cada get(post/delete/put) para evitar la cumulacion de tareas en el worker que no se cierran y lo 
  * terminan por colapsar
 */

public class Meli implements Serializable{
    
	public static String apiUrl = "https://api.mercadolibre.com";
 
	/**
	 *	Availables auth sites. One user - application can only operate in one site
	 
	 */

	public static enum AuthUrls {
		MLA("https://auth.mercadolibre.com.ar"), // Argentina 
		MLB("https://auth.mercadolivre.com.br"), // Brasil
		MCO("https://auth.mercadolibre.com.co"), // Colombia
		MCR("https://auth.mercadolibre.com.cr"), // Costa Rica
		MEC("https://auth.mercadolibre.com.ec"), // Ecuador
                MLC("https://auth.mercadolibre.cl"), // Chile
		MLM("https://auth.mercadolibre.com.mx"), // Mexico
		MLU("https://auth.mercadolibre.com.uy"), // Uruguay
		MLV("https://auth.mercadolibre.com.ve"), // Venezuela
		MPA("https://auth.mercadolibre.com.pa"), // Panama
		MPE("https://auth.mercadolibre.com.pe"), // Peru
		MPT("https://auth.mercadolibre.com.pt"), // Portugal
		MRD("https://auth.mercadolibre.com.do"); // Dominicana
		
		private String value;
		

                private AuthUrls(String value) {
                    this.value = value;
                }

                public String getValue() {
                        return value;
                }
	};
    
        private String accessToken;
        private String refreshToken;
        private Long clientId;
        private String clientSecret;
        //private final AsyncHttpClient http = new AsyncHttpClient(new AsyncHttpClientConfig.Builder().setUserAgent("MELI-JAVA-SDK-0.0.4").build());
        /** news **/
        private Long   expiresIn;
        private String scope;
        private Long userId; //change from String to Long
        private String tokenType;

    
    
//        {
//            AsyncHttpClientConfig cf = new AsyncHttpClientConfig.Builder()
//                     .setUserAgent("MELI-JAVA-SDK-0.0.4").build();
//            http = new AsyncHttpClient(cf);
//        } 
        
        private AsyncHttpClient http(){
            AsyncHttpClientConfig cf = new AsyncHttpClientConfig.Builder()
                     .setUserAgent("MELI-JAVA-SDK-0.0.4").build();
            return new AsyncHttpClient(cf);
        }

        public Meli(Long clientId, String clientSecret) {
                this.clientId = clientId;
                this.clientSecret = clientSecret;
        }

        public Meli(Long clientId, String clientSecret, String accessToken) {
                this.accessToken = accessToken;
                this.clientId = clientId;
                this.clientSecret = clientSecret;
        }

        public Meli(Long clientId, String clientSecret, String accessToken, String refreshToken) {
                this.accessToken = accessToken;
                this.clientId = clientId;
                this.clientSecret = clientSecret;
                this.refreshToken = refreshToken;
        }
      

        public String getAccessToken() {
            return this.accessToken;
        }

        public String getRefreshToken() {
            return this.refreshToken;
        }
        /** news **/
        public Long getExpiresIn() {
            return this.expiresIn;
        }

        public String getScope() {
            return this.scope;
        }

        public Long getUserId() {
            return this.userId;
        }

        public String getTokenType() {
            return this.tokenType;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public void setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
        }

        public void setExpiresIn(Long expiresIn) {
            this.expiresIn = expiresIn;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }
        
        

        public Response get(String path) throws MeliException {
            return get(path, new FluentStringsMap());
        }

        private BoundRequestBuilder prepareGet(String path, FluentStringsMap params, AsyncHttpClient http) {
                    return http.prepareGet(apiUrl + path)
                            .addHeader("Accept", "application/json")
                            .setQueryParameters(params);
        }


	private BoundRequestBuilder prepareDelete(String path, FluentStringsMap params, AsyncHttpClient http) {
		return http.prepareDelete(apiUrl + path)
				.addHeader("Accept", "application/json")
				.setQueryParameters(params);
	}

	private BoundRequestBuilder preparePost(String path, FluentStringsMap params, String body, AsyncHttpClient http) {
		return http.preparePost(apiUrl + path)
				.addHeader("Accept", "application/json")
				.setQueryParameters(params)
				.setHeader("Content-Type", "application/json").setBody(body)
				.setBodyEncoding("UTF-8");
	}

	private BoundRequestBuilder preparePut(String path, FluentStringsMap params, String body, AsyncHttpClient http) {
		return http.preparePut(apiUrl + path)
				.addHeader("Accept", "application/json")
				.setQueryParameters(params)
				.setHeader("Content-Type", "application/json").setBody(body)
				.setBodyEncoding("UTF-8");
	}

	private BoundRequestBuilder preparePost(String path, FluentStringsMap params, AsyncHttpClient http) {
		return http.preparePost(apiUrl + path)
				.addHeader("Accept", "application/json")
				.setQueryParameters(params);
	}



	public Response get(String path, FluentStringsMap params) throws MeliException {
                
                AsyncHttpClient http = http();
            
		BoundRequestBuilder r = prepareGet(path, params, http);

		Response response;
		try {
			response = r.execute().get();
		} catch (Exception e) {
			throw new MeliException(e);
		}
            
                http.close();
		
		return response;
	}
        
        public Response post(String path, FluentStringsMap params, String body) throws MeliException {

                 AsyncHttpClient http = http();
            
		BoundRequestBuilder r = preparePost(path, params, body, http());

		Response response;
		try {
			response = r.execute().get();
		} catch (Exception e) {
			throw new MeliException(e);
		}

                http().close();
		
		return response;
	}

	public Response put(String path, FluentStringsMap params, String body) throws MeliException {

		 AsyncHttpClient http = http();
            
                BoundRequestBuilder r = preparePut(path, params, body, http);

		Response response;
		try {
			response = r.execute().get();
		} catch (Exception e) {
			throw new MeliException(e);
		}
                
                http.close();
		
		return response;
	}

	public Response delete(String path, FluentStringsMap params) throws MeliException {
            
                 AsyncHttpClient http = http();
            
		BoundRequestBuilder r = prepareDelete(path, params, http);

		Response response;
		try {
			response = r.execute().get();
		} catch (Exception e) {
			throw new MeliException(e);
		}
                
                http.close();
		
		return response;
	}

        public BoundRequestBuilder head(String path) {
            return null;
        }

        public BoundRequestBuilder options(String path) {
            return null;
        }

        public void refreshAccessToken() throws AuthorizationFailure {
                    FluentStringsMap params = new FluentStringsMap();
                    params.add("grant_type", "refresh_token");
                    params.add("client_id", String.valueOf(this.clientId));
                    params.add("client_secret", this.clientSecret);
                    params.add("refresh_token", this.refreshToken);
                    AsyncHttpClient http = http();
                    
                    try {
                        BoundRequestBuilder req = preparePost("/oauth/token", params, http);
                        parseToken(req);
                    } catch (AuthorizationFailure e1) {
                        System.out.println(e1.getMessage());
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    
                    http.close();

        }

        /**
         * 
         * @param callback: The callback URL. Must be the applications redirect URI 
         * @param authUrl: The authorization URL. Get from Meli.AuthUrls
         * @return the authorization URL
         */
        public String getAuthUrl(String callback, AuthUrls authUrl) {
                    try {
                        return authUrl.getValue() + "/authorization?response_type=code&client_id="
                                + clientId
                                + "&redirect_uri="
                                + URLEncoder.encode(callback, "UTF-8")+"&state=1234" ;
                    } catch (UnsupportedEncodingException e) {
                        return authUrl+"/authorization?response_type=code&client_id="
                                + clientId + "&redirect_uri=" + callback;
                    }
        }

        public void authorize(String code, String redirectUri) throws AuthorizationFailure {
                    FluentStringsMap params = new FluentStringsMap();

                    params.add("grant_type", "authorization_code");
                    params.add("client_id", String.valueOf(clientId));
                    params.add("client_secret", clientSecret);
                    params.add("code", code);
                    params.add("redirect_uri", redirectUri);
                    
                     AsyncHttpClient http = http();

                    BoundRequestBuilder r = preparePost("/oauth/token", params, http);

                    parseToken(r);
                    
                    http.close();
        }

        private void parseToken(BoundRequestBuilder r) throws AuthorizationFailure {
                    Response response = null;
                    String responseBody = "";
                    try {
                            response = r.execute().get();
                            responseBody = response.getResponseBody();
                    } catch (InterruptedException e) {
                            throw new AuthorizationFailure(e);
                    } catch (ExecutionException e) {
                            throw new AuthorizationFailure(e);
                    } catch (IOException e) {
                            throw new AuthorizationFailure(e);
                    }

                    JsonParser p = new JsonParser();
                    JsonObject object;

                    try {
                            object = p.parse(responseBody).getAsJsonObject();
                    } catch (JsonSyntaxException e) {
                            throw new AuthorizationFailure(responseBody);
                    }

                    if (response.getStatusCode() == 200) {

                            this.accessToken = object.get("access_token").getAsString();

                            JsonElement jsonElement = object.get("refresh_token");
                            this.refreshToken = jsonElement != null ? object.get(
                                            "refresh_token").getAsString() : null;
                            /** News **/
                            JsonElement jsonElementExpires = object.get("expires_in");
                            this.expiresIn = jsonElementExpires != null ? Long.parseLong(object.get(
                                            "expires_in").getAsString())*1000+ System.currentTimeMillis(): null;

                            JsonElement jsonElementScope = object.get("scope");
                            this.scope = jsonElementScope != null ? object.get(
                                            "scope").getAsString() : null;

                            JsonElement jsonElementUserID = object.get("user_id");
                            this.userId = jsonElementUserID != null ? object.get(
                                            "user_id").getAsLong(): null;

                            JsonElement jsonElementToken = object.get("token_type");
                            this.tokenType = jsonElementToken != null ? object.get(
                                            "token_type").getAsString() : null;

                    } else {
                            throw new AuthorizationFailure(object.get("message").getAsString());
                    }

            }

        private boolean hasRefreshToken() {
            return this.refreshToken != null && !this.refreshToken.isEmpty();
        }

	
}

