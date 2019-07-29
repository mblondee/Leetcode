package leetcode.leetcode721_740;

/*
Implement a MyCalendarTwo class to store your events.
        A new event can be added if adding the event will not cause a triple booking.

        Your class will have one method, book(int start, int end).
        Formally, this represents a booking on the half open interval [start, end),
        the range of real numbers x such that start <= x < end.

        A triple booking happens when three events have some non-empty intersection
        (ie., there is some time that is common to all 3 events.)

        For each call to the method MyCalendar.book,
        return true if the event can be added to the calendar
        successfully without causing a triple booking. Otherwise,
        return false and do not add the event to the calendar.
*/

import java.util.TreeMap;

public class MyCalendarTwo_731 {

    TreeMap<Integer, Integer> timeLine; //point in time -> number of events
    // same idea as in 732: for start we add 1 to number of events, for end we subtract 1 of number of events
    // then we can count the running total, if we don't surpass 2 there is no problem,
    // otherwise the interval cannot be added

    public MyCalendarTwo_731() {
        timeLine = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        timeLine.put(start, timeLine.getOrDefault(start,0) + 1);
        timeLine.put(end, timeLine.getOrDefault(end,0) -1);

        int currentCount = 0;
        boolean added = true;

        for(int count : timeLine.values()){
            currentCount += count;
            if(currentCount > 2){
                added = false;
                break;
            }
        }

        if(! added) {
            if (timeLine.get(start) == 1) {
                timeLine.remove(start);
            } else {
                timeLine.put(start, timeLine.get(start) - 1);
            }

            if (timeLine.get(end) == -1) {
                timeLine.remove(end);
            } else {
                timeLine.put(end, timeLine.get(end) + 1);
            }
        }

        return added;

    }
}
