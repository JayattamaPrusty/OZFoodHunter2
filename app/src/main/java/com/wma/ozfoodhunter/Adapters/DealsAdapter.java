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
 * Created by Jayattama on 14-Mar-17.
 */

public class DealsAdapter extends RecyclerView.Adapter<DealsAdapter.ViewHolder> {

    Context ctx;
    private DealsAdapter.OnItemClickListener mOnItemClickListener;


    public interface OnItemClickListener {
        void onItemClick(View view,  int position);
    }

    public void setOnItemClickListener(final DealsAdapter.OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }


    public DealsAdapter(Context context) {
        this.ctx=context;
    }
    @Override
    public DealsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.deals_item_section,parent,false);

        return new DealsAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(DealsAdapter.ViewHolder holder, int position) {
        ViewHolder v=(ViewHolder)holder;
        String c= Constants.names[position];
        int e=Constants.draws[position];
        v.restaurant_name.setText(c);
        v.restarant_icon.setImageResource(e);


    }

    @Override
    public int getItemCount() {
        return Constants.names.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView restaurant_name,location,flatoffer,offerdetails;
        ImageView restarant_icon;
        public ViewHolder(View itemView)
        {
            super(itemView);
            restaurant_name=(TextView)itemView.findViewById(R.id.restaurant_name);
            location=(TextView)itemView.findViewById(R.id.location);
            flatoffer=(TextView)itemView.findViewById(R.id.flatoffer);
            offerdetails=(TextView)itemView.findViewById(R.id.offerdetails);
            restarant_icon=(ImageView) itemView.findViewById(R.id.img);

        }
    }
}
