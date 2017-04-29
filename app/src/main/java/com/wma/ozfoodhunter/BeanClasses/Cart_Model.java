package com.wma.ozfoodhunter.BeanClasses;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Jayattama Prusty on 29-Apr-17.
 */

public class Cart_Model implements Serializable {
    private List<Cart_Details> Cart_Details;

    public List<Cart_Model.Cart_Details> getCart_Details() {
        return Cart_Details;
    }

    public void setCart_Details(List<Cart_Model.Cart_Details> cart_Details) {
        Cart_Details = cart_Details;
    }

    public class Cart_Details {
        private String in_restaurant_id;
        private String in_dish_id;
        private String st_dish_name;
        private String price_item;
        private String quantity;
        private String menu_price;
        private String is_preference;
        private String id;

        public String getIn_restaurant_id() {
            return in_restaurant_id;
        }

        public void setIn_restaurant_id(String in_restaurant_id) {
            this.in_restaurant_id = in_restaurant_id;
        }

        public String getIn_dish_id() {
            return in_dish_id;
        }

        public void setIn_dish_id(String in_dish_id) {
            this.in_dish_id = in_dish_id;
        }

        public String getSt_dish_name() {
            return st_dish_name;
        }

        public void setSt_dish_name(String st_dish_name) {
            this.st_dish_name = st_dish_name;
        }

        public String getPrice_item() {
            return price_item;
        }

        public void setPrice_item(String price_item) {
            this.price_item = price_item;
        }

        public String getQuantity() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }

        public String getMenu_price() {
            return menu_price;
        }

        public void setMenu_price(String menu_price) {
            this.menu_price = menu_price;
        }

        public String getIs_preference() {
            return is_preference;
        }

        public void setIs_preference(String is_preference) {
            this.is_preference = is_preference;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
