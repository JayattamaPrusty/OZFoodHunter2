package com.wma.ozfoodhunter.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.wma.ozfoodhunter.BeanClasses.Dishdetail;
import com.wma.ozfoodhunter.Fragments.PreferenceDialog;
import com.wma.ozfoodhunter.R;
import com.wma.ozfoodhunter.RestarantDetails;
import com.wma.ozfoodhunter.Utils.AllValidation;
import com.wma.ozfoodhunter.database.Localdb;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Jayattama Prusty on 21-Apr-17.
 */

public class PriceRecycleAdapter extends RecyclerView.Adapter<PriceRecycleAdapter.ViewHolder> {

    Context context;
    Dishdetail dishdetail;
    Localdb localdb;

    public PriceRecycleAdapter(Context context, Dishdetail dishdetail) {
        this.context = context;
        this.dishdetail = dishdetail;

    }

    @Override
    public PriceRecycleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pricerecyclemodellay, parent, false);
        System.out.println("View Holder");
        // set the view's size, margins, paddings and layout parameters
        PriceRecycleAdapter.ViewHolder vh = new PriceRecycleAdapter.ViewHolder(v);
        localdb=new Localdb(context);
        return vh;
    }

    @Override
    public void onBindViewHolder(PriceRecycleAdapter.ViewHolder holder, int position) {

                holder.childitemsize.setText(dishdetail.getStPrice().get(position).getPriceItem());
                holder.price.setText("$" + dishdetail.getStPrice().get(position).getMenuPrice());
        if (dishdetail.getStPrice().size()>1){
            holder.childitemsize.setText(dishdetail.getStPrice().get(1).getPriceItem());
            holder.price.setText("$" + dishdetail.getStPrice().get(1).getMenuPrice());
        }
                holder.childlay.setOnClickListener(new View.OnClickListener()
                {
            @Override
            public void onClick(View v) {
                int qty=0;
                if(dishdetail.getExtrasdetail().size()>0){
                    RestarantDetails activity = (RestarantDetails)(context);
                    FragmentManager fm = activity.getSupportFragmentManager();
                    PreferenceDialog alertDialog = new PreferenceDialog();
                    Bundle bundle;
                    bundle = new Bundle();
                    bundle.putSerializable("extrasdetaillist", (Serializable) dishdetail.getExtrasdetail());
                    alertDialog.setArguments(bundle);
                    alertDialog.show(fm, "fragment_alert");
                }
                else {
                    qty++;
//                    localdb.insertCategory(" "," ",qty);
                    AllValidation.myToast(context,"dish is successfully added to cart ");
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView childitemsize,price;
        public LinearLayout childlay;
        public ViewHolder(View itemView) {
            super(itemView);
            childitemsize=(TextView)itemView.findViewById(R.id.txt2);
            price=(TextView)itemView.findViewById(R.id.txt3);
            childlay=(LinearLayout)itemView.findViewById(R.id.card_view);
        }
    }
}
