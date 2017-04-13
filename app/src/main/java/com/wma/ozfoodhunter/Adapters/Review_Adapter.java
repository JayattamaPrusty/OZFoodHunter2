package com.wma.ozfoodhunter.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wma.ozfoodhunter.R;
import com.wma.ozfoodhunter.Reviews;
import com.wma.ozfoodhunter.Widgets.Constants;

/**
 * Created by mathivanan on 11/03/17.
 */

public class Review_Adapter extends RecyclerView.Adapter<Review_Adapter.ViewHolder>{



    private Context ctx;
    private Restaurant_Adapter.OnItemClickListener mOnItemClickListener;


    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(final Restaurant_Adapter.OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }


    // Provide a suitable constructor (depends on the kind of dataset)
    public Review_Adapter(Context context) {
        ctx = context;

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View v) {
            super(v);
        }
    }

    @Override
    public Review_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_row, parent, false);
        System.out.println("View Holder");
        // set the view's size, margins, paddings and layout parameters
        Review_Adapter.ViewHolder vh = new Review_Adapter.ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final Review_Adapter.ViewHolder holder, final int position) {

    }

    // Here is the key method to apply the animation
    private int lastPosition = -1;
    private void setAnimation(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(ctx, R.anim.slide_in_bottom);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return  10;
    }


}
