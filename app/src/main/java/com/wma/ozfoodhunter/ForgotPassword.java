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
import android.widget.Toast;
import com.wma.ozfoodhunter.BeanClasses.Forgot_Model;
import com.wma.ozfoodhunter.Utils.AllValidation;
import com.wma.ozfoodhunter.apimodule.API_Call_Retrofit;
import com.wma.ozfoodhunter.apimodule.Apimethods;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mathivanan on 12/02/17.
 */

public class ForgotPassword extends AppCompatActivity {

    Toolbar toolbar;
    ActionBar actionbar;
    Button forgotpw;
    EditText email;
    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.forgotpassword);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        forgotpw = (Button) findViewById(R.id.forgotpw);
        email = (EditText) findViewById(R.id.email);
        setSupportActionBar(toolbar);
        actionbar = getSupportActionBar();
        actionbar.setHomeAsUpIndicator(R.drawable.ic_back);
        actionbar.setDisplayHomeAsUpEnabled(true);
        forgotpw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString()!="null"){

                    callApiForgotPW();
                }
                else {
                    AllValidation.myToast(ForgotPassword.this,"Enter your mail_id");
                }

            }
        });

    }

    private void callApiForgotPW() {

        Apimethods methods = API_Call_Retrofit.getretrofit(ForgotPassword.this).create(Apimethods.class);

        Call<Forgot_Model> call =methods.setForgot(email.getText().toString());
        Log.d("url","url="+call.request().url().toString());

        call.enqueue(new Callback<Forgot_Model>() {
            @Override
            public void onResponse(Call<Forgot_Model> call, Response<Forgot_Model> response) {
               int statusCode = response.code();
               Log.d("Response",""+statusCode);
               Forgot_Model forgot_model=response.body();

               if(forgot_model.getStatus().equalsIgnoreCase("Success"))
               {
                   Toast.makeText(getApplicationContext(),"Submit successfully",Toast.LENGTH_LONG).show();
                   Intent intent = new Intent(ForgotPassword.this, Login.class);
                   startActivity(intent);

               }else {
                   Toast.makeText(getApplicationContext(),"invalid email_id",Toast.LENGTH_LONG).show();
               }



            }

            @Override
            public void onFailure(Call<Forgot_Model> call, Throwable t) {

                Toast.makeText(getApplicationContext(),"internet not available..connect internet",Toast.LENGTH_LONG).show();



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
}
