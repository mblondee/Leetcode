package leetcode.leetcode961_980;
/*
Given an array of integers A sorted in non-decreasing order,
        return an array of the squares of each number, also in sorted non-decreasing order.*/

// time and space complexity O(n)

public class SquaresSortedArray_977 {
    public static int[] sortedSquares(int[] A) {
//        if(A.length == 0){
//            return A;
//        }

        int[] result = new int[A.length];

        // find first index that is positive and last that is negative
        int i = 0;

        while(i< A.length && A[i] < 0){
            i++;
        }

        int pos = i; // first index positive element
        int neg = i-1; // first index negative element
        // if no negative elements: pos = 0, neg = -1
        // if no positive elements: pos = A.length, neg = A.length-1

        i = 0;
        while(i < result.length){
            if(neg <0 || pos < A.length  && neg >=0 && A[pos] <= - A[neg]){
                result[i] = A[pos]*A[pos];
                i++;
                pos++;
            }
            else if(pos >= A.length || pos < A.length  && neg >=0 && A[pos] > - A[neg]){
                result[i] = A[neg]*A[neg];
                i++;
                neg--;
            }
        }

        return result;



    }
}
