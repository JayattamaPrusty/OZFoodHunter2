
package com.wma.ozfoodhunter.BeanClasses;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class Restaurant_Dish_Model {

    private String status;
    private List<Dishitem> dishitems = null;
    private List<DeliveryFee> delivery_fee = null;
    private List<CuisineList> cuisine_list = null;
    private List<DevliverySuburb> devlivery_suburb = null;
    private List<Offer> offers = null;
    private List<Object> delivery_distinct = null;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Dishitem> getDishitems() {
        return dishitems;
    }

    public void setDishitems(List<Dishitem> dishitems) {
        this.dishitems = dishitems;
    }

    public List<DeliveryFee> getDeliveryFee() {
        return delivery_fee;
    }

    public void setDeliveryFee(List<DeliveryFee> deliveryFee) {
        this.delivery_fee = deliveryFee;
    }

    public List<CuisineList> getCuisineList() {
        return cuisine_list;
    }

    public void setCuisineList(List<CuisineList> cuisineList) {
        this.cuisine_list = cuisineList;
    }

    public List<DevliverySuburb> getDevliverySuburb() {
        return devlivery_suburb;
    }

    public void setDevliverySuburb(List<DevliverySuburb> devliverySuburb) {
        this.devlivery_suburb = devliverySuburb;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public List<Object> getDeliveryDistinct() {
        return delivery_distinct;
    }

    public void setDeliveryDistinct(List<Object> deliveryDistinct) {
        this.delivery_distinct = deliveryDistinct;
    }

}