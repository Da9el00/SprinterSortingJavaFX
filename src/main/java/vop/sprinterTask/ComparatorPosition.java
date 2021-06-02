package vop.sprinterTask;

import java.util.Comparator;

public class ComparatorPosition implements Comparator<Sprinter> {

    @Override
    public int compare(Sprinter o1, Sprinter o2) {
        if(o1.getOverAllPosition() < o2.getOverAllPosition()){
            return -1;
        } else if(o1.getOverAllPosition() > o2.getOverAllPosition()){
            return 1;
        } else{
            return Integer.compare(o1.getRaceNo(), o2.getRaceNo());
        }
    }
}
