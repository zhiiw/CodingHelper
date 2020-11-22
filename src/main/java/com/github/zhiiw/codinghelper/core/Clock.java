package core;
import java.util.Timer;

public class Clock {
    public static Timer timer;
    private long currentTime;
    private long maxium;
    public  void setTimer(Timer timer)


    public boolean timeOut(){
        return currentTime>=maxium;
    }
    public int restOfTime(){
        int rest = (int) ((maxium-currentTime)/(60*1000000));
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
}
