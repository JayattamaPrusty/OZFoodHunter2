package com.wma.ozfoodhunter.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.CountDownTimer;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.wma.ozfoodhunter.BeanClasses.Restaurant_model;
import com.wma.ozfoodhunter.BeanClasses.StDinnerTime;
import com.wma.ozfoodhunter.BeanClasses.StLunchTime;
import com.wma.ozfoodhunter.BookTable;
import com.wma.ozfoodhunter.MyCart;
import com.wma.ozfoodhunter.Offers;
import com.wma.ozfoodhunter.R;
import com.wma.ozfoodhunter.RestarantDetails;
import com.wma.ozfoodhunter.Reviews;
import com.wma.ozfoodhunter.Utils.Commons;
import com.wma.ozfoodhunter.Widgets.Constants;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by mathivanan on 12/02/17.
 */

public class Restaurant_Adapter extends RecyclerView.Adapter<Restaurant_Adapter.ViewHolder>{


    private List<Restaurant_model> restaurant_modelList;
    private Context ctx;
    private OnItemClickListener mOnItemClickListener;
    private  int flagbtn;

    public Restaurant_Adapter(Context ctx, List<Restaurant_model> restaurant_modelList,int flagbtn) {
        this.ctx = ctx;
        this.restaurant_modelList = restaurant_modelList;
        this.flagbtn=flagbtn;
    }


    public interface OnItemClickListener {
        void onItemClick(View view,  int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView restaurant_name,location_add,delivery,min_delivery,pick,delivery_fee,reviews;
        public RatingBar ratingBar;
        public ImageView image;
        public LinearLayout lyt_parent;
        Button offerzone,booktable;
        TextView timer;

        public ViewHolder(View v) {
            super(v);
            ratingBar=(RatingBar)v.findViewById(R.id.rating);
            image = (ImageView) v.findViewById(R.id.image);
            restaurant_name = (TextView) v.findViewById(R.id.restaurant_name);
            location_add=(TextView)v.findViewById(R.id.location);
            delivery=(TextView)v.findViewById(R.id.delivery);
            min_delivery=(TextView)v.findViewById(R.id.min_delivery_fee);
            pick=(TextView)v.findViewById(R.id.pickup);
            delivery_fee=(TextView)v.findViewById(R.id.deliveryfee);
            reviews = (TextView) v.findViewById(R.id.reviews);
            lyt_parent = (LinearLayout) v.findViewById(R.id.lyt_parent);
            offerzone = (Button) v.findViewById(R.id.offerzone);
            booktable = (Button) v.findViewById(R.id.book_table);
            timer = (TextView) v.findViewById(R.id.timer);
        }
    }

    @Override
    public Restaurant_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_row, parent, false);
        System.out.println("View Holder");
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final Restaurant_model restaurant_model=restaurant_modelList.get(position);
        Commons.in_restaurant_id=restaurant_model.getInRestaurantId();
        String imageurl=restaurant_model.getImage();
        imageurl=imageurl.replace(" ","%20");
        imageurl=imageurl.replace("\\\\","/");
        imageurl=imageurl.replace("\\","/");
        restaurant_model.setImage(imageurl);

        Log.d("imageurl:",imageurl);
        Glide.with(ctx)
                .load(imageurl)
                .fitCenter()
                .into(holder.image);
       Calendar calander = Calendar.getInstance();
       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

       String  time = simpleDateFormat.format(calander.getTime());


//        Long tsLong = System.currentTimeMillis()/1000;
//        String ts = tsLong.toString();

        CountDownTimer timer=new CountDownTimer(600000, 1000) {
            public void onTick(long millisUntilFinished) {
                holder.timer.setText(""+String.format("%d:%d:%d",
                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                        toMinutes(millisUntilFinished))));
            }

