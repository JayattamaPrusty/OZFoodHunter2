package com.wma.ozfoodhunter.Utils;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.view.View;

import com.wma.ozfoodhunter.R;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;

import java.io.File;


/**
 * Created by mathivanan on 14/09/16.
 */
public class Utils {

    // Order status
    public static String PENDING="PENDING";
    public static String DELIVERED="DELIVERED";
    public static String NA="NA";



    public static boolean isNetworkConnected(Context mContext) {
        try {
            ConnectivityManager connMgr = (ConnectivityManager)
                    mContext.getSystemService(Context.CONNECTIVITY_SERVICE); // 1
            NetworkInfo networkInfo = connMgr.getActiveNetworkInfo(); // 2
            return networkInfo != null && networkInfo.isConnected(); // 3
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static ImagePipelineConfig getFresco(Context context) {
        DiskCacheConfig diskCacheConfig = DiskCacheConfig.newBuilder(context)
                .setBaseDirectoryPath(new File(Environment.getExternalStorageDirectory().getAbsoluteFile(), context.getPackageName()))
                .setBaseDirectoryName("Lalchand Images")
                .setMaxCacheSize(512)
                .setMaxCacheSizeOnLowDiskSpace(50)
                .setMaxCacheSizeOnVeryLowDiskSpace(22)
                .build();
        ImagePipelineConfig imagePipelineConfig = ImagePipelineConfig.newBuilder(context)
                .setMainDiskCacheConfig(diskCacheConfig)
                .build();
        return imagePipelineConfig;
    }

    public static void setImage(Context ctx, Uri luri, SimpleDraweeView sv) {
        GenericDraweeHierarchy genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(ctx.getResources())
                .build();
        genericDraweeHierarchyBuilder.setProgressBarImage(new CircleProgressDrawable());

        ControllerListener controllerListener = new BaseControllerListener<ImageInfo>() {
            @Override
            public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable anim) {
            }

            @Override
            public void onFailure(String id, Throwable throwable) {
                // Failure happened
            }
        };

        // Initialize a controller and attach the listener to it.
        DraweeController controller = null;
        ImagePipeline imagePipeline = Fresco.getImagePipeline();
        boolean inMemoryCache = imagePipeline.isInBitmapMemoryCache(luri);
        controller = Fresco.newDraweeControllerBuilder()
                .setUri(luri)
                .setControllerListener(controllerListener)
                .build();
        sv.setHierarchy(genericDraweeHierarchyBuilder);
        sv.setController(controller);
    }

    public static void setRoundedImg(Context ctx, Uri imgUrl, final SimpleDraweeView img){
        img.setVisibility(View.VISIBLE);
        ControllerListener controllerListener = new BaseControllerListener<ImageInfo>() {
            @Override
            public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable anim) {

            }

            @Override
            public void onFailure(String id, Throwable throwable) {
            }
        };
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(imgUrl)
                .setControllerListener(controllerListener)
                .build();
        RoundingParams roundingParams = RoundingParams.fromCornersRadius(5f);
        roundingParams.setBorder(R.color.divder_color, (float) 1.0);
        roundingParams.setRoundAsCircle(true);
        img.getHierarchy().setRoundingParams(roundingParams);
//        if (height > 0) {
//            img.getLayoutParams().height = tv.getHeight();
//        }
//        if (width > 0) {
//            img.getLayoutParams().width = tv.getWidth();
//        }
        img.requestLayout();
        img.setController(controller);
    }


    public static void setBlurredImage(Context ctx, Uri uri, final SimpleDraweeView sv) {
        Postprocessor processor = null;
        processor = new BlurPostprocessor(ctx, 20);
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                .setPostprocessor(processor)
                .build();

        ControllerListener controllerListener = new BaseControllerListener<ImageInfo>() {
            @Override
            public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable anim) {
            }

            @Override
            public void onFailure(String id, Throwable throwable) {
            }
        };
        PipelineDraweeController controller =
                (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                        .setImageRequest(request)
                        .setControllerListener(controllerListener)
                        .setOldController(sv.getController())
                        .build();
        sv.setController(controller);
    }

    public static void loadResourceImage(int resouce_id, SimpleDraweeView imageView) {
        Uri uri = new Uri.Builder()
                .scheme(UriUtil.LOCAL_RESOURCE_SCHEME) // "res"
                .path(String.valueOf(resouce_id))
                .build();
        imageView.setImageURI(uri);
    }
}
