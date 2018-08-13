package com.mobicob.mobile.app.util;

import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtilities {

    public static Date stringToDate(String dateString){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.sssZ");
        Date myDate = null;
        try {
            myDate = df.parse(dateString);
        } catch (ParseException e) {
            Log.e("MOBICOB", e.getMessage(), e);
        }
        return myDate;
    }
}
