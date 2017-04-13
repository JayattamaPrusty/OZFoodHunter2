package com.wma.ozfoodhunter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.thoughtbot.expandablerecyclerview.listeners.GroupExpandCollapseListener;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.wma.ozfoodhunter.Adapters.RestaurantDetailsAdapter;
import com.wma.ozfoodhunter.BeanClasses.ChildDish;
import com.wma.ozfoodhunter.BeanClasses.Dishdetail;
import com.wma.ozfoodhunter.BeanClasses.Dishitem;
import com.wma.ozfoodhunter.BeanClasses.ParentDish;
import com.wma.ozfoodhunter.BeanClasses.PostCode_Model;
import com.wma.ozfoodhunter.BeanClasses.Restaurant_Dish_Model;
import com.wma.ozfoodhunter.Utils.AllValidation;
import com.wma.ozfoodhunter.Utils.Commons;
import com.wma.ozfoodhunter.Widgets.Constants;
import com.wma.ozfoodhunter.apimodule.API_Call_Retrofit;
import com.wma.ozfoodhunter.apimodule.Apimethods;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class RestarantDetails extends AppCompatActivity implements View.OnClickListener {
    Toolbar toolbar;
    ActionBar actionbar;
    ImageView img;
    TextView res_name,res_cuisine_name;
    RecyclerView recyclerView;
    private RestaurantDetailsAdapter adapter;
    private ExpandableGroup expandedGroup=null;
//    private ArrayList<ParentDish> parentDishArrayList;
//    ArrayList<ChildDish> childDishArrayList;
    ArrayList<Dishitem> parentDishArrayList;
    ArrayList<Dishdetail> childDishArrayList;
    Button items,viewcart,lunch,dinner,book_table;
    int a=0;
    int b=0;
    int c=0;
    String name,image,cuisine_name,res_id,min_order,delivery_fee;
    Restaurant_Dish_Model restmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_restarant_details);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionbar = getSupportActionBar();
        actionbar.setHomeAsUpIndicator(R.drawable.ic_back);
        actionbar.setDisplayHomeAsUpEnabled(true);
        img=(ImageView)findViewById(R.id.img);
        res_name=(TextView) findViewById(R.id.restaurant_name);
        res_cuisine_name=(TextView) findViewById(R.id.venue_cuisine);
        name=getIntent().getStringExtra("res_name");
        image=getIntent().getStringExtra("res_image");
        min_order=getIntent().getStringExtra("res_min_order");
        delivery_fee=getIntent().getStringExtra("res_delivery_fee");
        cuisine_name=getIntent().getStringExtra("res_venue_cuisine");
        res_id=getIntent().getStringExtra("res_id");
        restapicall();
        Glide.with(this).load(image).into(img);
        res_name.setText(name);
        res_cuisine_name.setText(cuisine_name);
        items=(Button)findViewById(R.id.items);
        viewcart=(Button)findViewById(R.id.viewcart);
        lunch=(Button)findViewById(R.id.lunch_btn);
        dinner=(Button)findViewById(R.id.dinner_btn);
        book_table=(Button)findViewById(R.id.book_btn);
        items.setOnClickListener(this);
        viewcart.setOnClickListener(this);
        lunch.setOnClickListener(this);
        dinner.setOnClickListener(this);
        book_table.setOnClickListener(this);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_restaurant_details);
        parentDishArrayList = new ArrayList<>();
        childDishArrayList = new ArrayList<>();
