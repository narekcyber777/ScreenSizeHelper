package com.example.screensizehelper.utils;

import android.content.res.Resources;
import android.renderscript.Sampler;
import android.util.DisplayMetrics;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class MyResourceUtils {

    public enum VALUE{
        PX,MDPI,LDPI,HDPI,XHDPI,XXHDPI,XXXHDPI
    }
    public  static  final float LDPI=0.75f,MDPI=1.0f,HDPI=1.5f,XHDPI=2.0f,XXHDPI=3.0f,XXXHDPI=4.0f;


    public  static  final float COF_D(VALUE value){
        switch (value){
            case LDPI:
                return  LDPI;
            case MDPI:
                return MDPI;
            case HDPI:
               return  HDPI;

            case XHDPI:
               return  XHDPI;

            case XXHDPI:
                return  XXHDPI;

            case XXXHDPI:
                return  XXXHDPI;

            default:

                return  1;
        }

    }



    public static float pxToDp(VALUE value, float px){
        final float cof=COF_D(value);
        float dp = px / cof;
        return dp;

    }
    public static float dpToPx(VALUE value, float dp){
        final float cof=COF_D(value);

        float px = dp * cof;
        return px;
    }


}
