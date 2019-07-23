package leetcode.leetcode81_100;

/*Given a 2D binary matrix filled with 0's and 1's,
        find the largest rectangle containing only 1's and return its area.*/

// example
// 0 1 1 0
// 1 1 1 0
// 1 0 0 1
// 1 1 1 1

/*
 only considering row = 0
 0 1 1 0
 max area is 2 (can be computed using histogram's strategy, question 84, heights = [0,1,1,0])

 can we make it bigger by using 1's from row 1?
 0 1 1 0
 1 1 1 0
 histogram: heights = [1,2,2,0] => max area 3
 so overall max area is 3

 can we make it bigger by using 2's from row 1?
 0 1 1 0
 1 1 1 0
 1 0 0 1
 histogram: heights = [2,0,0,1] => max area is 2
 so overall max area is 3

 can we make it bigger by using 2's from row 2?
 0 1 1 0
 1 1 1 0
 1 0 0 1
 1 1 1 1
 histogram: heights = [3,1,1,2] => max area is 4
 so overall max area is 4
*/


public class MaximalRectangle_85 {
    public static int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }
        if(matrix[0].length == 0){
            return 0;
        }


        int overallMaxArea = 0;

        int[] heights = new int[matrix[0].length];
        overallMaxArea = 0;



        for(int row = 0; row < matrix.length; row++){
            // update heights
            for(int column = 0; column < matrix[0].length; column++){
                // if we encounter a 0, height will be 0, otherwise we add it to the height in heights
                if(matrix[row][column] == '0'){
                    heights[column] = 0;
                }
                else{
                    heights[column] += 1;
                }
            }
            // calculate maxArea in current histogram and update overallMaxArea
            overallMaxArea = Math.max(overallMaxArea,
                    maxArea(heights));
        }
        return overallMaxArea;
    }

    private static int maxArea(int[] heights){
        int[] minToLeft = new int[heights.length];
        int[] minToRight = new int[heights.length];


        minToLeft[0] = -1;
        for(int i = 0; i < heights.length; i++){
            int guess = i-1;
            while(guess >=0 && heights[guess] >= heights[i]){
                guess = minToLeft[guess];
            }
            minToLeft[i] = guess;
        }

        minToRight[heights.length-1] = heights.length;
        for(int i = heights.length-2; i >= 0; i--){
            int guess = i+1;
            while(guess < heights.length && heights[guess] >= heights[i]){
                guess = minToRight[guess];
            }
            minToRight[i] = guess;
        }


        int maxArea = 0;
        for(int i = 0; i < heights.length; i++){
            maxArea = Math.max(maxArea,
                    (minToRight[i] - minToLeft[i] - 1)*heights[i]);
        }
        return maxArea;
    }
}
