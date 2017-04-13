package com.wma.ozfoodhunter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by mathivanan on 13/02/17.
 */

public class Item_Detail extends AppCompatActivity {

    Toolbar toolbar;
    ActionBar actionbar;
    Button addcart,mild,medium,hot,normal,less;

    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.itemdetail);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionbar = getSupportActionBar();
        actionbar.setHomeAsUpIndicator(R.drawable.ic_back);
        actionbar.setDisplayHomeAsUpEnabled(true);

        addcart = (Button) findViewById(R.id.addcart);
        mild = (Button) findViewById(R.id.mild);
        medium = (Button) findViewById(R.id.medium);
        hot = (Button) findViewById(R.id.hot);
        normal = (Button) findViewById(R.id.normal);
        less = (Button) findViewById(R.id.less);

        addcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(Item_Detail.this,MyCart.class));
                Item_Detail.this.finish();
            }
        });
        mild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mild.setBackgroundResource(R.drawable.rectangle_edge_green);
                medium.setBackgroundResource(R.drawable.rectangle_edge_white);
                hot.setBackgroundResource(R.drawable.rectangle_edge_white);
                mild.setTextColor(getResources().getColor(R.color.white));
                medium.setTextColor(getResources().getColor(R.color.black));
                hot.setTextColor(getResources().getColor(R.color.black));
            }
        });
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                medium.setBackgroundResource(R.drawable.rectangle_edge_green);
                mild.setBackgroundResource(R.drawable.rectangle_edge_white);
                hot.setBackgroundResource(R.drawable.rectangle_edge_white);
                medium.setTextColor(getResources().getColor(R.color.white));
                mild.setTextColor(getResources().getColor(R.color.black));
                hot.setTextColor(getResources().getColor(R.color.black));
            }
        });
        hot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hot.setBackgroundResource(R.drawable.rectangle_edge_green);
                mild.setBackgroundResource(R.drawable.rectangle_edge_white);
                medium.setBackgroundResource(R.drawable.rectangle_edge_white);
                hot.setTextColor(getResources().getColor(R.color.white));
                medium.setTextColor(getResources().getColor(R.color.black));
                mild.setTextColor(getResources().getColor(R.color.black));
            }
        });
        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                normal.setBackgroundResource(R.drawable.rectangle_edge_green);
                less.setBackgroundResource(R.drawable.rectangle_edge_white);
                normal.setTextColor(getResources().getColor(R.color.white));
                less.setTextColor(getResources().getColor(R.color.black));
            }
        });
        less.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                less.setBackgroundResource(R.drawable.rectangle_edge_green);
                normal.setBackgroundResource(R.drawable.rectangle_edge_white);
                less.setTextColor(getResources().getColor(R.color.white));
                normal.setTextColor(getResources().getColor(R.color.black));
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
