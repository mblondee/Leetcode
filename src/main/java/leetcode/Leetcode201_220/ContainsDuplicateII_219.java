package leetcode.Leetcode201_220;

/*Given an array of integers and an integer k, find out whether there are two distinct indices
        i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.*/


import java.util.HashMap;

public class ContainsDuplicateII_219 {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        // for every value we largest index we have seen so far
        HashMap<Integer, Integer> valToIndex = new HashMap<>();


        for(int i = 0; i < nums.length; i++){
            // have we seen value nums[i] already? and is difference between indices at most k?
            if(valToIndex.containsKey(nums[i]) && i - valToIndex.get(nums[i]) <= k){
                return true;
            }

            // update last seen index
            valToIndex.put(nums[i], i);

        }

        return false;


    }
}
