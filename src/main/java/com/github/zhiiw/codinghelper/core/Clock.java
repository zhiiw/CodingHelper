package core;
import com.intellij.openapi.diagnostic.Logger;
import org.graalvm.compiler.replacements.Log;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class Clock {
    public static Timer timer;

    private long currentTime;
    private long maxium;
    private static final Logger LOG = Logger.getInstance("#com.intellij.notification.NotificationGroup");

    public void setTimer(Timer timer) {

    }
    public static long endTime;
    public static Date date;
    public static long startTime;
    public static long midTime;
    public static Calendar c;
    public static int time = 60 * 60;
/*
    public void startClock() {


        c = Calendar.getInstance();

        endTime = c.getTimeInMillis();
        date = new Date();
        startTime = date.getTime();
        midTime = (endTime - startTime) / 1000;
        time1();
    }
    private static void time1() {
        while (time > 0) {
            time-=10;
            try {
                Thread.sleep(1000);
                int hh = time / 60 / 60 % 60;
                int mm = time / 60 % 60;
                int ss = time % 60;
                LOG.info(mm + "minutes" + ss + "seconds");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private LocalDateTime startDateTime;
    private LocalDateTime currentDateTime;

    public boolean timeOut(){
        return currentTime>=maxium;
    }
    public int restOfTime(){
        currentDateTime.toLocalTime().getLong();
        LocalDateTime rest = currentDateTime.minus(startDateTime);
        return rest;

    }
    public int returnHour(){
        int hour = (int) (currentTime/(1000000*60*60));
        return hour;
    }
    public int returnMinutes(){
        int minutes = (int) (currentTime/(1000000*60*60));
        return minutes;
    }
    public int returnSecond(){
        int second = (int) (currentTime/(1000000*60*60));
        return second;
    }
    **/
}
