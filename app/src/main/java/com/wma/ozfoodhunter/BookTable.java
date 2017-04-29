package com.wma.ozfoodhunter;

import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.wma.ozfoodhunter.BeanClasses.Feedbackmodel;
import com.wma.ozfoodhunter.Fragments.DatePickerFragment;
import com.wma.ozfoodhunter.apimodule.API_Call_Retrofit;
import com.wma.ozfoodhunter.apimodule.Apimethods;
import com.wma.ozfoodhunter.fonts.Bookmodel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookTable extends AppCompatActivity implements DatePickerFragment.TheListener {
    ImageView imageView;
    TextView res_name,streetadd,close_open_venuecsn,date,time;
    String rest_id,rest_id_from_restdetails,rest_name,rest_street,rest_open_close_cuisine,rest_image;
    EditText name,email,phone,person_no,comment;
    Button submit,cancel;
    String name1,email1,phone1,person1,comment1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booktablelay_bynaresh);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        imageView=(ImageView)findViewById(R.id.img);
        res_name=(TextView)findViewById(R.id.restaurant_name);
        streetadd=(TextView)findViewById(R.id.streetadd);
        date=(TextView)findViewById(R.id.calender);
        time=(TextView)findViewById(R.id.time);

        name=(EditText) findViewById(R.id.yourname);
        email=(EditText)findViewById(R.id.emailadd);
        phone=(EditText)findViewById(R.id.phone);
        person_no=(EditText)findViewById(R.id.no_of_person);
        comment=(EditText) findViewById(R.id.comment);

        name1=name.getText().toString();
        email1=email.getText().toString();
        phone1=phone.getText().toString();
        person1=person_no.getText().toString();
        comment1=comment.getText().toString();

        submit=(Button)findViewById(R.id.submit_bktbl);
        cancel=(Button)findViewById(R.id.cancel_bktbl);

        close_open_venuecsn=(TextView)findViewById(R.id.venue_cuisine1);
        rest_id=getIntent().getStringExtra("res_id");
        rest_image=getIntent().getStringExtra("res_img");
        rest_name=getIntent().getStringExtra("res_name");
        rest_street=getIntent().getStringExtra("rest_street_details");
        rest_open_close_cuisine=getIntent().getStringExtra("rest_close_open_rest_venue_cuisine");
        res_name.setText(rest_name);
        streetadd.setText(rest_street);
        close_open_venuecsn.setText(rest_open_close_cuisine);
        Glide.with(this)
                .load(rest_image)
                .fitCenter()
                .into(imageView);


        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DialogFragment picker = new DatePickerFragment();
                picker.show(getFragmentManager(), "datePicker");




            }
        });
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date dateobj = new Date();
        System.out.println(df.format(dateobj));
        String s;
        s=df.format(dateobj).toString();
        date.setText(s);
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callapi_book();
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

    @Override
    public void returnDate(String date1) {
        // TODO Auto-generated method stub
        date.setText(date1);
    }

    private void callapi_book() {

        Apimethods methods = API_Call_Retrofit.getretrofit(this).create(Apimethods.class);


        Call<Bookmodel> call =methods.setBook(rest_id,name1,phone1,person1,email1,comment1,date.getText().toString(),"ghs");
        Log.d("url","url="+call.request().url().toString());

        call.enqueue(new Callback<Bookmodel>() {
            @Override
            public void onResponse(Call<Bookmodel> call, Response<Bookmodel> response) {
                int statusCode = response.code();
                Log.d("Response",""+statusCode);
                Log.d("respones",""+response);
                Bookmodel feedback=response.body();
                if(feedback.getStatus().equalsIgnoreCase("Success"))
                {
                    Toast.makeText(BookTable.this,feedback.getMsg().toString(),Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(BookTable.this,"invalid password",Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Bookmodel> call, Throwable t) {

                Toast.makeText(BookTable.this,"internet not available..connect internet",Toast.LENGTH_LONG).show();


            }
        });
    }

}
