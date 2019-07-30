package leetcode.leetcode1001_1020;

/*You may recall that an array A is a mountain array if and only if:

        A.length >= 3
        There exists some i with 0 < i < A.length - 1 such that:
        A[0] < A[1] < ... A[i-1] < A[i]
        A[i] > A[i+1] > ... > A[A.length - 1]
        Given a mountain array mountainArr,
        return the minimum index such that mountainArr.get(index) == target.
        If such an index doesn't exist, return -1.*/

// assume there is only one peak?

import leetcode.MountainArray;

public class FindInMountainArray_1095 {
    public static int findInMountainArray(int target, MountainArray mountainArr) {
        if(mountainArr.length() < 3){
            return -1;
        }

        // peak exists!
        int peak = helper(mountainArr, 0, mountainArr.length()-1);
        int leftFromPeak = findLeft(mountainArr, 0, peak, target);
        if(leftFromPeak != -1){
            return leftFromPeak;
        }
        else{
            return findRight(mountainArr, peak, mountainArr.length()-1, target);
        }
    }

    private static int helper(MountainArray mountainArray, int start, int end){
        if(start > end){
            return -1;
        }

        int mid = start + (end-start)/2;
        int lookingFor = mountainArray.get(mid);

        if(mid == 0){
            // peak cannot be 0
            return helper(mountainArray, mid+1, end);
        }
        if(mid== mountainArray.length()-1){
            return helper(mountainArray, start, mid-1);
        }


        if(lookingFor > mountainArray.get(mid-1) && lookingFor > mountainArray.get(mid+1)){
            return mid;
        }
        else if(lookingFor <= mountainArray.get(mid-1)){
            // descending part
            return helper(mountainArray, start, mid-1);
        }
        else{
            // ascending part
            return helper(mountainArray, mid+1, end);
        }
    }

    // find left from peak
    // ascending part
    private static int findLeft(MountainArray mountainArray, int start, int end, int target){
        if(start > end){
            return -1;
        }
        int mid = start + (end-start)/2;
        int lookingFor = mountainArray.get(mid);

        if(lookingFor == target){
            return mid;
        }
        else if(lookingFor < target){
            // ascending!
            return findLeft(mountainArray, mid+1, end, target);
        }
        else{
            return findLeft(mountainArray, start, mid-1, target);
        }
    }

    private static int findRight(MountainArray mountainArray, int start, int end, int target){

        if(start > end){
            return -1;
        }

        int mid = start + (end-start)/2;
        int lookingFor = mountainArray.get(mid);
        if(lookingFor == target){
            return mid;
        }
        else if(lookingFor < target){
            // descending!
            return findRight(mountainArray, start, mid-1, target);
        }
        else{
            return findRight(mountainArray, mid+1, end, target);
        }




    }
}
