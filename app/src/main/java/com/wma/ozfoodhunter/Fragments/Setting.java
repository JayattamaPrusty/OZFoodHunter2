package com.wma.ozfoodhunter.Fragments;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.wma.ozfoodhunter.BeanClasses.Changepassword;
import com.wma.ozfoodhunter.BeanClasses.Sign_Up_Model;
import com.wma.ozfoodhunter.Login;
import com.wma.ozfoodhunter.R;
import com.wma.ozfoodhunter.Signup;
import com.wma.ozfoodhunter.TermsActivity;
import com.wma.ozfoodhunter.Utils.MySharedPrefrencesData;
import com.wma.ozfoodhunter.apimodule.API_Call_Retrofit;
import com.wma.ozfoodhunter.apimodule.Apimethods;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Setting extends Fragment implements View.OnClickListener{
    View view;
    RelativeLayout chngpw,notification,help,terms;
    EditText oldpw,newpw,confrmpw;
    Button chng,dismiss;
    MySharedPrefrencesData mySharedPrefrencesData;
    String currentpass;
    String newpass;
    String confirmpass;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_setting, container, false);
        mySharedPrefrencesData=new MySharedPrefrencesData();
        chngpw=(RelativeLayout)view.findViewById(R.id.changepw);
        notification=(RelativeLayout)view.findViewById(R.id.notification);
        help=(RelativeLayout)view.findViewById(R.id.help);
        terms=(RelativeLayout)view.findViewById(R.id.terms);
        chngpw.setOnClickListener(this);
        notification.setOnClickListener(this);
        help.setOnClickListener(this);
        terms.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.changepw:

                final Dialog dialog=new Dialog(getActivity());
                dialog.setContentView(R.layout.changepassword_popup);
                oldpw=(EditText) dialog.findViewById(R.id.oldpw);
                newpw=(EditText) dialog.findViewById(R.id.newpw);
                confrmpw=(EditText) dialog.findViewById(R.id.confirmpw);
                chng=(Button) dialog.findViewById(R.id.change);
                chng.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                      if(newpw.getText().toString().equalsIgnoreCase(confrmpw.getText().toString())){
                        callapi_chngpw();}
                        else
                      {
                          Toast.makeText(getActivity(),"password mismatch",Toast.LENGTH_SHORT).show();
                      }

                    }
                });

                dismiss=(Button) dialog.findViewById(R.id.dismiss);
                dismiss.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();

                break;
            case R.id.notification:
                break;
            case R.id.help:
                break;
            case R.id.terms:
                Intent in=new Intent(getActivity(), TermsActivity.class);
                startActivity(in);
                break;
        }

    }

    private void callapi_chngpw() {

        Apimethods methods = API_Call_Retrofit.getretrofit(getActivity()).create(Apimethods.class);
        String userid=mySharedPrefrencesData.getUser_Id(getContext());
        currentpass=oldpw.getText().toString();
        newpass=newpw.getText().toString();
        Call<Changepassword> call =methods.setpassword(userid,currentpass,newpass);
        Log.d("url","url="+call.request().url().toString());

        call.enqueue(new Callback<Changepassword>() {
            @Override
            public void onResponse(Call<Changepassword> call, Response<Changepassword> response) {
                int statusCode = response.code();
                Log.d("Response",""+statusCode);
                Log.d("respones",""+response);
                Changepassword chngmodel=response.body();
                if(chngmodel.getStatus().equalsIgnoreCase("Success"))
                {
                    Toast.makeText(getActivity(),"Password changed successfully",Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(getActivity(),"invalid password",Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Changepassword> call, Throwable t) {

                Toast.makeText(getActivity(),"internet not available..connect internet",Toast.LENGTH_LONG).show();


            }
        });
    }
}
