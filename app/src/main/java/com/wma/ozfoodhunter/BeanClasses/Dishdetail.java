package com.wma.ozfoodhunter.BeanClasses;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Dishdetail implements Parcelable {

    private String in_dish_id;
    private String st_dish_name;
    private String dish_desription;
    private List<StPrice> st_price = null;
    private String flg_add_choices;
    private Object dish_cuisine_id;
    private List<Extrasdetail> extrasdetail = null;
    private List<Offer> offers = null;


    public Dishdetail(String in_dish_id, String st_dish_name, String dish_desription, List<StPrice> st_price, String flg_add_choices, Object dish_cuisine_id, List<Extrasdetail> extrasdetail) {
        this.in_dish_id = in_dish_id;
        this.st_dish_name = st_dish_name;
        this.dish_desription = dish_desription;
        this.st_price = st_price;
        this.flg_add_choices = flg_add_choices;
        this.dish_cuisine_id = dish_cuisine_id;
        this.extrasdetail = extrasdetail;
    }


    public Dishdetail(Parcel in) {
        in_dish_id = in.readString();
        st_dish_name = in.readString();
        flg_add_choices = in.readString();
    }


    public static final Creator<Dishdetail> CREATOR = new Creator<Dishdetail>() {
        @Override
        public Dishdetail createFromParcel(Parcel in) {
            return new Dishdetail(in);
        }

        @Override
        public Dishdetail[] newArray(int size) {
            return new Dishdetail[size];
        }
    };

    public Dishdetail(List<Offer> offers) {
        this.offers = offers;
    }




    public String getInDishId() {
        return in_dish_id;
    }

    public void setInDishId(String inDishId) {
        this.in_dish_id = inDishId;
    }

    public String getStDishName() {
        return st_dish_name;
    }

    public void setStDishName(String stDishName) {
        this.st_dish_name = stDishName;
    }

    public String getDishDesription() {
        return dish_desription;
    }

    public void setDishDesription(String dishDesription) {
        this.dish_desription = dishDesription;
    }

    public List<StPrice> getStPrice() {
        return st_price;
    }

    public void setStPrice(List<StPrice> stPrice) {
        this.st_price = stPrice;
    }

    public String getFlgAddChoices() {
        return flg_add_choices;
    }

    public void setFlgAddChoices(String flgAddChoices) {
        this.flg_add_choices = flgAddChoices;
    }

    public Object getDishCuisineId() {
        return dish_cuisine_id;
    }

    public void setDishCuisineId(Object dishCuisineId) {
        this.dish_cuisine_id = dishCuisineId;
    }

    public List<Extrasdetail> getExtrasdetail() {
        return extrasdetail;
    }

    public void setExtrasdetail(List<Extrasdetail> extrasdetail) {
        this.extrasdetail = extrasdetail;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(in_dish_id);
        dest.writeString(st_dish_name);
        dest.writeString(flg_add_choices);
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }
}