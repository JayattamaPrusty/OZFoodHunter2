package com.wma.ozfoodhunter;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by mathivanan on 11/03/17.
 */

public class Offers extends AppCompatActivity {


    Toolbar toolbar;
    ActionBar actionbar;
    ImageView img;
    TextView name,address;
    String NAME="";
    String Image;
    String Address="";

    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.offers);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionbar = getSupportActionBar();
        actionbar.setHomeAsUpIndicator(R.drawable.ic_back);
        actionbar.setDisplayHomeAsUpEnabled(true);

        img = (ImageView) findViewById(R.id.img);
        name = (TextView) findViewById(R.id.name);
        address = (TextView) findViewById(R.id.address);
        Image = getIntent().getStringExtra("Image");
        NAME = getIntent().getStringExtra("Name");
        Address = getIntent().getStringExtra("Address");
        Glide.with(this).load(Image).into(img);
        name.setText(NAME);
        address.setText(Address);


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
