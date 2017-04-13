package com.wma.ozfoodhunter.BeanClasses;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class Dishitem extends ExpandableGroup<Dishdetail>{

    private String in_cuisine_id;
    private String cuisine_name;
    private List<Dishdetail> dishdetails = null;

    public Dishitem(String title, List<Dishdetail> items) {
        super(title, items);
        this.cuisine_name=title;
        this.dishdetails=items;
    }

    public String getInCuisineId() {
        return in_cuisine_id;
    }

    public void setInCuisineId(String inCuisineId) {
        this.in_cuisine_id = inCuisineId;
    }

    public String getCuisineName() {
        return cuisine_name;
    }

    public void setCuisineName(String cuisineName) {
        this.cuisine_name = cuisineName;
    }

    public List<Dishdetail> getDishdetails() {
        return dishdetails;
    }

    public void setDishdetails(List<Dishdetail> dishdetails) {
        this.dishdetails = dishdetails;
    }

}