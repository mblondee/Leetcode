package leetcode.leetcode481_500;


/*Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].

        You need to return the number of important reverse pairs in the given array.*/

// time complexity: O(n log n)
// - times we have to divide is O(log n)
// - for every divide:
// - we check crossing but this is O(n) (every i is accessed once)
// - we sort but this is O(n) (every i is accessed once)
// space complexity: O(n)



public class ReversePairs_493 {
    public static int reversePairs(int[] nums) {

        // index represents the (partially) sorted nums
        // eg nums = [5,1,2,3], then both subarrays sorted index = [1,0,2,3]
        int[] index = new int[nums.length];
        for(int i = 0; i < index.length; i++){
            index[i] = i;
        }
        return helper(nums, 0, nums.length-1, index);
    }

    private static int helper(int[] nums, int start, int end, int[] index){
        if(start >= end){
            return 0;
        }

        int mid = start + (end-start)/2;
        int count = helper(nums, start, mid, index) + helper(nums, mid+1, end, index);

        // add to count the cross over pairs
        // we start with i in first half and count the in second half until the next is larger
        int i = start; // real value is nums[index[i]]
        int j = mid+1; // real value is nums[index[j]]
        int countfori = 0;
        while(i <= mid && j <=end){
            if(nums[index[i]] > (long) 2*nums[index[j]]){
                countfori++;
                j++;
            }
            else{
                // next is larger we go to next i
                // we don't have to update countfori because next i will be larger than previous one, so
                // all of the previous pairs with i are also pairs but i replaced with new i
                count += countfori;
                i++;
            }
        }

        // if j<=end and i>mid, there are no more i's to check
        // if j > end and i <= mid, then as before for every i, countfori has to be added to count
        while(i <= mid){
            count += countfori;
            i++;
        }

        // "sort" both subarrays
        merge(nums, start, end, index);

        return count;

    }

    private static void merge(int[] nums, int start, int end, int[] index){
        int[] temp = new int[end-start+1];
        int mid = start + (end-start)/2;

        int i = start; // first half, real value nums[index[i]]
        int j = mid +1; // second half, real value nums[index[j]]

        for(int k = 0; k < temp.length; k++) {

            if (i <= mid && j <= end) {
                int nextValueLeft = nums[index[i]];
                int nextValueRight = nums[index[j]];
                if (nextValueLeft < nextValueRight) {
                    temp[k] = index[i++];
                } else {
                    temp[k] = index[j++];
                }
            }
            else if (i <= mid) {
                temp[k] = index[i++];
            } else {
                temp[k] = index[j++];
            }
        }
/*            int nextValueLeft = i <= mid ? nums[index[i]] : Integer.MAX_VALUE;
            int nextValueRight = j <= end ? nums[index[j]] : Integer.MAX_VALUE;

            temp[k] = nextValueLeft < nextValueRight ? index[i++] : index[j++];*/


        // copy temp into index
        for(int k = 0; k <temp.length; k++){
            index[k+start] = temp[k];
        }

    }
}
