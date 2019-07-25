package leetcode.leetcode321_340;

/*Given an integer array nums,return the number of range sums that lie in[lower,upper]inclusive.
        Range sum S(i,j)is defined as the sum of the elements in nums between indices i and j(i ≤ j),inclusive.*/


public class CountOfRangeSum_327 {
    public static int countRangeSum(int[] nums, int lower, int upper) {
        if(lower>upper || nums.length ==0){
            return 0;
        }

        // array with cumulative sums
        long[] cumSum = new long[nums.length];

        cumSum[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            cumSum[i] = cumSum[i-1] + nums[i];
        }

        return helper(nums,0, nums.length-1, lower, upper, cumSum);

    }

    private static int helper(int[] nums, int start, int end, int lower, int upper, long[] cumSum){
        if(lower > upper){
            return 0;
        }
        else if(start == end){
            if(nums[start] <= upper && nums[start] >= lower){
                return 1;
            }
            else{
                return 0;
            }
        }

        int mid = start + (end-start)/2;
        int count = helper(nums, start, mid, lower, upper, cumSum) +
                helper(nums, mid+1, end, lower, upper, cumSum);

        // maybe there are subarrays containing mid, overlapping left and right
        for(int i = start; i <= mid; i++){
            for(int j = mid+1; j <= end; j++){
                // compute sum subarray i to j
                // cumSum[i] : sum nums[0] to nums[i]
                // cumSum[j] : sum nums[0] to nums[j]
                // cumSum[j] - cumSum[i]: sum nums[i+1] to nums[j]
                // have to add nums[i] to get correct sum
                long temp = cumSum[j] - cumSum[i] + nums[i];
                if(temp <= upper && temp >= lower){
                    count += 1;
                }
            }
        }
        return count;

    }
}
