package com.wma.ozfoodhunter.BeanClasses;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Offer implements Serializable
{

    private String in_special_id;
    private String in_restaurant_id;
    private Object st_special_name;
    private Object st_terms_conditions;
    private String first_offer_value;
    @SerializedName("2nd_offer_value")
    @Expose
    private String _2ndOfferValue;
    @SerializedName("3rd_offer_free_value")
    @Expose
    private String _3rdOfferFreeValue;
    @SerializedName("4th_offer_value")
    @Expose
    private String _4thOfferValue;
    private String st_del_pic_condition;
    private String flg_choice;
    private String flg_offer_type;
    private String dt_added_date;
    private Object dt_modified_date;
    private String flg_ac_status;
    private String flg_is_delete;

    public String getInSpecialId() {
        return in_special_id;
    }

    public void setInSpecialId(String inSpecialId) {
        this.in_special_id = inSpecialId;
    }

    public String getInRestaurantId() {
        return in_restaurant_id;
    }

    public void setInRestaurantId(String inRestaurantId) {
        this.in_restaurant_id = inRestaurantId;
    }

    public Object getStSpecialName() {
        return st_special_name;
    }

    public void setStSpecialName(Object stSpecialName) {
        this.st_special_name = stSpecialName;
    }

    public Object getStTermsConditions() {
        return st_terms_conditions;
    }

    public void setStTermsConditions(Object stTermsConditions) {
        this.st_terms_conditions = stTermsConditions;
    }

    public String getFirstOfferValue() {
        return first_offer_value;
    }

    public void setFirstOfferValue(String firstOfferValue) {
        this.first_offer_value = firstOfferValue;
    }

    public String get2ndOfferValue() {
        return _2ndOfferValue;
    }

    public void set2ndOfferValue(String _2ndOfferValue) {
        this._2ndOfferValue = _2ndOfferValue;
    }

    public String get3rdOfferFreeValue() {
        return _3rdOfferFreeValue;
    }

    public void set3rdOfferFreeValue(String _3rdOfferFreeValue) {
        this._3rdOfferFreeValue = _3rdOfferFreeValue;
    }

    public String get4thOfferValue() {
        return _4thOfferValue;
    }

    public void set4thOfferValue(String _4thOfferValue) {
        this._4thOfferValue = _4thOfferValue;
    }

    public String getStDelPicCondition() {
        return st_del_pic_condition;
    }

    public void setStDelPicCondition(String stDelPicCondition) {
        this.st_del_pic_condition = stDelPicCondition;
    }

    public String getFlgChoice() {
        return flg_choice;
    }

    public void setFlgChoice(String flgChoice) {
        this.flg_choice = flgChoice;
    }

    public String getFlgOfferType() {
        return flg_offer_type;
    }

    public void setFlgOfferType(String flgOfferType) {
        this.flg_offer_type = flgOfferType;
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

}