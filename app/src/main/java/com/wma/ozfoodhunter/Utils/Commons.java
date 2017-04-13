package com.wma.ozfoodhunter.Utils;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.wma.ozfoodhunter.BeanClasses.PostCode_Model;
import com.wma.ozfoodhunter.apimodule.API_Call_Retrofit;
import com.wma.ozfoodhunter.apimodule.Apimethods;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Jayattama Prusty on 03-Apr-17.
 */

public class Commons {
    public  static String[] postcode;
    public  static double latitude;
    public  static double longitude;
    public  static String in_restaurant_id;


}
