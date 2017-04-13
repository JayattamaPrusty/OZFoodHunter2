package com.wma.ozfoodhunter;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.wma.ozfoodhunter.BeanClasses.PostCode_Model;
import com.wma.ozfoodhunter.Utils.AllValidation;
import com.wma.ozfoodhunter.Utils.Commons;
import com.wma.ozfoodhunter.apimodule.API_Call_Retrofit;
import com.wma.ozfoodhunter.apimodule.Apimethods;

import retrofit2.Call;
import retrofit2.Callback;


public class Splash extends Activity {

//    private GoogleApiClient googleApiClient;
//    MarshMallowPermission p=new MarshMallowPermission(this);


    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.splash);

//        googleApiClient = new GoogleApiClient.Builder(this, this, this).addApi(LocationServices.API).build();
//        googleApiClient.connect();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                    Intent in = new Intent(Splash.this,Walkthrough.class);
                    startActivity(in);
                    finish();
            }
        },1000*3);

        postcodeApi();
    }

    private void postcodeApi() {
        Apimethods methods = API_Call_Retrofit.getretrofit(Splash.this).create(Apimethods.class);
        PostCode_Model post=new PostCode_Model();
        Call<PostCode_Model> call =methods.setPostcode(post);
        Log.d("url","url="+call.request().url().toString());

        call.enqueue(new Callback<PostCode_Model>() {
            @Override
            public void onResponse(Call<PostCode_Model> call, retrofit2.Response<PostCode_Model> response) {
                if(response.isSuccessful())
                {
                    int statusCode = response.code();
                    Log.d("Response",""+statusCode);
                    PostCode_Model pm=response.body();
                    Commons.postcode = new String[pm.getResults().size()];
                    for(int i=0;i<pm.getResults().size()&& pm.getResults()!=null;i++)
                    {
                        Commons.postcode[i]=pm.getResults().get(i).getSt_suburb()+"-"+pm.getResults().get(i).getSt_postcode();
                    }

                }else
                {
                    AllValidation.myToast(Splash.this,"no api call");
                }
            }

            @Override
            public void onFailure(Call<PostCode_Model> call, Throwable t)
            {

                Toast.makeText(Splash.this,"internet not available..connect internet",Toast.LENGTH_LONG).show();

            }
        });
    }
  /*  @Override
    public void onConnected(Bundle bundle) {

        System.out.println("Connected");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(!p.checkPermissionForLocation()){
                p.requestPermissionForLocation();
            }
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                Location lastLocation = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
                try{
                    Commons.latitude = lastLocation.getLatitude();
                    Commons.longitude = lastLocation.getLongitude();
                   Log.d("Latitude",""+Commons.latitude);
                    Log.d("Longitude",""+Commons.longitude);
                }catch (Exception e){

                }
            }else{

            }
        }else{
            Location lastLocation = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
            try{
                Commons.latitude = lastLocation.getLatitude();
                Commons.longitude = lastLocation.getLongitude();
                Log.d("Latitude",""+Commons.latitude);
                Log.d("Longitude",""+Commons.longitude);
            }catch (Exception e){

            }

        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }*/


}
