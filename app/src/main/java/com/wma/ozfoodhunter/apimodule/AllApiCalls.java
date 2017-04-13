package com.wma.ozfoodhunter.apimodule;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import  com.wma.ozfoodhunter.Utils.AllValidation;
import  com.wma.ozfoodhunter.Utils.LoaderDiloag;
import  com.wma.ozfoodhunter.Utils.Utils;

import java.util.HashMap;
import java.util.Map;


public class AllApiCalls {


    public void callPost(String url, final Context mContext, final ResponseHandle reshandler, final String action,final Map<String, String> params) {


        Log.d("URL",url);
        if (Utils.isNetworkConnected(mContext)) {
            final LoaderDiloag loaderDiloag = new LoaderDiloag(mContext);
            loaderDiloag.displayDiloag();
            // Request a string response
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            // Result handling
                            Log.d("response", response);
                            reshandler.onComplete(response, action, null);
                            loaderDiloag.dismissDiloag();
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    // Error handling
                    Log.e("erreor",""+ error);
                    System.out.println("Something went wrong!");
                    error.printStackTrace();
                    loaderDiloag.dismissDiloag();

                }
            })
            {
                @Override
                protected Map<String, String> getParams()
                {
//                    params = new HashMap<String, String>();
//                    params.put("tag", "test");
                    return params;
                }

            };


            stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                    1000*60*3,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            Volley.newRequestQueue((Activity) mContext).add(stringRequest);
        }else {
            AllValidation.myToast(mContext,"please check your internet connetion!");
        }
    }


}
