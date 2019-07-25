package leetcode.Leetcode201_220;

/*Given an array of integers, find if the array contains any duplicates.

        Your function should return true if any value appears at least
        twice in the array, and it should return false if every element is distinct.*/

import java.util.Arrays;

public class ContainsDuplicate_217 {
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(i+1 < nums.length && nums[i+1] == nums[i]){
                return true;
            }
        }

        return false;

    }
}
