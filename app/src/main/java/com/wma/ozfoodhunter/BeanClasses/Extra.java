
package com.wma.ozfoodhunter.BeanClasses;


import java.io.Serializable;

public class Extra implements Serializable {

    private String id;
    private String attribute_name;
    private String attribute_price;
    private String isChecked;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAttributeName() {
        return attribute_name;
    }

    public void setAttributeName(String attributeName) {
        this.attribute_name = attributeName;
    }

    public String getAttributePrice() {
        return attribute_price;
    }

    public void setAttributePrice(String attributePrice) {
        this.attribute_price = attributePrice;
    }

    public String getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(String isChecked) {
        this.isChecked = isChecked;
    }
}