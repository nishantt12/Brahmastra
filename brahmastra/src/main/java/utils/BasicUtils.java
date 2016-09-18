package utils;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.text.TextUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by nishant on 11/7/16.
 */
public class BasicUtils {


    public static String getInviteUrl(String url, String appName) {
        String shareUrl = "Download " + appName + " app by clicking:\n " + url;
        return shareUrl;
    }


    public static void getShareActions(Context context, String text) {

        final Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, text);

        context.startActivity(shareIntent);

//        return BottomSheetHelper.shareAction(context, shareIntent);
    }


    public final static boolean isValidEmail(CharSequence target) {
        if (TextUtils.isEmpty(target)) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

    public static boolean isValidMobile(String phone) {
        return android.util.Patterns.PHONE.matcher(phone).matches();
    }


    public static String getISO(Date date, String timeFormat) {

        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat(timeFormat); // Quoted "Z" to indicate UTC, no timezone offset
        df.setTimeZone(tz);
        String nowAsISO = df.format(date);

        return nowAsISO;
    }


    public static Date getDate(int hour, int time, int year, int month, int day) {

        final Calendar calendar = Calendar.getInstance();

        calendar.set(year, month, day, hour, time);


        Date date = calendar.getTime();

        return date;


    }


    public static String getDeviceId(Context context) {
        String android_id = Settings.Secure.getString(context.getContentResolver(),
                Settings.Secure.ANDROID_ID);

        if (android_id != null) {

            return android_id;
        } else {
            return "";
        }
    }






}
