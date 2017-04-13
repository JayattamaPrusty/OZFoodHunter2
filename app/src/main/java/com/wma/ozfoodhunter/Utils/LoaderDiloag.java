package com.wma.ozfoodhunter.Utils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import com.wma.ozfoodhunter.R;

/**
 * Created by mathivanan on 09/10/16.
 */
public class LoaderDiloag {
    Dialog ratingDialog;

    public LoaderDiloag(final Context mContext){
        ratingDialog=new Dialog(mContext);
        ratingDialog.setContentView(R.layout.loader_layout);
        ratingDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

    public void dismissDiloag(){
        if(ratingDialog!=null&&ratingDialog.isShowing())
            ratingDialog.dismiss();
    }

    public void displayDiloag(){
        ratingDialog.show();
    }
}
