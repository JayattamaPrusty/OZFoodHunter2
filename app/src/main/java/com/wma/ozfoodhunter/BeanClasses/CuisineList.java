package com.wma.ozfoodhunter.BeanClasses;


public class CuisineList {

    private String in_cuisine_id;
    private String in_restaurant_id;
    private String st_cuisine_name;
    private String dt_added_date;
    private String dt_modified_date;
    private String flg_ac_status;
    private String flg_is_delete;
    private String flg_menu_choices;

    public String getInCuisineId() {
        return in_cuisine_id;
    }

    public void setInCuisineId(String inCuisineId) {
        this.in_cuisine_id = inCuisineId;
    }

    public String getInRestaurantId() {
        return in_restaurant_id;
    }

    public void setInRestaurantId(String inRestaurantId) {
        this.in_restaurant_id = inRestaurantId;
    }

    public String getStCuisineName() {
        return st_cuisine_name;
    }

    public void setStCuisineName(String stCuisineName) {
        this.st_cuisine_name = stCuisineName;
    }

    public String getDtAddedDate() {
        return dt_added_date;
    }

    public void setDtAddedDate(String dtAddedDate) {
        this.dt_added_date = dtAddedDate;
    }

    public String getDtModifiedDate() {
        return dt_modified_date;
    }

    public void setDtModifiedDate(String dtModifiedDate) {
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

    public String getFlgMenuChoices() {
        return flg_menu_choices;
    }

    public void setFlgMenuChoices(String flgMenuChoices) {
        this.flg_menu_choices = flgMenuChoices;
    }

}