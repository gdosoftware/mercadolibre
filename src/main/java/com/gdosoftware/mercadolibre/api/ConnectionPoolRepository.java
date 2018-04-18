/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdosoftware.mercadolibre.api;

/**
 *
 * @author Dani
 */
public interface ConnectionPoolRepository {
    public String getAccessToken(Long userId);
    public String getRefreshToken(Long userId);
    public Long getExpiresIn(Long userId);
    public void UpdateCredentials(String accessToken, String refreshToken, Long expiresIn);
}
