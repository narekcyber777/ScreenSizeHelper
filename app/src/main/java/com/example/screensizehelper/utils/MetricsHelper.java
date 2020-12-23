package com.example.screensizehelper.utils;

import android.content.Context;
import android.content.res.Resources;

import java.util.LinkedHashMap;
import java.util.Map;

public class MetricsHelper {
    private  Context context;

    private static  final MetricsHelper INSTANCE=new MetricsHelper();

    public static MetricsHelper getInstance(Context context){
        INSTANCE.setContext(context);
        return  INSTANCE;
    }
    private void setContext(Context context){
        this.context=context;
    }
    public Map<MyResourceUtils.VALUE,Integer> convert(float val, MyResourceUtils.VALUE vl){
        Map<MyResourceUtils.VALUE,Integer> oMap=new LinkedHashMap<>();
        float mdpi=convertStart(val,vl);

        oMap.put(MyResourceUtils.VALUE.LDPI,(int)(mdpi*MyResourceUtils.LDPI));
        oMap.put(MyResourceUtils.VALUE.MDPI,(int)mdpi);
        oMap.put(MyResourceUtils.VALUE.HDPI,(int)(mdpi*MyResourceUtils.HDPI));
        oMap.put(MyResourceUtils.VALUE.XHDPI,(int)(mdpi*MyResourceUtils.XHDPI));
        oMap.put(MyResourceUtils.VALUE.XXHDPI,(int)(mdpi*MyResourceUtils.XXHDPI));
        oMap.put(MyResourceUtils.VALUE.XXXHDPI,(int)(mdpi*MyResourceUtils.XXXHDPI));


        return  oMap;
    }

    /**
     * starting to convert everything to mdpi;
     * @param value (value which will be converted)
     * @param vl (type)
     * @return
     */

    private  float convertStart(float value, MyResourceUtils.VALUE vl){

        switch (vl){
            case PX:
                return  MyResourceUtils.pxToDp(MyResourceUtils.VALUE.MDPI,value);

            case LDPI:
                return  value/ MyResourceUtils.LDPI;

            case MDPI:
                return value;

            case HDPI:
                return  value/MyResourceUtils.HDPI;

            case XHDPI:

                return  value/MyResourceUtils.XHDPI;

            case XXHDPI:
                return  value/MyResourceUtils.XXHDPI;


            case XXXHDPI:
                return  value/MyResourceUtils.XXXHDPI;
        }


        return 0;
    }


}
