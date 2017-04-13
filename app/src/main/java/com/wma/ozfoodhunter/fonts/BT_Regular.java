package com.wma.ozfoodhunter.fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by mathivanan on 20/09/16.
 */
public class BT_Regular extends Button {
    public BT_Regular(Context context) {
        super(context);

        applyCustomFont(context);
    }

    public BT_Regular(Context context, AttributeSet attrs) {
        super(context, attrs);

        applyCustomFont(context);
    }

    public BT_Regular(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        Typeface customFont = FontCache.getTypeface("HelveticaNeue-Light.otf", context);
        setTypeface(customFont);
    }
}
