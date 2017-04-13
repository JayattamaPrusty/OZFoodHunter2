package com.wma.ozfoodhunter.apimodule;


import com.google.gson.JsonObject;
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
                                  @Field("mobile") String phone);

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
    Call<List<Restaurant_model>> setRestaurant(@Field("lat") String latitude, @Field("lang") String longitude, @Field("userid") String userid);

    @FormUrlEncoded
    @POST("OZF/mobile/restaurantdish")
    Call<Restaurant_Dish_Model> setRes_dish(@Field("restid") String restid);

}
