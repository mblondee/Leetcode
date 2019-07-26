package leetcode.leetcode301_320;

/*You are given an integer array nums and you have to return a new counts array.
        The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].*/

import java.util.ArrayList;
import java.util.List;

public class CountSmallerNumbersAfterSelf_315 {
    public static List<Integer> countSmaller(int[] nums) {

        // we will split the array in two and in each subarray we will count the
        // indices to the right that have a smaller value

        // after that we will sort both sub arrays (we have already calculated the necessary info)
        // we only need to know for an index i in the first half (and vice versa in the second half)
        // how many there are in the second sub array with a smaller value, since the second one is sorted
        // we just need to count until (not included) the first one that is greater

        // array to store the counts for each index
        int[] count = new int[nums.length];
        // instead of actually sorting nums we will use an array to store the indices that would correspond
        // to (parts of) nums sorted eg if nums = [1,3,2]
        // than sorted would be represented by index = [0,2,1]
        // we use this array to loop over the elements in nums (but in sorted order)
        int[] index = new int[nums.length];
        //originally nothing is sorted index[i] = i
         for(int i = 0; i < nums.length; i++){
            index[i] = i;
        }

        helper(nums, index, count, 0, nums.length-1);
        List<Integer> result = new ArrayList<>();
        for(int i : count){
            result.add(i);
        }



        return result;
    }

    private static void helper(int[] nums, int[] index, int[] count, int start, int end){
        if(start >= end){
            return;
        }
        int mid = start + (end-start)/2;
        helper(nums, index, count, start, mid);
        helper(nums, index, count, mid+1, end);

        // cross over: we suppose in index[start ... mid] and index[mid+1 ... end] correspond to nums sorted
        int i = start; // value nums[index[i]]
        int k = mid+1; // value nums[index[k]]
        int countfori = 0; // keep track of how many in second half have a value smaller than in nums[index[i]]
        while(i <= mid && k <=end){
            if(nums[index[k]] < nums[index[i]]){
                k++;
                countfori++;
            }
            // we now know the count for i
            else{
                count[index[i++]] += countfori;
                // we don't have to reset countfori, nor k
                // value for new i is larger than for previous i, so all k's we have encountered have a value smaller than new i
                // but maybe there are more, so we check current k (which was such that value was larger than previous i)
                // and maybe next k's
            }
        }

        // if k <= end but i > mid, then we can stop, we have checked all i
        // however if k>end and i <= mid, then we still need to update the counts for i
        // indeed as before countfori is the extra count for each such i
        while(i <= mid){
            count[index[i++]] += countfori;
        }

        // now "merge" the two subarrays
        merge(index, nums, start, end);

    }

    private static void merge(int[] index, int[] nums, int start, int end){
        int mid = start + (end-start)/2;

        // temp array to hold changed indices
        int[] temp = new int[end-start+1];

        int i = start; // index in left subarray, real value nums[index[i]]
        int j = mid+1; // index in right subarray, real value nums[index[j]]
        int k = 0; // index in temp

        while(k < temp.length){

            // check which is next value in left and right subarray (if none left we put max value)
            int nextValueLeft = i <= mid ? nums[index[i]] : Integer.MAX_VALUE;
            int nextValueRight = j <= end ? nums[index[j]] : Integer.MAX_VALUE;

            // put index that has lower next value
            // i++ if i is picked, j++ if j is picked
            temp[k++] = nextValueLeft <= nextValueRight ? index[i++] : index[j++];

        }

        // copy temp into index
        for(k = 0; k < temp.length;k++){
            index[k+start] = temp[k];
        }
    }
}
