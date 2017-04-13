package com.wma.ozfoodhunter.BeanClasses;

import java.util.List;

public class Extrasdetail {

    private String type;
    private List<Extra> extras = null;
    private String flg_multiple_choice;
    private String flg_mandatory;
    private String in_dish_id;
    private String in_special_atribute_id;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Extra> getExtras() {
        return extras;
    }

    public void setExtras(List<Extra> extras) {
        this.extras = extras;
    }

    public String getFlgMultipleChoice() {
        return flg_multiple_choice;
    }

    public void setFlgMultipleChoice(String flgMultipleChoice) {
        this.flg_multiple_choice = flgMultipleChoice;
    }

    public String getFlgMandatory() {
        return flg_mandatory;
    }

    public void setFlgMandatory(String flgMandatory) {
        this.flg_mandatory = flgMandatory;
    }

    public String getInDishId() {
        return in_dish_id;
    }

    public void setInDishId(String inDishId) {
        this.in_dish_id = inDishId;
    }

    public String getInSpecialAtributeId() {
        return in_special_atribute_id;
    }

    public void setInSpecialAtributeId(String inSpecialAtributeId) {
        this.in_special_atribute_id = inSpecialAtributeId;
    }

}