//        setData();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

      //  adapter.notifyDataSetChanged();
        NestedScrollView nestedscroll = (NestedScrollView)findViewById(R.id.activity_restarant_details);
        nestedscroll.scrollTo(0, 0);

      /*  adapter.setOnGroupExpandCollapseListener(new GroupExpandCollapseListener() {
            @Override
            public void onGroupExpanded(ExpandableGroup group) {

                if (group != expandedGroup)
                try{
                    adapter.toggleGroup(group);
                    adapter.toggleGroup(expandedGroup);

                }catch (Exception e){}
                    expandedGroup = group;

            }

            @Override
            public void onGroupCollapsed(ExpandableGroup group) {

            }
        });*/

    }

    private void restapicall()
    {

        Apimethods methods = API_Call_Retrofit.getretrofit(RestarantDetails.this).create(Apimethods.class);

        Call<Restaurant_Dish_Model> call =methods.setRes_dish(res_id);
        Log.d("url","url="+call.request().url().toString());

        call.enqueue(new Callback<Restaurant_Dish_Model>() {
            @Override
            public void onResponse(Call<Restaurant_Dish_Model> call, retrofit2.Response<Restaurant_Dish_Model> response) {

              restmodel =response.body();

                if(restmodel.getStatus().equalsIgnoreCase("Success"))
                {
                    int statusCode = response.code();
                    Log.d("Response",""+statusCode);
                    Log.d("response",""+response);
                    setData();
                    adapter = new RestaurantDetailsAdapter(parentDishArrayList,RestarantDetails.this);
                    recyclerView.setAdapter(adapter);
                }else
                {
                    AllValidation.myToast(RestarantDetails.this,"no api call");
                }

            }

            @Override
            public void onFailure(Call<Restaurant_Dish_Model> call, Throwable t)
            {

                Toast.makeText(RestarantDetails.this,"internet not available..connect internet",Toast.LENGTH_LONG).show();

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

    private void setData() {
      //  childDishArrayList.add(new Dishdetail(restmodel.getOffers()));


            childDishArrayList.add(new Dishdetail("",
                    "",
                    "$"+restmodel.getOffers().get(0).getFirstOfferValue()+"% off 1st time",
                    null,
                    "",
                    "",
                    null
                    ));
            childDishArrayList.add(new Dishdetail("",
                    "",
                    "$"+restmodel.getOffers().get(1).get2ndOfferValue()+"th free",
                    null,
                    "",
                    "",
                    null
                    ));

        parentDishArrayList.add(0,new Dishitem("Special offers",childDishArrayList));


        for(int i=0;i<restmodel.getDishitems().size();i++)
        {
            childDishArrayList=new ArrayList<>();
            for(int j=0;j<restmodel.getDishitems().get(i).getDishdetails().size();j++)
            {
                childDishArrayList.add(new Dishdetail(restmodel.getDishitems().get(i).getDishdetails().get(j).getInDishId(),
                       restmodel.getDishitems().get(i).getDishdetails().get(j).getStDishName(),
                       restmodel.getDishitems().get(i).getDishdetails().get(j).getDishDesription(),
                       restmodel.getDishitems().get(i).getDishdetails().get(j).getStPrice(),
                       restmodel.getDishitems().get(i).getDishdetails().get(j).getFlgAddChoices(),
                       restmodel.getDishitems().get(i).getDishdetails().get(j).getDishCuisineId(),
                       restmodel.getDishitems().get(i).getDishdetails().get(j).getExtrasdetail()));
            }

            parentDishArrayList.add(new Dishitem(restmodel.getDishitems().get(i).getCuisineName(), childDishArrayList));
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.items:
                break;
            case R.id.lunch_btn:
                a++;
                if(a%2 == 1){
                    lunch.setBackgroundResource(R.drawable.rectangle_edge);
                    lunch.setTextColor(getResources().getColor(R.color.white));
                }else{
                    lunch.setBackgroundResource(R.drawable.rectangle_white);
                    lunch.setTextColor(getResources().getColor(R.color.black));
                }

                break;
            case R.id.dinner_btn:
                b++;
                if(b%2 == 1){
                    dinner.setBackgroundResource(R.drawable.rectangle_edge);
                    dinner.setTextColor(getResources().getColor(R.color.white));
                }else{
                    dinner.setBackgroundResource(R.drawable.rectangle_white);
                    dinner.setTextColor(getResources().getColor(R.color.black));
                }
                break;
            case R.id.book_btn:
                c++;
                if(c%2 == 1){
                    book_table.setBackgroundResource(R.drawable.rectangle_edge);
                    book_table.setTextColor(getResources().getColor(R.color.white));
                }else{
                    book_table.setBackgroundResource(R.drawable.rectangle_white);
                    book_table.setTextColor(getResources().getColor(R.color.black));
                }

                break;
            case R.id.viewcart:
                startActivity(new Intent(RestarantDetails.this,MyCart.class));
                break;
        }

    }
}


