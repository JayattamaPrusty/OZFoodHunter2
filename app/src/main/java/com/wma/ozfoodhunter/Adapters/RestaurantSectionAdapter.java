package com.wma.ozfoodhunter.Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.afollestad.sectionedrecyclerview.SectionedRecyclerViewAdapter;
import com.wma.ozfoodhunter.BeanClasses.RestaurantItemBeans;
import com.wma.ozfoodhunter.R;
import com.wma.ozfoodhunter.Widgets.Constants;

import java.util.ArrayList;

/**
 * Created by Jayattama on 16-Mar-17.
 */

public class RestaurantSectionAdapter extends SectionedRecyclerViewAdapter<RecyclerView.ViewHolder> {


    public LocalBroadcastManager broadcaster;
    private ArrayList<RestaurantItemBeans> itemlist;

    String listType="";
    private Context ctx;
    Activity activity;
    float total=0;
    String totalprice;

    public RestaurantSectionAdapter(Context context, ArrayList<RestaurantItemBeans> itemlist) {
        this.itemlist = itemlist;
        ctx = context;
        this.listType = listType;
        this.activity=(Activity)ctx;
        broadcaster = LocalBroadcastManager.getInstance(context);
    }


    @Override
    public int getSectionCount() {
        return 1;
    }

    @Override
    public int getItemCount(int section) {

        return 3;

    }


    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder, int section) {
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        String c= Constants.cuisines[section];
 //       itemViewHolder.titlesection.setText(c);

    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int section, final int relativePosition, int absolutePosition) {

        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        String c= Constants.cuisines[relativePosition];
        itemViewHolder.itemchild.setText(c);

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // Change inflated layout based on 'header'.
        View v = LayoutInflater.from(parent.getContext())
                .inflate(viewType == VIEW_TYPE_HEADER ? R.layout.list_item_section : R.layout.list_item, parent, false);
        return new ItemViewHolder(v);


    }


   // ItemViewHolder Class for Items in each Section
    public static class ItemViewHolder extends RecyclerView.ViewHolder {

       TextView titlesection,price;
       CheckBox itemchild;

        public ItemViewHolder(View itemView) {
            super(itemView);
     //       titlesection=(TextView)itemView.findViewById(R.id.itemtitle);
            price=(TextView)itemView.findViewById(R.id.price);
            itemchild=(CheckBox) itemView.findViewById(R.id.check);


        }
    }

}
