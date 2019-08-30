package leetcode.leetcode81_100;

/*Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

        Note: The solution set must not contain duplicate subsets.*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0){
            return result;
        }
        Arrays.sort(nums);
        helper(result, new ArrayList<>(), 0, nums);
        return result;

    }

    // helper is adding the current temp list to result
    // and tries to add an element
    // if it has been added before (in the same call to helper) it will not be added
    // first call of helper will add empty set and make all subsets of length 1
    // each time helper is called it will make all subsets with length of previous + 1
    private void helper(List<List<Integer>> result, List<Integer> temp, int current, int[] nums){
        result.add(new ArrayList<>(temp));

        for(int i = current; i < nums.length; i++){
            // always add the first one
            // if it is not the first one don't add if it is has already been added
            // i.e. same as previous
            if(i != current && nums[i] == nums[i-1]){
                continue;
            }
            temp.add(nums[i]);
            helper(result, temp, i+1, nums);
            temp.remove(temp.size()-1);
        }

    }
}
