package leetcode.leetcode561_580;

/*In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into
        a new one with different size but keep its original data.

        You're given a matrix represented by a two-dimensional array, and two positive integers
        r and c representing the row number and column number of the wanted reshaped matrix, respectively.

        The reshaped matrix need to be filled with all the elements of the original matrix
        in the same row-traversing order as they were.

        If the 'reshape' operation with given parameters is possible and legal,
        output the new reshaped matrix; Otherwise, output the original matrix.*/

public class ReshapeMatrix_566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {

        if(nums.length == 0){
            return nums;
        }

        // cannot be reshaped
        if(r*c != nums.length * nums[0].length){
            return nums;
        }
        int[][] newnums = new int[r][c];

        int originalRow = 0;
        int originalColumn = 0;

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c ; j++){
                newnums[i][j] = nums[originalRow][originalColumn];

                // update row and column in original array

                // row remains the same as long as we can go one more column to the right
                originalRow = originalColumn < nums[0].length-1 ? originalRow : originalRow + 1;
                originalColumn = originalColumn < nums[0].length -1 ? originalColumn + 1: 0;
            }
        }

        return newnums;

    }
}
