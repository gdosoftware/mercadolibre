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
public class MLSellerContact {
    private String contact;
    private String other_info;
    private String area_code;
    private String phone;
    private String area_code2;
    private String phone2;
    private String email;
    private String webpage;

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getOther_info() {
        return other_info;
    }

    public void setOther_info(String other_info) {
        this.other_info = other_info;
    }

    public String getArea_code() {
        return area_code;
    }

    public void setArea_code(String area_code) {
        this.area_code = area_code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getArea_code2() {
        return area_code2;
    }

    public void setArea_code2(String area_code2) {
        this.area_code2 = area_code2;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebpage() {
        return webpage;
    }

    public void setWebpage(String webpage) {
        this.webpage = webpage;
    }

    @Override
    public String toString() {
        return "MLSellerContact{" + "contact=" + contact + ", other_info=" + other_info + ", area_code=" + area_code + ", phone=" + phone + ", area_code2=" + area_code2 + ", phone2=" + phone2 + ", email=" + email + ", webpage=" + webpage + '}';
    }
    
    
}
