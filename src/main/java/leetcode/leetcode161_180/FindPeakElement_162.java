package leetcode.leetcode161_180;

/*A peak element is an element that is greater than its neighbors.

        Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

        The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

        You may imagine that nums[-1] = nums[n] = -∞.*/

public class FindPeakElement_162 {
    public static int findPeakElement(int[] nums) {
        if(nums.length == 0){
            return -1;
        }
        if(nums.length == 1){
            return 0;
        }
        return helper(nums, 0, nums.length-1);

    }

    private static int helper(int[] nums, int start, int end){

        // should not happen
        if(start > end){
            return -1;
        }

        int mid = start + (end-start)/2;

        // corner cases (array will have at least 2 elements)
        if(mid == 0){
            if(nums[mid] > nums[mid+1]){
                // a peak
                return mid;
            }
            return helper(nums, mid+1, end);
        }
        if(mid == nums.length-1){
            if(nums[mid] > nums[mid-1]){
                // a peak
                return mid;
            }
            return helper(nums, start, mid-1);
        }

        if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
            return mid;
        }
        else if(nums[mid] <= nums[mid-1]){
            // in decreasing part -> peak to the left
            return helper(nums, start, mid-1);
        }
        else{
            // in increasing part -> peak to the right
            return helper(nums, mid+1, end);
        }


    }
}
