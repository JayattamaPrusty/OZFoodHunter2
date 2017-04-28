package com.wma.ozfoodhunter.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wma.ozfoodhunter.Adapters.Item_Adapter;
import com.wma.ozfoodhunter.BeanClasses.Changepassword;
import com.wma.ozfoodhunter.BeanClasses.Feedbackmodel;
import com.wma.ozfoodhunter.Item_Detail;
import com.wma.ozfoodhunter.R;
import com.wma.ozfoodhunter.Widgets.DividerItemDecoration;
import com.wma.ozfoodhunter.apimodule.API_Call_Retrofit;
import com.wma.ozfoodhunter.apimodule.Apimethods;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mathivanan on 13/02/17.
 */

public class Feedback extends Fragment {
    View view;
    EditText name,email,comment;
    Button feedback_submit;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.feedback, container, false);
        name=(EditText)view.findViewById(R.id.name);
        email=(EditText)view.findViewById(R.id.email);
        comment=(EditText)view.findViewById(R.id.comment);
        feedback_submit=(Button) view.findViewById(R.id.feedback);
        feedback_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callapi();
            }
        });


        return view;
    }

    private void callapi() {

        Apimethods methods = API_Call_Retrofit.getretrofit(getActivity()).create(Apimethods.class);

        Call<Feedbackmodel> call =methods.setfeedback(name.getText().toString(),email.getText().toString(),comment.getText().toString());
        Log.d("url","url="+call.request().url().toString());

        call.enqueue(new Callback<Feedbackmodel>() {
            @Override
            public void onResponse(Call<Feedbackmodel> call, Response<Feedbackmodel> response) {
                int statusCode = response.code();
                Log.d("Response",""+statusCode);
                Log.d("respones",""+response);
                Feedbackmodel feedback=response.body();
                if(feedback.getStatus().equalsIgnoreCase("Success"))
                {
                    Toast.makeText(getActivity(),feedback.getMsg().toString(),Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(getActivity(),"invalid password",Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Feedbackmodel> call, Throwable t) {

                Toast.makeText(getActivity(),"internet not available..connect internet",Toast.LENGTH_LONG).show();


            }
        });
    }
}
