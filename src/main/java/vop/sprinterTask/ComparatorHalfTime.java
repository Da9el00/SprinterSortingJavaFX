package vop.sprinterTask;

import java.util.Comparator;

public class ComparatorHalfTime implements Comparator<Sprinter> {
    @Override
    public int compare(Sprinter o1, Sprinter o2) {

        if(halfTmeToSeconds(o1.getHalfTime()) < halfTmeToSeconds(o2.getHalfTime())){
            return -1;
        } else if(halfTmeToSeconds(o1.getHalfTime()) > halfTmeToSeconds(o2.getHalfTime())){
            return 1;
        } else {
            return Integer.compare(o1.getRaceNo(), o2.getRaceNo());
        }
    }

    private int halfTmeToSeconds(String halfTime){
        int timeInSeconds = 0;
        String[] time = halfTime.split(":");
        timeInSeconds += Integer.parseInt(time[0]) * 60 * 60;
        timeInSeconds += Integer.parseInt(time[1]) * 60;
        timeInSeconds += Integer.parseInt(time[2]);
        return timeInSeconds;
    }
}
