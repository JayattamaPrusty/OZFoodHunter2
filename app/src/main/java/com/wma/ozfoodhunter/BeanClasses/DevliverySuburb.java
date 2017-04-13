package com.wma.ozfoodhunter.BeanClasses;


public class DevliverySuburb {

    private String in_suburb_id;
    private String in_restaurant_id;
    private String postcode_id;
    private String st_suburb;
    private Object st_city;
    private String st_postcode;
    private String flg_delivery_status;
    private String st_delivery_charge;
    private String dt_added_date;
    private Object dt_modified_date;
    private String flg_ac_status;
    private String flg_is_delete;
    private String flg_menu_choice;

    public String getInSuburbId() {
        return in_suburb_id;
    }

    public void setInSuburbId(String inSuburbId) {
        this.in_suburb_id = inSuburbId;
    }

    public String getInRestaurantId() {
        return in_restaurant_id;
    }

    public void setInRestaurantId(String inRestaurantId) {
        this.in_restaurant_id = inRestaurantId;
    }

    public String getPostcodeId() {
        return postcode_id;
    }

    public void setPostcodeId(String postcodeId) {
        this.postcode_id = postcodeId;
    }

    public String getStSuburb() {
        return st_suburb;
    }

    public void setStSuburb(String stSuburb) {
        this.st_suburb = stSuburb;
    }

    public Object getStCity() {
        return st_city;
    }

    public void setStCity(Object stCity) {
        this.st_city = stCity;
    }

    public String getStPostcode() {
        return st_postcode;
    }

    public void setStPostcode(String stPostcode) {
        this.st_postcode = stPostcode;
    }

    public String getFlgDeliveryStatus() {
        return flg_delivery_status;
    }

    public void setFlgDeliveryStatus(String flgDeliveryStatus) {
        this.flg_delivery_status = flgDeliveryStatus;
    }

    public String getStDeliveryCharge() {
        return st_delivery_charge;
    }

    public void setStDeliveryCharge(String stDeliveryCharge) {
        this.st_delivery_charge = stDeliveryCharge;
    }

    public String getDtAddedDate() {
        return dt_added_date;
    }

    public void setDtAddedDate(String dtAddedDate) {
        this.dt_added_date = dtAddedDate;
    }

    public Object getDtModifiedDate() {
        return dt_modified_date;
    }

    public void setDtModifiedDate(Object dtModifiedDate) {
        this.dt_modified_date = dtModifiedDate;
    }

    public String getFlgAcStatus() {
        return flg_ac_status;
    }

    public void setFlgAcStatus(String flgAcStatus) {
        this.flg_ac_status = flgAcStatus;
    }

    public String getFlgIsDelete() {
        return flg_is_delete;
    }

    public void setFlgIsDelete(String flgIsDelete) {
        this.flg_is_delete = flgIsDelete;
    }

    public String getFlgMenuChoice() {
        return flg_menu_choice;
    }

    public void setFlgMenuChoice(String flgMenuChoice) {
        this.flg_menu_choice = flgMenuChoice;
    }

}