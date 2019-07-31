package leetcode.leetcode1001_1020;

/*Given an array A of 0s and 1s, we may change up to K values from 0 to 1.

        Return the length of the longest (contiguous) subarray that contains only 1s.*/


public class MaxConsecutiveOnesIII_1004 {
    public static int longestOnes(int[] A, int K) {

        // essentially: find longest subarray with at most K zeroes

        int startWindow = 0;
        int endWindow = 0;
        int maxWindow = 0;
        int numberOfZero = 0;

        while(endWindow < A.length){
            // we encounter a new zero and we can still take new zeroes
            if(A[endWindow] == 0 && numberOfZero < K){
                endWindow++;
                numberOfZero++;
            }
            // we encounter a new 0 but we cannot take more zeroes
            // we have a valid window start - end (end not included), so we update max length
            // we update endWindow and numberOfZero which is now > K
            // we try to update start to get numberOfZero < K
            else if(A[endWindow] == 0 && numberOfZero == K){
                maxWindow = Math.max(maxWindow, endWindow-startWindow);
                endWindow++;
                numberOfZero++;

                while(numberOfZero > K ){
                    if(A[startWindow] == 0){
                        numberOfZero--;
                    }
                    startWindow++;

                }
            }
            else if(A[endWindow] == 1){
                endWindow++;
            }


        }


        return Math.max(maxWindow, endWindow-startWindow);

    }
}
