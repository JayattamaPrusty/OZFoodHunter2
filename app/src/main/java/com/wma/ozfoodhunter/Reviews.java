package com.wma.ozfoodhunter;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wma.ozfoodhunter.Adapters.Review_Adapter;
import com.wma.ozfoodhunter.Widgets.DividerItemDecoration;

/**
 * Created by mathivanan on 11/03/17.
 */

public class Reviews extends AppCompatActivity {


    Toolbar toolbar;
    ActionBar actionbar;
    ImageView img;
    TextView name,address,rating_review;
    RatingBar ratingBar;
    String Address="";
    String Reviews="";
    float Rating;
    String NAME="";
    String Image ;
    RecyclerView reviewrecyclerview;
    Review_Adapter ra;
    LinearLayoutManager lm;
    @Override
    protected void onCreate(Bundle savedinstance){
        super.onCreate(savedinstance);
        setContentView(R.layout.review_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionbar = getSupportActionBar();
        actionbar.setHomeAsUpIndicator(R.drawable.ic_back);
        actionbar.setDisplayHomeAsUpEnabled(true);

        lm = new LinearLayoutManager(this);
        img = (ImageView) findViewById(R.id.img);
        name = (TextView) findViewById(R.id.name);
        address = (TextView) findViewById(R.id.address);
        rating_review = (TextView) findViewById(R.id.rating_review);
        ratingBar = (RatingBar) findViewById(R.id.rating);
        reviewrecyclerview = (RecyclerView) findViewById(R.id.reviewrecycler);
        reviewrecyclerview.setLayoutManager(lm);
        reviewrecyclerview.setItemAnimator(new DefaultItemAnimator());
        reviewrecyclerview.addItemDecoration(new DividerItemDecoration(this));
        reviewrecyclerview.setHasFixedSize(true);
        ra = new Review_Adapter(this);
        reviewrecyclerview.setAdapter(ra);

        Image = getIntent().getStringExtra("Image");
        NAME = getIntent().getStringExtra("Name");
        Address = getIntent().getStringExtra("Address");
        Reviews = getIntent().getStringExtra("Reviews");
        Rating = getIntent().getFloatExtra("Rating",0);
        Glide.with(this).load(Image).into(img);
        name.setText(NAME);
        address.setText(Address);
        ratingBar.setRating(Rating);
        rating_review.setText("Rating "+Rating+" & "+Reviews+" review ");

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
