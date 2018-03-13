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
public class MLLocation {
    private String address_line;
    private String zip_code;
    private MLLocationItem neighborhood;
    private MLLocationItem city;
    private MLLocationItem state;
    private MLLocationItem country;
    private Double latitude;
    private Double longitude;

    public String getAddress_line() {
        return address_line;
    }

    public void setAddress_line(String address_line) {
        this.address_line = address_line;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public MLLocationItem getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(MLLocationItem neighborhood) {
        this.neighborhood = neighborhood;
    }

    public MLLocationItem getCity() {
        return city;
    }

    public void setCity(MLLocationItem city) {
        this.city = city;
    }

    public MLLocationItem getState() {
        return state;
    }

    public void setState(MLLocationItem state) {
        this.state = state;
    }

    public MLLocationItem getCountry() {
        return country;
    }

    public void setCountry(MLLocationItem country) {
        this.country = country;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "MLLocation{" + "address_line=" + address_line + ", zip_code=" + zip_code + ", neighborhood=" + neighborhood + ", city=" + city + ", state=" + state + ", country=" + country + ", latitude=" + latitude + ", longitude=" + longitude + '}';
    }
	
    
}
