package com.wma.ozfoodhunter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wma.ozfoodhunter.BeanClasses.Login_Model;
import com.wma.ozfoodhunter.BeanClasses.Sign_Up_Model;
import com.wma.ozfoodhunter.Utils.AllValidation;
import com.wma.ozfoodhunter.Utils.MySharedPrefrencesData;
import com.wma.ozfoodhunter.apimodule.API_Call_Retrofit;
import com.wma.ozfoodhunter.apimodule.Apimethods;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mathivanan on 12/02/17.
 */

public class Login extends AppCompatActivity {

    TextView forgotpassword,signup;
    Button login,guest;
    EditText email,password;
    MySharedPrefrencesData mySharedPrefrencesData;
    ImageView login2;
    static Context mContext;
    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.login);

        forgotpassword = (TextView) findViewById(R.id.forgotpassword);
        signup = (TextView) findViewById(R.id.signup);
        login = (Button) findViewById(R.id.login);
        guest = (Button) findViewById(R.id.guest);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        mContext=this;
        mySharedPrefrencesData=new MySharedPrefrencesData();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        mySharedPrefrencesData.saveWidth(this,displaymetrics.widthPixels);
        mySharedPrefrencesData.saveHalfWidth(this,(displaymetrics.widthPixels)/2);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* startActivity(new Intent(Login.this,MainActivity.class));
                Login.this.finish();*/
                if(AllValidation.loginValidate(email.getText().toString(),password.getText().toString(),Login.this)) {
                    callLoginApi();

                }

            }
        });
        guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,MainActivity.class));
                Login.this.finish();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,Signup.class));
            }
        });

        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,ForgotPassword.class));

            }
        });
    }

    private void callLoginApi() {


        Apimethods methods = API_Call_Retrofit.getretrofit(Login.this).create(Apimethods.class);

        Call<Login_Model> call =methods.setLogin(email.getText().toString(),password.getText().toString());
        Log.d("url","url="+call.request().url().toString());

        call.enqueue(new Callback<Login_Model>() {
            @Override
            public void onResponse(Call<Login_Model> call, Response<Login_Model> response) {

                 int statusCode = response.code();
               Log.d("Response",""+statusCode);
               Login_Model lm=response.body();

               if(lm.getError_msg().equalsIgnoreCase("success"))
               {

                   Intent intent = new Intent(Login.this, MainActivity.class);
                   startActivity(intent);

                   String user_id=lm.getUser_info().getIn_user_id();
                   String user_email=lm.getUser_info().getSt_user_email();
                   String admin_first_name=lm.getUser_info().getAdmin_first_name();
                   String admin_last_name=lm.getUser_info().getAdmin_last_name();
                   String st_mobile=lm.getUser_info().getSt_mobile();

                   mySharedPrefrencesData.setUser_Id(mContext,user_id);
                   mySharedPrefrencesData.setPartyEmail(mContext,user_email);
                   mySharedPrefrencesData.setFName(mContext,admin_first_name);
                   mySharedPrefrencesData.setLName(mContext,admin_last_name);
                   mySharedPrefrencesData.set_Party_mobile(mContext,st_mobile);

               }else {
                   Toast.makeText(getApplicationContext(),"invalid login",Toast.LENGTH_LONG).show();
               }

                     /*   startActivity(new Intent(Login.this,MainActivity.class));
                        Login.this.finish();*/
            }

            @Override
            public void onFailure(Call<Login_Model> call, Throwable t) {

                Toast.makeText(getApplicationContext(),"internet not available..connect internet",Toast.LENGTH_LONG).show();

            }
        });

    }


}
