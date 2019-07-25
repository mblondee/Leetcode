package leetcode.leetcode321_340;

/*Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

        Formally the function should:

        Return true if there exists i, j, k
        such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
        Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.*/

public class IncreasingTripletSubsequence_334 {
    public static boolean increasingTriplet(int[] nums) {
        if(nums.length <= 2){
            return false;
        }

        // minOne: smallest first element of all increasing subsequences of length 1
        // minSecond: smallest second element of all increasing subsequences of length 2
        // hence if we find an element in nums that is stricly larger than minSecond we have
        // found an increasing subsequence of length 1

        int minOne = nums[0];
        Integer minTwo = null;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] <= minOne){
                minOne = nums[i];
            }
            else if(minTwo == null){
                minTwo = nums[i];
            }
            // in this case minTwo exists
            else if(nums[i] <= minTwo){
                minTwo = nums[i]; // a smaller second el of subsequence of length 2
            }
            else{
                // nums[i] > minTwo // a third el of a subsequence of length 3
                return true;
            }
        }
        return false;
    }

}
