package com.wma.ozfoodhunter.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wma.ozfoodhunter.R;
import com.wma.ozfoodhunter.Restaurant_Activity;
import com.wma.ozfoodhunter.Widgets.Constants;
import com.wma.ozfoodhunter.Widgets.MyBounceInterpolator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mathivanan on 27/09/16.
 */

public class Item_Adapter extends RecyclerView.Adapter<Item_Adapter.ViewHolder> {


    private Context ctx;
    int totalitems=0;
    String truckId="";
    private Item_Adapter.OnItemClickListener mOnItemClickListener;
    public Item_Adapter(Context context) {
        ctx = context;
    }


    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(final Item_Adapter.OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView dishname,description,add;
        LinearLayout lyt_parent,added;

        public ViewHolder(View v) {
            super(v);
            added = (LinearLayout) v.findViewById(R.id.added);
            lyt_parent = (LinearLayout) v.findViewById(R.id.lyt_parent);
            dishname = (TextView) v.findViewById(R.id.itemname);
            add = (TextView) v.findViewById(R.id.add);
            description = (TextView) v.findViewById(R.id.description);
        }
    }

    @Override
    public Item_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_dish_row, parent, false);
        // set the view's size, margins, paddings and layout parameters
        Item_Adapter.ViewHolder vh = new Item_Adapter.ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final Item_Adapter.ViewHolder holder, final int position) {
        final String c = Constants.dishes[position];
        holder.dishname.setText(c);
        final Animation animBounce = AnimationUtils.loadAnimation(ctx, R.anim.bounce);
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        animBounce.setInterpolator(interpolator);
        if(position%2==0){
            holder.add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }else{
            holder.add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                Restaurant_Activity.viewcart.startAnimation(animBounce);
                }
            });
        }
        holder.lyt_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(view,position);
                }
            }
        });
    }



    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return Constants.dishes.length;
    }

}


