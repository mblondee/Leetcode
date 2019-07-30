package leetcode.leetcode481_500;

/*You are given a list of non-negative integers, a1, a2, ..., an, and a target, S.
        Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

        Find out how many ways to assign symbols to make sum of integers equal to target S.*/

// O(2^n)

public class TargetSum_494 {

    public static int findTargetSumWays(int[] nums, int S) {
        if(nums.length == 0){
            return 0;
        }


        return helper(nums, 0,0, S);

    }

    private static int helper(int[] nums, int start, int total, int S){
        if(start == nums.length){
            if(total == S){
                return 1;
            }
            return 0;
        }


        return helper(nums, start+1, total + nums[start], S) +
                helper(nums, start+1, total - nums[start], S);
    }

}
