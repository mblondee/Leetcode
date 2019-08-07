package leetcode.leetcode221_240;

/*Given a sorted integer array without duplicates, return the summary of its ranges.*/

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges_228 {
    public List<String> summaryRanges(int[] nums) {

        List<String> result = new ArrayList<>();

        if(nums.length == 0){
            return result;
        }

        int start = 0;
        int end = 0;

        while(end < nums.length){
            // move end pointer as long as it is in
            // continuous range
            while(end + 1 < nums.length && nums[end+1] == nums[end] + 1){
                end++;
            }

            // last valid continuous range is start -> end, end not included
            if (end == start) {
                result.add(Integer.toString(nums[start]));
            }
            else{
            result.add(nums[start] + "->" + nums[end]);
            }

            start = end + 1;
            end ++;

        }

        return result;

    }
}
