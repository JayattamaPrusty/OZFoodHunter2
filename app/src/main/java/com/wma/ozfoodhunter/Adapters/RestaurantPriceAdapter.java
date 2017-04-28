package com.wma.ozfoodhunter.Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.wma.ozfoodhunter.BeanClasses.Extrasdetail;
import com.wma.ozfoodhunter.BeanClasses.StPrice;
import com.wma.ozfoodhunter.R;

import java.util.ArrayList;

/**
 * Created by Jayattama Prusty on 24-Apr-17.
 */

public class RestaurantPriceAdapter extends RecyclerView.Adapter<RestaurantPriceAdapter.ViewHolder> {
    public LocalBroadcastManager broadcaster;
    private ArrayList<StPrice> stPriceArrayList;

    String listType="";
    private Context ctx;
    Activity activity;
    float total=0;
    String totalprice;
    private RadioButton lastCheckedRB = null;

    public RestaurantPriceAdapter(Context ctx,ArrayList<StPrice> stPriceArrayList ) {
        this.stPriceArrayList = stPriceArrayList;
        this.ctx = ctx;
    }

    @Override
    public RestaurantPriceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.preference_price_lay, parent, false);
        System.out.println("View Holder");
        // set the view's size, margins, paddings and layout parameters
        RestaurantPriceAdapter.ViewHolder vh = new RestaurantPriceAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RestaurantPriceAdapter.ViewHolder holder, int position) {

        holder.itemchild.setText(stPriceArrayList.get(position).getPriceItem());
        holder.price.setText(stPriceArrayList.get(position).getMenuPrice());

    }

    @Override
    public int getItemCount() {
        return stPriceArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView price;
        CheckBox itemchild;
        LinearLayout checkboxlay;
        public ViewHolder(View itemView)
        {
            super(itemView);
            checkboxlay=(LinearLayout)itemView.findViewById(R.id.card_view_checkpref);
            itemchild=(CheckBox) itemView.findViewById(R.id.checkpreference);
            price=(TextView)itemView.findViewById(R.id.preferencestprice);
        }
    }
}
