package leetcode.leetcode981_1000;

/*Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

        Return the intersection of these two interval lists.

        (Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.
        The intersection of two closed intervals is a set of real numbers that is either empty,
        or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)*/

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections_986 {
    public static int[][] intervalIntersection(int[][] A, int[][] B) {
        int indexA = 0;
        int indexB = 0;

        List<int[]> intersection = new ArrayList<>();

        while(indexA < A.length && indexB < B.length){
            // which one of A[indexA] and B[indexB] has smallest endpoint?
            // suppose it is A[indexA], then A[indexA] can only intersect with B[indexB]
            if(A[indexA][1] <= B[indexB][1]){
                // do A[indexA] and B[indexB] intersect?
                if(B[indexB][0] <= A[indexA][1]){
                    int start = Math.max(B[indexB][0], A[indexA][0]);
                    int end = Math.min(A[indexA][1], B[indexB][1]);
                    intersection.add(new int[]{start, end});
                }
                // discard indexA
                indexA++;

            }
            else{ // A[indexA][1] > B[indexB][1]
                // B[indexB] can at most intersect with A[indexA]
                // do A[indexA] and B[indexB] intersect?
                if(A[indexA][0] <= B[indexB][1]){
                    int start = Math.max(B[indexB][0], A[indexA][0]);
                    int end = Math.min(A[indexA][1], B[indexB][1]);
                    intersection.add(new int[]{start, end});
                }
                indexB++;
            }
        }

        return intersection.toArray(new int[intersection.size()][2]);

    }
}
