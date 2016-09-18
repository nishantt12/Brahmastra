package utils;

import org.ocpsoft.prettytime.PrettyTime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by nishant on 24/8/16.
 */
public class DateTimeUtil {

    public static String getTimeDiff(String time, String timeFormat) {

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(timeFormat);
            dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            Date date = dateFormat.parse(time);

//            Date dateCurrent = new Date();

            PrettyTime prettyTime = new PrettyTime();

            return prettyTime.format(date);

//            return printDifference(dateCurrent, date);


        } catch (Exception e) {

            return null;
        }

    }


    public static String getTime(String time, String timeFormat) {

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(timeFormat);
            dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            Date date = dateFormat.parse(time);

            String timeString = date.getDay() + "/" + date.getMonth();

            return timeString;


        } catch (Exception e) {

            return null;
        }

    }


    public static String getTime(Date date, String format) {

        try {
            String your_format = new SimpleDateFormat(format).format(date);

            return your_format;


        } catch (Exception e) {

            return null;
        }

    }


    public static String getExactTimeAndDate(String time, String timeFormat, String displayFormat) {

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(timeFormat);
            dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            Date date = dateFormat.parse(time);

//            PrettyTime prettyTime = new PrettyTime();

//            L.e(prettyTime + "   " + time);

            System.out.println(date);
            String your_format = new SimpleDateFormat(displayFormat).format(date);


//            return prettyTime.format(date) + "\n" + time;

            return your_format;

        } catch (Exception e) {

            return null;
        }

    }


    public static String getTimeFormat2(String time, String format, String timeFormat) {

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(timeFormat);
            dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            Date date = dateFormat.parse(time);

            System.out.println(date);
            String your_format = new SimpleDateFormat(format).format(date);

            return your_format;

        } catch (Exception e) {

            return null;
        }

    }


    public static String printDifference(Date startDate, Date endDate) {

        //milliseconds
        long different = endDate.getTime() - startDate.getTime();


        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;

        long ten_extra_min = 10 * minutesInMilli;

        if (ten_extra_min < different) {
            different = different - ten_extra_min;
        }

        long elapsedDays = different / daysInMilli;
        different = different % daysInMilli;

        long elapsedMinutes = different / minutesInMilli;

        long elapsedHours = different / hoursInMilli;
        different = different % hoursInMilli;


        if (elapsedDays < 1) {

            return "Today";

        } else if (elapsedDays == 1) {
            return "Yesterday";
        } else {
            return elapsedDays + " days later";
        }


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


}
