package com.wma.ozfoodhunter;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.wma.ozfoodhunter.Fragments.AboutUs;
import com.wma.ozfoodhunter.Fragments.Deals;
import com.wma.ozfoodhunter.Fragments.Feedback;
import com.wma.ozfoodhunter.Fragments.Home;
import com.wma.ozfoodhunter.Fragments.Notification;
import com.wma.ozfoodhunter.Fragments.Setting;
import com.wma.ozfoodhunter.Fragments.Support;
import com.wma.ozfoodhunter.Fragments.Wallet;
import com.wma.ozfoodhunter.Utils.Commons;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private GoogleApiClient googleApiClient;

    MarshMallowPermission p=new MarshMallowPermission(this);
    FrameLayout frame;
    TextView cartcount,dealscount;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Restaurants");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        googleApiClient = new GoogleApiClient.Builder(this, this, this).addApi(LocationServices.API).build();
        googleApiClient.connect();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        cartcount=(TextView) MenuItemCompat.getActionView(navigationView.getMenu().findItem(R.id.cart));
        dealscount=(TextView) MenuItemCompat.getActionView(navigationView.getMenu().findItem(R.id.deals));

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame, new Home());
        ft.commit();
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.filter) {
            startActivity(new Intent(MainActivity.this,Filter.class));
            return true;
        }
        if (id == R.id.search) {
            return true;
        }
        if (id == R.id.location) {
            return true;
        }if (id == R.id.notification_menu) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Fragment fragment = null;
        int id = item.getItemId();

        if (id == R.id.home) {
            getSupportActionBar().setTitle("Restaurants");
            fragment = new Home();
        } else if (id == R.id.cart) {
            startActivity(new Intent(MainActivity.this,MyCart.class));
        } else if (id == R.id.deals) {
            getSupportActionBar().setTitle("Deals");
            fragment = new Deals();
        } else if (id == R.id.wallet) {
            getSupportActionBar().setTitle("Wallet");
            fragment = new Wallet();
        } else if (id == R.id.setting) {
            getSupportActionBar().setTitle("Setting");
            fragment = new Setting();
        } else if (id == R.id.support) {
            getSupportActionBar().setTitle("Support");
            fragment = new Support();
        } else if (id == R.id.feedback) {
            getSupportActionBar().setTitle("Feedback");
            fragment = new Feedback();
        } else if (id == R.id.about) {
            getSupportActionBar().setTitle("Aboutus");
            fragment = new AboutUs();
        } else if (id == R.id.logout) {
            startActivity(new Intent(MainActivity.this,Login.class));
            MainActivity.this.finish();
        }

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frame, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onConnected(Bundle bundle) {

        System.out.println("Connected");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(!p.checkPermissionForLocation()){
                p.requestPermissionForLocation();
            }
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                Location lastLocation = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
                try{
                    Commons.latitude = lastLocation.getLatitude();
                    Commons.longitude = lastLocation.getLongitude();
                    Log.d("Latitude",""+Commons.latitude);
                    Log.d("Longitude",""+Commons.longitude);
                }catch (Exception e){

                }
            }else{

            }
        }else{
            Location lastLocation = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
            try{
                Commons.latitude = lastLocation.getLatitude();
                Commons.longitude = lastLocation.getLongitude();
                Log.d("Latitude",""+Commons.latitude);
                Log.d("Longitude",""+Commons.longitude);
            }catch (Exception e){

            }

        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
