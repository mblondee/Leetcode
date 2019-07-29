package leetcode.leetcode341_360;
/*
Given a data stream input of non-negative integers a1, a2, ..., an, ...,
        summarize the numbers seen so far as a list of disjoint intervals.*/

// all operations are in O(log n)

import java.util.Map;
import java.util.TreeMap;

public class SummaryRanges_352 {
    TreeMap<Integer, Integer> valToInterval; // startpoint and endpoint of all intervals

    /** Initialize your data structure here. */
    public SummaryRanges_352() {
        valToInterval = new TreeMap<>();
    }

    public void addNum(int val) {
        if (valToInterval.containsKey(val)) {
            return; // does not have to be added
        }

        Integer floor = valToInterval.floorKey(val);
        Integer ceiling = valToInterval.ceilingKey(val);

        if(floor == null && ceiling == null){
            // valToInterval is empty
            valToInterval.put(val, val);
        }
        else if(ceiling == null){
            // maybe we can add value to interval starting with floor or maybe it is already in there, or we need to add a
            // new interval
            if(val <= valToInterval.get(floor)){
                return; // is already in interval
            }
            else if(val == valToInterval.get(floor) +1){
                // we can add value by making interval larger
                valToInterval.replace(floor, val);
            }
            else{
                valToInterval.put(val, val);
            }
        }
        else if(floor == null){
            if(val == ceiling -1){
                // make interval larger
                valToInterval.put(val, valToInterval.get(ceiling));
                valToInterval.remove(ceiling);
            }
            else{
                valToInterval.put(val, val);
            }
        }
        else{
            // there is a floor and a ceiling
            if(val <= valToInterval.get(floor)){
                return; // is already in some interval
            }
            else if(val == valToInterval.get(floor) + 1 && val != ceiling-1){
                // make interval larger + check if it has to be merged
                valToInterval.replace(floor, val);
            }
            else if (val == valToInterval.get(floor) + 1 && val == ceiling-1){
                valToInterval.replace(floor, valToInterval.get(ceiling));
                valToInterval.remove(ceiling);
            }
            else if(val == ceiling -1){
                valToInterval.put(val, valToInterval.get(ceiling));
                valToInterval.remove(ceiling);
            }
            else{
                valToInterval.put(val, val);
            }
        }


    }

    public int[][] getIntervals() {
        int[][] intervals = new int[valToInterval.size()][2];
        int i = 0;
        for(Map.Entry<Integer, Integer> interval : valToInterval.entrySet()){
            intervals[i][0] = interval.getKey();
            intervals[i][1] = interval.getValue();
            i++;
        }
        return intervals;


    }
}
