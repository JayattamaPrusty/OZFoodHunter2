package com.wma.ozfoodhunter.BeanClasses;
import java.util.List;

public class Restaurant_model {

    private String in_restaurant_id;
    private String image;
    private String distance;
    private String in_res_owner_id;
    private String st_restaurant_slug;
    private String st_restaurant_name;
    private String st_description;
    private String st_contact_name;
    private Object st_secondary_email;
    private String st_suburb;
    private String st_street_address;
    private String st_city;
    private String st_state;
    private Object st_country;
    private String st_postcode;
    private String st_mobile;
    private String st_venue_cuisine;
    private String st_min_order;
    private Object st_min_free_order;
    private String st_gst_commission;
    private String st_commission;
    private Object st_printer_id;
    private String st_pkup_del;
    private Object st_first_name;
    private Object st_last_name;
    private String st_post_code;
    private String st_delivery_charge;
    private String Close_open_st;
    private String agree_table_booking;
    private List<Filtercuisine> filter_cuisine = null;
    private List<Discountlist> discountlist = null;
    private DeliverySchedule delivery_schedule;
    private PickupSchedule pickup_schedule;
    private Review review;

    public String getInRestaurantId() {
        return in_restaurant_id;
    }

    public void setInRestaurantId(String inRestaurantId) {
        this.in_restaurant_id = inRestaurantId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getInResOwnerId() {
        return in_res_owner_id;
    }

    public void setInResOwnerId(String inResOwnerId) {
        this.in_res_owner_id = inResOwnerId;
    }

    public String getStRestaurantSlug() {
        return st_restaurant_slug;
    }

    public void setStRestaurantSlug(String stRestaurantSlug) {
        this.st_restaurant_slug = stRestaurantSlug;
    }

    public String getStRestaurantName() {
        return st_restaurant_name;
    }

    public void setStRestaurantName(String stRestaurantName) {
        this.st_restaurant_name = stRestaurantName;
    }

    public String getStDescription() {
        return st_description;
    }

    public void setStDescription(String stDescription) {
        this.st_description = stDescription;
    }

    public String getStContactName() {
        return st_contact_name;
    }

    public void setStContactName(String stContactName) {
        this.st_contact_name = stContactName;
    }

    public Object getStSecondaryEmail() {
        return st_secondary_email;
    }

    public void setStSecondaryEmail(Object stSecondaryEmail) {
        this.st_secondary_email = stSecondaryEmail;
    }

    public String getStSuburb() {
        return st_suburb;
    }

    public void setStSuburb(String stSuburb) {
        this.st_suburb = stSuburb;
    }

    public String getStStreetAddress() {
        return st_street_address;
    }

    public void setStStreetAddress(String stStreetAddress) {
        this.st_street_address = stStreetAddress;
    }

    public String getStCity() {
        return st_city;
    }

    public void setStCity(String stCity) {
        this.st_city = stCity;
    }

    public String getStState() {
        return st_state;
    }

    public void setStState(String stState) {
        this.st_state = stState;
    }

    public Object getStCountry() {
        return st_country;
    }

    public void setStCountry(Object stCountry) {
        this.st_country = stCountry;
    }

    public String getStPostcode() {
        return st_postcode;
    }

    public void setStPostcode(String stPostcode) {
        this.st_postcode = stPostcode;
    }

    public String getStMobile() {
        return st_mobile;
    }

    public void setStMobile(String stMobile) {
        this.st_mobile = stMobile;
    }

    public String getStVenueCuisine() {
        return st_venue_cuisine;
    }

    public void setStVenueCuisine(String stVenueCuisine) {
        this.st_venue_cuisine = stVenueCuisine;
    }

    public String getStMinOrder() {
        return st_min_order;
    }

    public void setStMinOrder(String stMinOrder) {
        this.st_min_order = stMinOrder;
    }

    public Object getStMinFreeOrder() {
        return st_min_free_order;
    }

    public void setStMinFreeOrder(Object stMinFreeOrder) {
        this.st_min_free_order = stMinFreeOrder;
    }

    public String getStGstCommission() {
        return st_gst_commission;
    }

    public void setStGstCommission(String stGstCommission) {
        this.st_gst_commission = stGstCommission;
    }

    public String getStCommission() {
        return st_commission;
    }

    public void setStCommission(String stCommission) {
        this.st_commission = stCommission;
    }

    public Object getStPrinterId() {
        return st_printer_id;
    }

    public void setStPrinterId(Object stPrinterId) {
        this.st_printer_id = stPrinterId;
    }

    public String getStPkupDel() {
        return st_pkup_del;
    }

    public void setStPkupDel(String stPkupDel) {
        this.st_pkup_del = stPkupDel;
    }

    public Object getStFirstName() {
        return st_first_name;
    }

    public void setStFirstName(Object stFirstName) {
        this.st_first_name = stFirstName;
    }

    public Object getStLastName() {
        return st_last_name;
    }

    public void setStLastName(Object stLastName) {
        this.st_last_name = stLastName;
    }

    public String getStPostCode() {
        return st_post_code;
    }

    public void setStPostCode(String stPostCode) {
        this.st_post_code = stPostCode;
    }

    public String getStDeliveryCharge() {
        return st_delivery_charge;
    }

    public void setStDeliveryCharge(String stDeliveryCharge) {
        this.st_delivery_charge = stDeliveryCharge;
    }

    public String getClose_open_st() {
        return Close_open_st;
    }

    public void setClose_open_st(String close_open_st) {
        Close_open_st = close_open_st;
    }

    public String getAgree_table_booking() {
        return agree_table_booking;
    }

    public void setAgree_table_booking(String agree_table_booking) {
        this.agree_table_booking = agree_table_booking;
    }

    public List<Filtercuisine> getFilter_cuisine() {
        return filter_cuisine;
    }

    public void setFilter_cuisine(List<Filtercuisine> filter_cuisine) {
        this.filter_cuisine = filter_cuisine;
    }

    public List<Discountlist> getDiscountlist() {
        return discountlist;
    }

    public void setDiscountlist(List<Discountlist> discountlist) {
        this.discountlist = discountlist;
    }

    public DeliverySchedule getDeliverySchedule() {
        return delivery_schedule;
    }

    public void setDeliverySchedule(DeliverySchedule deliverySchedule) {
        this.delivery_schedule = deliverySchedule;
    }

    public PickupSchedule getPickupSchedule() {
        return pickup_schedule;
    }

    public void setPickupSchedule(PickupSchedule pickupSchedule) {
        this.pickup_schedule = pickupSchedule;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public class Filtercuisine{

        public String getSt_venue_cuisine() {
            return st_venue_cuisine;
        }

        public void setSt_venue_cuisine(String st_venue_cuisine) {
            this.st_venue_cuisine = st_venue_cuisine;
        }

        private String st_venue_cuisine;

    }


    public class Discountlist {

        private String inSpecialId;
        private String firstOfferValue;
        private String secondOfferValue;
        private String flgOfferType;
        private String thirdOfferValue;
        private String forthOfferValue;

        public String getInSpecialId() {
            return inSpecialId;
        }

        public void setInSpecialId(String inSpecialId) {
            this.inSpecialId = inSpecialId;
        }

        public String getFirstOfferValue() {
            return firstOfferValue;
        }

        public void setFirstOfferValue(String firstOfferValue) {
            this.firstOfferValue = firstOfferValue;
        }

        public String getSecondOfferValue() {
            return secondOfferValue;
        }

        public void setSecondOfferValue(String secondOfferValue) {
            this.secondOfferValue = secondOfferValue;
        }

        public String getFlgOfferType() {
            return flgOfferType;
        }

        public void setFlgOfferType(String flgOfferType) {
            this.flgOfferType = flgOfferType;
        }

        public String getThirdOfferValue() {
            return thirdOfferValue;
        }

        public void setThirdOfferValue(String thirdOfferValue) {
            this.thirdOfferValue = thirdOfferValue;
        }

        public String getForthOfferValue() {
            return forthOfferValue;
        }

        public void setForthOfferValue(String forthOfferValue) {
            this.forthOfferValue = forthOfferValue;
        }

    }



    public class DeliverySchedule {

        private String del_start_time_lunch;
        private String del_close_time_lunch;
        private String del_start_time_dinner;
        private String del_close_time_dinner;

        public String getDel_start_time_lunch() {
            return del_start_time_lunch;
        }

        public void setDel_start_time_lunch(String del_start_time_lunch) {
            this.del_start_time_lunch = del_start_time_lunch;
        }

        public String getDel_close_time_lunch() {
            return del_close_time_lunch;
        }

        public void setDel_close_time_lunch(String del_close_time_lunch) {
            this.del_close_time_lunch = del_close_time_lunch;
        }

        public String getDel_start_time_dinner() {
            return del_start_time_dinner;
        }

        public void setDel_start_time_dinner(String del_start_time_dinner) {
            this.del_start_time_dinner = del_start_time_dinner;
        }

        public String getDel_close_time_dinner() {
            return del_close_time_dinner;
        }

        public void setDel_close_time_dinner(String del_close_time_dinner) {
            this.del_close_time_dinner = del_close_time_dinner;
        }


    }


    public class PickupSchedule {
        private String pick_start_time_lunch;
        private String pick_close_time_lunch;
        private String pick_start_time_dinner;
        private String pick_close_time_dinner;

        public String getPick_start_time_lunch() {
            return pick_start_time_lunch;
        }

        public void setPick_start_time_lunch(String pick_start_time_lunch) {
            this.pick_start_time_lunch = pick_start_time_lunch;
        }

        public String getPick_close_time_lunch() {
            return pick_close_time_lunch;
        }

        public void setPick_close_time_lunch(String pick_close_time_lunch) {
            this.pick_close_time_lunch = pick_close_time_lunch;
        }

        public String getPick_start_time_dinner() {
            return pick_start_time_dinner;
        }

        public void setPick_start_time_dinner(String pick_start_time_dinner) {
            this.pick_start_time_dinner = pick_start_time_dinner;
        }

        public String getPick_close_time_dinner() {
            return pick_close_time_dinner;
        }

        public void setPick_close_time_dinner(String pick_close_time_dinner) {
            this.pick_close_time_dinner = pick_close_time_dinner;
        }


    }

    public class Review {

        private String in_id;
        private String total_review;
        private Integer rating;

        public String getInId() {
            return in_id;
        }

        public void setInId(String inId) {
            this.in_id = inId;
        }

        public String getTotalReview() {
            return total_review;
        }

        public void setTotalReview(String totalReview) {
            this.total_review = totalReview;
        }

        public Integer getRating() {
            return rating;
        }

        public void setRating(Integer rating) {
            this.rating = rating;
        }

    }

}





