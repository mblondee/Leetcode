package leetcode.leetcode821_840;
/*
Given a binary matrix A, we want to flip the image horizontally,
        then invert it, and return the resulting image.

        To flip an image horizontally means that each row of the image is reversed.
        For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].

        To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
        For example, inverting [0, 1, 1] results in [1, 0, 0].*/

public class FlippingAnImage_832 {

    public static int[][] flipAndInvertImage(int[][] A) {
        int rows = A.length;
        if(rows == 0){
            return A;
        }
        int columns = A[0].length;

        // to reverse a row: (suppose there are n columns)
        // swap element column in column i with element in column n-1-i
        // we have to do this for all  i <= n-1-i <=> 2i <= n -1
        // we will do the flipping at the same time
        // suppose we are swapping integers a and b
        // if a!=b: then we don't have to do anything, eg a = 0 and b = 1, 01 ->(swapping) 10 ->(reversing) 01
        // if a==b: then it is not necessary to swap, we just change both to the reversed bit

        for(int row = 0; row < rows; row++){
            for(int i  = 0; 2*i <= columns-1; i++){
                if(A[row][i] == A[row][columns-1-i]){
                    // 1 xor 1 = 0
                    // 0 xor 1 = 1
                    A[row][i] ^= 1;
                    // only change the other column if it is really different index
                    if(i != columns-1-i) {
                        A[row][columns - 1 - i] ^= 1;
                    }
                }
            }
        }

        return A;


    }
}
