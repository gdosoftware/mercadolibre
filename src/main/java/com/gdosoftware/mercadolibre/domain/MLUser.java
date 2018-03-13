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
public class MLUser {
    private Long id;
    private String nickname;
    private String first_name;
    private String last_name;
    private String country_id;
    private String email;
    private MLIdentification identification;
    private MLAddress address;
    private MLPhone phone;
    private MLPhone alternative_phone;
    private String user_type;
    private String logo;
    private String site_id;
    private String permalink;
    private Integer points;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MLIdentification getIdentification() {
        return identification;
    }

    public void setIdentification(MLIdentification identification) {
        this.identification = identification;
    }

    public MLAddress getAddress() {
        return address;
    }

    public void setAddress(MLAddress address) {
        this.address = address;
    }

    public MLPhone getPhone() {
        return phone;
    }

    public void setPhone(MLPhone phone) {
        this.phone = phone;
    }

    public MLPhone getAlternative_phone() {
        return alternative_phone;
    }

    public void setAlternative_phone(MLPhone alternative_phone) {
        this.alternative_phone = alternative_phone;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getSite_id() {
        return site_id;
    }

    public void setSite_id(String site_id) {
        this.site_id = site_id;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "MLUser{" + "id=" + id + ", nickname=" + nickname + ", first_name=" + first_name + ", last_name=" + last_name + ", country_id=" + country_id + ", email=" + email + ", identification=" + identification + ", address=" + address + ", phone=" + phone + ", alternative_phone=" + alternative_phone + ", user_type=" + user_type + ", logo=" + logo + ", site_id=" + site_id + ", permalink=" + permalink + ", points=" + points + '}';
    }
    
    
   

}
