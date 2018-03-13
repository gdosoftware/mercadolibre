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
public class MLItem {
  private String id;
  private String site_id;
  private String title;
  private String subtitle;
  private Long seller_id;
  private String category_id;
  private String official_store_id;
  private Double price;
  private String currency_id;
  private String buying_mode;//"classified","buy-it-now"con este distinguimos las preguntas
  private String listing_type_id;//"gold_premium",
  private String start_time;//"2016-01-31T14:16:20.000Z",
  private String stop_time;
  private String end_time;
  private String condition;// "used",
  private String permalink;// "http://inmueble.mercadolibre.com.ar/MLA-603335359-semanasanta-190-por-capacidad-deptos-complejo-angel-del-sol-_JM",
  private String thumbnail;// "http://mla-s1-p.mlstatic.com/23423-MLA20248368790_022015-I.jpg",
  private String secure_thumbnail;// "https://a248.e.akamai.net/mla-s1-p.mlstatic.com/23423-MLA20248368790_022015-I.jpg",
  private Integer available_quantity;
  private MLPicture[] pictures;
  private String video_id;
  private MLDescription[] descriptions;
  private MLSellerContact seller_contact;
 // private MLLocation location;
  private MLAttributes[] attributes;
  private String date_created;// "2016-01-31T14:16:20.000Z",
  private String last_updated;// "2016-02-01T05:46:48.000Z"

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSite_id() {
        return site_id;
    }

    public void setSite_id(String site_id) {
        this.site_id = site_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Long getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(Long seller_id) {
        this.seller_id = seller_id;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getOfficial_store_id() {
        return official_store_id;
    }

    public void setOfficial_store_id(String official_store_id) {
        this.official_store_id = official_store_id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
   
    public String getCurrency_id() {
        return currency_id;
    }

    public void setCurrency_id(String currency_id) {
        this.currency_id = currency_id;
    }

    public String getBuying_mode() {
        return buying_mode;
    }

    public void setBuying_mode(String buying_mode) {
        this.buying_mode = buying_mode;
    }

    public String getListing_type_id() {
        return listing_type_id;
    }

    public void setListing_type_id(String listing_type_id) {
        this.listing_type_id = listing_type_id;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getStop_time() {
        return stop_time;
    }

    public void setStop_time(String stop_time) {
        this.stop_time = stop_time;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getSecure_thumbnail() {
        return secure_thumbnail;
    }

    public void setSecure_thumbnail(String secure_thumbnail) {
        this.secure_thumbnail = secure_thumbnail;
    }

    public MLPicture[] getPictures() {
        return pictures;
    }

    public void setPictures(MLPicture[] pictures) {
        this.pictures = pictures;
    }

    public String getVideo_id() {
        return video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }

    public MLDescription[] getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(MLDescription[] descriptions) {
        this.descriptions = descriptions;
    }

    public MLSellerContact getSeller_contact() {
        return seller_contact;
    }

    public void setSeller_contact(MLSellerContact seller_contact) {
        this.seller_contact = seller_contact;
    }

//    public MLLocation getLocation() {
//        return location;
//    }
//
//    public void setLocation(MLLocation location) {
//        this.location = location;
//    }

    public MLAttributes[] getAttributes() {
        return attributes;
    }

    public void setAttributes(MLAttributes[] attributes) {
        this.attributes = attributes;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public Integer getAvailable_quantity() {
        return available_quantity;
    }

    public void setAvailable_quantity(Integer available_quantity) {
        this.available_quantity = available_quantity;
    }
  
  

}
