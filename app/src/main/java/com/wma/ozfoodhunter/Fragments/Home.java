package com.wma.ozfoodhunter.Fragments;

import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.wma.ozfoodhunter.Adapters.Restaurant_Adapter;
import com.wma.ozfoodhunter.BeanClasses.Login_Model;
import com.wma.ozfoodhunter.BeanClasses.PostCode_Model;
import com.wma.ozfoodhunter.BeanClasses.Restaurant_model;
import com.wma.ozfoodhunter.BeanClasses.Sign_Up_Model;
import com.wma.ozfoodhunter.BeanClasses.StLunchTime;
import com.wma.ozfoodhunter.Filter;
import com.wma.ozfoodhunter.Login;
import com.wma.ozfoodhunter.MainActivity;
import com.wma.ozfoodhunter.R;
import com.wma.ozfoodhunter.RestarantDetails;
import com.wma.ozfoodhunter.Signup;
import com.wma.ozfoodhunter.Utils.AllValidation;
import com.wma.ozfoodhunter.Utils.Commons;
import com.wma.ozfoodhunter.Utils.MySharedPrefrencesData;
import com.wma.ozfoodhunter.Widgets.DividerItemDecoration;
import com.wma.ozfoodhunter.apimodule.API_Call_Retrofit;
import com.wma.ozfoodhunter.apimodule.Apimethods;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by mathivanan on 12/02/17.
 */

public class Home extends Fragment implements View.OnClickListener{
    View view;
    RecyclerView recyclerView;
    Restaurant_Adapter ra;
    LinearLayoutManager lm;
    RelativeLayout rel;
    LinearLayout lay;
    AutoCompleteTextView search;
    TextView searchbtn;
    Button pickup, delivery, cuisine;
    final boolean flag = false;
    String location[]=null;
    ArrayAdapter<String> adapter;
    MainActivity ma;
    List<Restaurant_model> restaurantModelList = new ArrayList<>();
    MySharedPrefrencesData mySharedPrefrencesData;
    String userid;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.restaurant_layout, container, false);
        ma=(MainActivity)getActivity();
        mySharedPrefrencesData=new MySharedPrefrencesData();
        userid=mySharedPrefrencesData.getUser_Id(ma);
        lm = new LinearLayoutManager(getActivity());
        rel = (RelativeLayout) view.findViewById(R.id.rel);
        lay = (LinearLayout) view.findViewById(R.id.lay);
        search = (AutoCompleteTextView) view.findViewById(R.id.search);
   //     search.setThreshold(3);
        searchbtn = (TextView) view.findViewById(R.id.search1);
        pickup = (Button) view.findViewById(R.id.pickup_btn);
        delivery = (Button) view.findViewById(R.id.delivery_btn);
        cuisine = (Button) view.findViewById(R.id.cuisine);
        search.setOnClickListener(this);
        searchbtn.setOnClickListener(this);
        delivery.setOnClickListener(this);
        pickup.setOnClickListener(this);
        cuisine.setOnClickListener(this);
        restaurantList();
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(lm);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity()));
        recyclerView.setHasFixedSize(true);
        final NestedScrollView nestedscroll = (NestedScrollView) view.findViewById(R.id.nestedscroll);

        nestedscroll.postDelayed(new Runnable() {
            @Override
            public void run() {
                nestedscroll.fullScroll(ScrollView.FOCUS_UP);
            }
        },8);

        search.setSelection(0);
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);



        return view;
    }
    private void restaurantList()
    {
        Apimethods methods = API_Call_Retrofit.getretrofit(getActivity()).create(Apimethods.class);

        Call<List<Restaurant_model>> call = methods.setRestaurant(""+Commons.latitude,""+Commons.longitude,mySharedPrefrencesData.getUser_Id(ma));
        Log.d("url","url="+call.request().url().toString());
        Log.d("Latitude",""+Commons.latitude);
        Log.d("Longitude",""+Commons.longitude);
        call.enqueue(new Callback<List<Restaurant_model>>() {
            @Override
            public void onResponse(Call<List<Restaurant_model>> call,
                                   retrofit2.Response<List<Restaurant_model>> response)
            {
                restaurantModelList=response.body();
                ra = new Restaurant_Adapter(getActivity(),restaurantModelList);
                recyclerView.setAdapter(ra);
                /*for(int i=0;i<restaurantModelList.size();i++) {
                    Commons.in_restaurant_id=restaurantModelList.get(i).getInRestaurantId();
                    ra.setOnItemClickListener(new Restaurant_Adapter.OnItemClickListener() {
                        public void onItemClick(View v, int position) {
                            System.out.println("Clicked View");
                            Intent in = new Intent(getActivity(), RestarantDetails.class);
                            in.putExtra("Position", position);
                            startActivity(in);
                        }
                    });
                }*/
                ra.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<Restaurant_model>> call, Throwable t) {
                Toast.makeText(ma,"internet not available..connect internet",Toast.LENGTH_LONG).show();

            }
        });

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.search:
               searchlocation();
                break;
            case R.id.search1:
                break;
            case R.id.pickup_btn:

                pickup.setBackgroundResource(R.drawable.rectangle_edge_half_color);
                pickup.setTextColor(getResources().getColor(R.color.black));
                delivery.setBackgroundResource(R.drawable.rectanle_edge_half_transparent);
                delivery.setTextColor(getResources().getColor(R.color.button));

                break;
            case R.id.delivery_btn:
                pickup.setBackgroundResource(R.drawable.rectangle_half_left_transparent);
                pickup.setTextColor(getResources().getColor(R.color.button));
                delivery.setBackgroundResource(R.drawable.search_rectangle_right);
                delivery.setTextColor(getResources().getColor(R.color.black));
                break;
            case R.id.cuisine:
                startActivity(new Intent(getActivity(), Filter.class));
                break;
        }

    }

    private void searchlocation() {
        adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_dropdown_item_1line,Commons.postcode);
        search.setAdapter(adapter);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                adapter.getFilter().filter(cs);
                search.setThreshold(3);
                adapter.notifyDataSetChanged();

            }
            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,int arg3) {
            }
            @Override
            public void afterTextChanged(Editable arg0) {
            }
        });
    }

}
