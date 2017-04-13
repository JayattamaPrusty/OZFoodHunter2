package com.wma.ozfoodhunter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.wma.ozfoodhunter.BeanClasses.Sign_Up_Model;
import com.wma.ozfoodhunter.Utils.AllValidation;
import com.wma.ozfoodhunter.apimodule.API_Call_Retrofit;
import com.wma.ozfoodhunter.apimodule.AllApiCalls;
import com.wma.ozfoodhunter.apimodule.Apimethods;

import com.wma.ozfoodhunter.apimodule.ResponseHandle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mathivanan on 12/02/17.
 */

public class Signup extends AppCompatActivity {
    String fname,lname,email,pass,mobile;

    Toolbar toolbar;
    ActionBar actionbar;
    Button signup;
    EditText edtFName,edtLName,edtEmail,edtMobileNumber,edtpassword;
    TextView textRegister;
    ResponseHandle handler;
    AllApiCalls apicalls;
    public static final String KEY_FNAME = "firstname";
    public static final String KEY_LNAME = "lastname";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_MOB = "mobile";
    Sign_Up_Model signUpModel;
    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.signup);
        apicalls=new AllApiCalls();
        edtFName=(EditText)findViewById(R.id.fname);
        edtLName=(EditText)findViewById(R.id.lname);
        edtEmail=(EditText)findViewById(R.id.email);
        edtMobileNumber=(EditText)findViewById(R.id.phoneno);
        edtpassword=(EditText)findViewById(R.id.password);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionbar = getSupportActionBar();
        actionbar.setHomeAsUpIndicator(R.drawable.ic_back);
        actionbar.setDisplayHomeAsUpEnabled(true);
        signup = (Button) findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 fname=edtFName.getText().toString().trim();
                 lname=edtLName.getText().toString().trim();
                 email=edtEmail.getText().toString().trim();
                 mobile=edtMobileNumber.getText().toString().trim();
                 pass=edtpassword.getText().toString().trim();

                if(AllValidation.getRegisterValidate(fname,lname,email,mobile,pass,Signup.this)) {
                    callApi();
                }
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void callApi() {
        Apimethods methods = API_Call_Retrofit.getretrofit(Signup.this).create(Apimethods.class);
      //  Sign_Up_Model task=new Sign_Up_Model(fname,lname,email,pass,mobile);
        Call<Sign_Up_Model> call =methods.setSignup(fname,lname,email,pass,mobile);
        Log.d("url","url="+call.request().url().toString());

        call.enqueue(new Callback<Sign_Up_Model>() {
           @Override
           public void onResponse(Call<Sign_Up_Model> call,Response<Sign_Up_Model> response) {
               int statusCode = response.code();
               Log.d("Response",""+statusCode);
               Log.d("respones",""+response);
               signUpModel=response.body();
               if(signUpModel.getStatus().equalsIgnoreCase("Success"))
               {
                   Toast.makeText(getApplicationContext(),"Submit successfully",Toast.LENGTH_LONG).show();
                   Intent intent = new Intent(Signup.this, Login.class);
                   startActivity(intent);


               }else
               {
                   Toast.makeText(getApplicationContext(),"invalid",Toast.LENGTH_LONG).show();
               }

           }

           @Override
           public void onFailure(Call<Sign_Up_Model> call, Throwable t) {

               Toast.makeText(getApplicationContext(),"internet not available..connect internet",Toast.LENGTH_LONG).show();


           }
       });
    }

}
