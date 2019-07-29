package leetcode.leetcode721_740;

/*Implement a MyCalendarThree class to store your events. A new event can always be added.

        Your class will have one method, book(int start, int end).
        Formally, this represents a booking on the half open interval [start, end),
        the range of real numbers x such that start <= x < end.

        A K-booking happens when K events have some non-empty intersection
        (ie., there is some time that is common to all K events.)

        For each call to the method MyCalendar.book,
        return an integer K representing the largest integer such that there exists a K-booking in the calendar.*/

// time complexity O(n^2): for every new event we traverse timeLine in O(n) time

import java.util.TreeMap;

public class MyCalendarThree_732 {

    TreeMap<Integer, Integer> timeLine;
    // start and end points are mapped to number of concurrent events at that time
    // every time an event starts we add 1 at that moment in time
    // every time an event ends we subtract 1 at that moment in time
    // (10,20)  :  10->1   20-> -1
    // start= 10, a new event starts, add 1, end = 20, an events ends, subtract 1
    // max number of events: 1
    // (50,60) : 10->1  20->-1  50-> 1 60-> -1
    // max number of events: 1
    // (10,40): : 10->2  20->-1 40->-1 50-> 1 60-> -1
    // max number of events: 2


    public MyCalendarThree_732() {
        timeLine = new TreeMap<>();

    }

    public int book(int start, int end) {
        timeLine.put(start, timeLine.getOrDefault(start,0)+1);
        timeLine.put(end, timeLine.getOrDefault(end, 0)-1);

        int maxNumberOfEvents = 0;
        int currentCount = 0;

        for(int count : timeLine.values()){
            currentCount += count;
            maxNumberOfEvents = Math.max(maxNumberOfEvents, currentCount);

        }

        return maxNumberOfEvents;

    }
}