            public void onFinish() {
                holder.timer.setVisibility(View.GONE);
            }
        };
        timer.start();

        holder.restaurant_name.setText(restaurant_model.getStRestaurantName());
        holder.location_add.setText(restaurant_model.getStStreetAddress()+","+restaurant_model.getStSuburb());
        if(flagbtn==1)
        {  if((restaurant_model.getDeliverySchedule().getDel_start_time_lunch() == null) || restaurant_model.getDeliverySchedule().getDel_start_time_dinner() == null)
            {
                holder.delivery.setText("Del :"+" " );
            }else
            {
                String lunch = restaurant_model.getDeliverySchedule().getDel_start_time_lunch() + "-" + restaurant_model.getDeliverySchedule().getDel_close_time_lunch();
                String dinner = restaurant_model.getDeliverySchedule().getDel_start_time_dinner() + "-" + restaurant_model.getDeliverySchedule().getDel_close_time_dinner();
                holder.delivery.setText("Del :" + lunch + "," + dinner);
            }
            holder.min_delivery.setText("Min delivery :" + "$" + restaurant_model.getStMinOrder());
     //       String lunch_pick = restaurant_model.getPickupSchedule().getPick_start_time_lunch() + "-" + restaurant_model.getPickupSchedule().getPick_close_time_lunch();
    //        String dinner_pick = restaurant_model.getPickupSchedule().getPick_start_time_dinner() + "-" + restaurant_model.getPickupSchedule().getPick_close_time_dinner();
            holder.pick.setText(" ");
            holder.delivery_fee.setText("Delivery Fee:" + "$" + restaurant_model.getStDeliveryCharge());
        }else
        {
            holder.delivery.setText(" ");
            holder.min_delivery.setText("Min delivery :" + " Any ");

            if((restaurant_model.getPickupSchedule().getPick_start_time_lunch() == null) || restaurant_model.getPickupSchedule().getPick_start_time_dinner() == null)
            {
                holder.pick.setText("Pick :"+" " );
            }else
            {
                String lunch_pick = restaurant_model.getPickupSchedule().getPick_start_time_lunch() + "-" + restaurant_model.getPickupSchedule().getPick_close_time_lunch();
                String dinner_pick = restaurant_model.getPickupSchedule().getPick_start_time_dinner() + "-" + restaurant_model.getPickupSchedule().getPick_close_time_dinner();
                holder.pick.setText("Pick :" + lunch_pick + "," + dinner_pick);
            }

            holder.delivery_fee.setText(" Free delivery ");
        }
        if(restaurant_model.getAgree_table_booking().equalsIgnoreCase("1")){

            holder.booktable.setVisibility(View.GONE);

        }else{
            holder.booktable.setVisibility(View.VISIBLE);
        }
        holder.booktable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ctx, BookTable.class);
                intent.putExtra("res_id",restaurant_model.getInRestaurantId());
                intent.putExtra("res_img",restaurant_model.getImage());
                intent.putExtra("res_name",restaurant_model.getStRestaurantName());
                intent.putExtra("rest_street_details",restaurant_model.getStStreetAddress()+","+restaurant_model.getStSuburb()+","+restaurant_model.getStPostcode());
                intent.putExtra("rest_close_open_rest_venue_cuisine",restaurant_model.getClose_open_st()+","+restaurant_model.getStVenueCuisine());
                ctx.startActivity(intent);
            }
        });

        final float ratingfloat=(float)restaurant_model.getReview().getRating();
        holder.ratingBar.setRating(ratingfloat);
        holder.reviews.setText("("+restaurant_model.getReview().getTotalReview()+")"+"Reviews");

        holder.reviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(ctx,Reviews.class);
                in.putExtra("Image",restaurant_model.getImage());
                in.putExtra("Name",restaurant_model.getStRestaurantName());
                in.putExtra("Address",restaurant_model.getStStreetAddress()+","+restaurant_model.getStSuburb());
                in.putExtra("Rating",ratingfloat);
                in.putExtra("Reviews",restaurant_model.getReview().getTotalReview());
                ctx.startActivity(in);
            }
        });
        holder.offerzone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(ctx,Offers.class);
                in.putExtra("Image",restaurant_model.getImage());
                in.putExtra("Name",restaurant_model.getStRestaurantName());
                in.putExtra("Address",restaurant_model.getStStreetAddress()+","+restaurant_model.getStSuburb());
                ctx.startActivity(in);
            }
        });

        holder.lyt_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Clicked View");
                Intent in = new Intent(ctx, RestarantDetails.class);
                in.putExtra("Position", position);
                in.putExtra("res_id", restaurant_model.getInRestaurantId());
                in.putExtra("res_name",restaurant_model.getStRestaurantName());
                in.putExtra("res_image",restaurant_model.getImage());
                in.putExtra("res_venue_cuisine",restaurant_model.getStVenueCuisine());
                in.putExtra("res_min_order",restaurant_model.getStMinOrder());
                in.putExtra("res_delivery_fee",restaurant_model.getStDeliveryCharge());
                in.putExtra("rest_street_details",restaurant_model.getStStreetAddress()+","+restaurant_model.getStSuburb()+","+restaurant_model.getStPostcode());
                in.putExtra("rest_close_open_rest_venue_cuisine",restaurant_model.getClose_open_st()+","+restaurant_model.getStVenueCuisine());
                ctx.startActivity(in);
            }
        });

      /*  holder.lyt_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(view,position);
                }
            }
        });*/
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
        return restaurant_modelList.size();
    }


}
