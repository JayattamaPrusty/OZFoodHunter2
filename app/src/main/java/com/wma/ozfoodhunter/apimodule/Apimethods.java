package com.wma.ozfoodhunter.apimodule;


import com.google.gson.JsonObject;
import com.wma.ozfoodhunter.BeanClasses.Changepassword;
import com.wma.ozfoodhunter.BeanClasses.Feedbackmodel;
import com.wma.ozfoodhunter.BeanClasses.Forgot_Model;
import com.wma.ozfoodhunter.BeanClasses.Login_Model;
import com.wma.ozfoodhunter.BeanClasses.PostCode_Model;
import com.wma.ozfoodhunter.BeanClasses.Restaurant_Dish_Model;
import com.wma.ozfoodhunter.BeanClasses.Restaurant_model;
import com.wma.ozfoodhunter.BeanClasses.Sign_Up_Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface Apimethods {


  /* @POST("OZF/mobile/signup")
    Call<Sign_Up_Model> setSignup(@Query("firstname") String firstname, @Query("lastname") String lastname,
                                  @Query("email") String email, @Query("password") String password,
                                  @Query("mobile") String phone
                                );
*/

    @FormUrlEncoded
    @POST("OZF/mobile/signup")
    Call<Sign_Up_Model> setSignup(@Field("firstname") String firstname, @Field("lastname") String lastname,
                                  @Field("email") String email, @Field("password") String password,
                                  @Field("mobile") String phone,@Field("deviceid") String deviceid);

    @FormUrlEncoded
    @POST("OZF/mobile/login")
    Call<Login_Model> setLogin(@Field("u_email")String email, @Field("u_pwd")String password);

    @FormUrlEncoded
    @POST("OZF/mobile/forgotpassword")
    Call<Forgot_Model> setForgot(@Field("email") String email);

    @POST("OZF/mobile/postcode")
    Call<PostCode_Model> setPostcode(@Body PostCode_Model postCodeModel);

    @FormUrlEncoded
    @POST("OZF/mobile/locationrestaurant")
    Call<List<Restaurant_model>> setRestaurant(@Field("lat") String latitude, @Field("lang") String longitude,@Field("schedule") int schedule,@Field("page") int page);

    @FormUrlEncoded
    @POST("OZF/mobile/locationrestaurant")
    Call<List<Restaurant_model>> setRestaurantsearch(@Field("location") String location,@Field("schedule") int schedule,@Field("page") int page);

    @FormUrlEncoded
    @POST("OZF/mobile/restaurantdish")
    Call<Restaurant_Dish_Model> setRes_dish(@Field("restid") String restid);

    @FormUrlEncoded
    @POST("OZF/mobile/changepass")
    Call<Changepassword> setpassword(@Field("userid") String userid, @Field("current_pass") String currentpass, @Field("password") String password);

     @FormUrlEncoded
    @POST("OZF/mobile/addfeedback")
    Call<Feedbackmodel> setfeedback(@Field("name") String name, @Field("email") String email, @Field("comment") String comment);

  /*  @FormUrlEncoded
    @POST("OZF/mobile/booktable")
    Call<Feedbackmodel> setfeedback(@Field("name") String name, @Field("email") String email, @Field("comment") String comment);*/

}
