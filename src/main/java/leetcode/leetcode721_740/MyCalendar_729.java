package leetcode.leetcode721_740;

/*Implement a MyCalendar class to store your events.
        A new event can be added if adding the event will not cause a double booking.

        Your class will have the method, book(int start, int end).
        Formally, this represents a booking on the half open interval [start, end),
        the range of real numbers x such that start <= x < end.

        A double booking happens when two events have some non-empty intersection
        (ie., there is some time that is common to both events.)

        For each call to the method MyCalendar.book, return true
        if the event can be added to the calendar successfully without causing a double booking.
        Otherwise, return false and do not add the event to the calendar.*/

import java.util.TreeMap;

public class MyCalendar_729 {
    TreeMap<Integer, Integer> intervals; // all nonoverlapping intervals in the calendar

    public MyCalendar_729() {
        intervals = new TreeMap<>();

    }

    public boolean book(int start, int end) {
        Integer floor = intervals.floorKey(start);
        Integer ceiling = intervals.ceilingKey(start);

        if(floor == null && ceiling == null){
            // calendar is empty
            intervals.put(start, end);
            return true;
        }

        if(ceiling == null) {
            // overlap with interval starting in floor?
            if (start < intervals.get(floor)) {
                return false;
            }
            if (start == intervals.get(floor)) {
                // update interval
                intervals.put(floor, end);
                return true;
            }
            intervals.put(start, end);
            return true;
        }

        if(floor == null){
            // overlap with interval starting in ceiling?
            if(end > ceiling){
                return false;
            }
            if(end == ceiling){
                // update interval
                intervals.put(start, intervals.get(ceiling));
                intervals.remove(ceiling);
                return true;
            }
            intervals.put(start, end);
            return true;
        }

        // both ceiling and floor exist
        // overlap with interval starting from floor
        if(start < intervals.get(floor)){
            return false;
        }
        // overlap with interval starting from ceiling
        if(end > ceiling){
            return false;
        }



        // no overlap, but maybe we need to merge the intervals
        if(start == intervals.get(floor)){
            // update interval
            intervals.put(floor, end);
        }

        else if(end == ceiling){
            intervals.put(start, intervals.get(ceiling));
            intervals.remove(ceiling);
        }

        else{
            intervals.put(start, end);
        }

        return true;


    }
}
