package com.wma.ozfoodhunter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.wma.ozfoodhunter.Fragments.DeliveryAddress;

public class Address_list extends AppCompatActivity implements View.OnClickListener {
    Button add_address;
    FrameLayout framelay;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_list);
        framelay=(FrameLayout)findViewById(R.id.framelay);
        add_address=(Button)findViewById(R.id.add_address);
        add_address.setOnClickListener(this);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
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
        public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.add_address:
                add_address.setVisibility(View.GONE);
                recyclerView.setVisibility(View.GONE);
                framelay.setVisibility(View.VISIBLE);
                Fragment frag=new DeliveryAddress();
                Bundle d = new Bundle();
                d.putString("type","Add");
                FragmentManager fm1 = this. getSupportFragmentManager();
                FragmentTransaction ft1 = fm1.beginTransaction();
                ft1.replace(R.id.framelay, frag);
                frag.setArguments(d);
                ft1.addToBackStack("addAddress");
                ft1.commit();
                break;

        }

    }
}
