package leetcode.leetcode841_860;
/*
Let's call an array A a mountain if the following properties hold:

        A.length >= 3
        There exists some 0 < i < A.length - 1 such that
        A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
        Given an array that is definitely a mountain,
        return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].*/


// log(n) space complexity

public class PeakIndexMountainArray_852 {
    public static int peakIndexInMountainArray(int[] A) {
        return helper(A, 0, A.length-1);

    }
    private static int helper(int[] A, int start, int end){


        // should not happen
        if(start > end){
            return -1;
        }

        int mid = start + (end-start)/2;

        // peak cannot be in corner cases (but will not happen?)
        if (mid == 0){
            return helper(A, mid+1, end);
        }

        if(mid == A.length-1){
            return helper(A, start, mid-1);
        }


        if(A[mid] > A[mid-1] && A[mid] > A[mid+1]){
            return mid;
        }
        else if(A[mid-1] <= A[mid]){
            return helper(A,mid+1, end);
        }
        else{
            return helper(A, start, mid-1);
        }


    }
}

