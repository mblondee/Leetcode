package leetcode.leetcode81_100;

/*Given n non-negative integers representing
        the histogram's bar height where the width of each bar is 1,
        find the area of largest rectangle in the histogram.*/

// for every bar i, the largest rectangle that includes bar i entirely is as follows:
// 1) find index l: the first index to the left (starting from i) such that heights[l] < heights[i]
// -> the rectangle starts from index l+1
// 2) find index r: the first index to the right (starting from i) such that heights[r] < heights[i]
// -> the rectangle ends at index r-1
// base: (r-1) - (l+1) + 1 = r-1-l-1+1 = r-l-1


// how to efficiently calculate these left and right indices?
// dynamic programming: eg smallestIndexToTheLeft[i]
// guess = i-1, if heights[guess] < heights[i] -> stop because index found
// else: we try with new-guess = smallestIndexToTheLeft[guess], we don't need to try guess-1, guess-2, ...
// we can just go the first one that is strictly smaller than heights[guess]


public class LargestRectangleHistogram_84 {
    public static int largestRectangleArea(int[] heights) {

        int[] smallestIndexToTheLeft = new int[heights.length];
        smallestIndexToTheLeft[0] = -1; // the are no indices to the left
        for(int i = 1; i < heights.length; i++){
            int guess = i-1;
            while(guess >= 0 && heights[guess] >= heights[i]){
                guess = smallestIndexToTheLeft[guess];
            }
            smallestIndexToTheLeft[i] = guess;
        }



        return 0;

    }
}
