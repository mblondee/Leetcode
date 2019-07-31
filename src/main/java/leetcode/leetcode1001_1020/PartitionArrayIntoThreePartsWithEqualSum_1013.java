package leetcode.leetcode1001_1020;


/*Given an array A of integers, return true if and only if
        we can partition the array into three non-empty parts with equal sums.

        Formally, we can partition the array if we can find indexes i+1 < j
with (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1])*/

public class PartitionArrayIntoThreePartsWithEqualSum_1013 {
    public static boolean canThreePartsEqualSum(int[] A) {
        // three non empty parts with equal sums should all have sum(A)/3
        // compute total sum
        int sum = 0;
        for(int i = 0; i < A.length; i++){
            sum+=A[i];
        }

        // check if sum can be divided by 3
        if(sum%3 != 0){
            return false;
        }
        int partSum = sum/3; // sum that has to be obtained 3 times
        int current = 0; // current sum while going through the different parts
        int count = 0; // count number of parts

        int i = 0;

        while(i < A.length){
            current += A[i];
            if(current == partSum){
                current = 0;
                count++;
            }
            i++;
        }

        // if count < 3 it means we haven't seen all three equal parts
        // if count == 3 we have and there cannot be indices we haven't counted because we have seen 3*(sum/3)=sum, i.e. all indices

        return count == 3;


    }
}
