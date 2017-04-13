package com.wma.ozfoodhunter.fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by MATHI on 11-07-2016.
 */
public class TextView_Normal extends TextView {

        public TextView_Normal(Context context) {
            super(context);

            applyCustomFont(context);
        }

        public TextView_Normal(Context context, AttributeSet attrs) {
            super(context, attrs);

            applyCustomFont(context);
        }

        public TextView_Normal(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);

            applyCustomFont(context);
        }

        private void applyCustomFont(Context context) {
            Typeface customFont = FontCache.getTypeface("HelveticaNeue.ttf", context);
            setTypeface(customFont);
        }

}
