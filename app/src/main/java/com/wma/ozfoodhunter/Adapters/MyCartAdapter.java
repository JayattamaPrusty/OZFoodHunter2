package com.wma.ozfoodhunter.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wma.ozfoodhunter.BeanClasses.Cart_Model;
import com.wma.ozfoodhunter.R;
import com.wma.ozfoodhunter.Widgets.Constants;

import java.util.List;

/**
 * Created by Jayattama Prusty on 23-Mar-17.
 */

public class MyCartAdapter extends RecyclerView.Adapter<MyCartAdapter.ViewHolder> {

   Context context;
    List<Cart_Model.Cart_Details> cart_detailsList;

    public MyCartAdapter(Context context, List<Cart_Model.Cart_Details> cart_detailsList) {
        this.context = context;
        this.cart_detailsList = cart_detailsList;
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
    public void onBindViewHolder(final MyCartAdapter.ViewHolder holder, final int position) {

        holder.itemname.setText(cart_detailsList.get(position).getSt_dish_name());
        String qnty_no=cart_detailsList.get(position).getQuantity();
        holder.qty.setText("x "+qnty_no);
        String priceamount=cart_detailsList.get(position).getMenu_price();
        holder.price.setText("$ "+priceamount);
        holder.delete.setVisibility(View.VISIBLE);
        holder.sub.setVisibility(View.VISIBLE);
        holder.add.setVisibility(View.VISIBLE);

        int intCount= Integer.parseInt(qnty_no);
        float priceint=Float.parseFloat(priceamount);



        holder.sub.setVisibility(View.INVISIBLE);


        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String quantity=holder.qty.getText().toString();
             //   quantity=quantity.substring(3);
                holder.sub.setVisibility(View.VISIBLE);
                quantity=quantity.replace("x ","");
                int intCount= Integer.parseInt(quantity);
                intCount++;
                holder.qty.setText("x "+intCount);
                float pricefloat=Float.parseFloat(cart_detailsList.get(position).getMenu_price());
                float totalprice=pricefloat*intCount;
                holder.price.setText("$ "+totalprice);

            }
        });
        holder.sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String quantity=holder.qty.getText().toString();
                //   quantity=quantity.substring(3);
                quantity=quantity.replace("x ","");
                int intCount= Integer.parseInt(quantity);
                if(intCount>1){
                    holder.sub.setVisibility(View.VISIBLE);
                    intCount--;
                    holder.qty.setText("x "+intCount);
                    float pricefloat=Float.parseFloat(cart_detailsList.get(position).getMenu_price());
                    float totalprice=pricefloat*intCount;
                    holder.price.setText("$ "+totalprice);
                    if (intCount==1){
                        holder.sub.setVisibility(View.INVISIBLE);
                    }
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return cart_detailsList.size();
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
