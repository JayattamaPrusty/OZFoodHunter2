package com.wma.ozfoodhunter.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wma.ozfoodhunter.R;
import com.wma.ozfoodhunter.Widgets.Constants;

/**
 * Created by Jayattama Prusty on 23-Mar-17.
 */

public class MyCartAdapter extends RecyclerView.Adapter<MyCartAdapter.ViewHolder> {

   Context context;


    public MyCartAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MyCartAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mycart_listitem_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyCartAdapter.ViewHolder vh = new MyCartAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyCartAdapter.ViewHolder holder, int position) {
        final String c = Constants.names[position];
        holder.itemname.setText(c);
        holder.delete.setVisibility(View.VISIBLE);
        holder.sub.setVisibility(View.VISIBLE);
        holder.add.setVisibility(View.VISIBLE);

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView itemname,qty,price,add,sub;

        ImageView delete;
        public ViewHolder(View itemView) {
            super(itemView);
            itemname=(TextView)itemView.findViewById(R.id.itemname);
            qty=(TextView)itemView.findViewById(R.id.itemqty);
            price=(TextView)itemView.findViewById(R.id.itemprice);
            add=(TextView)itemView.findViewById(R.id.itemqty_add);
            sub=(TextView)itemView.findViewById(R.id.itemqty_sub);
            delete=(ImageView) itemView.findViewById(R.id.delete);
        }
    }
}
