package leetcode.leetcode481_500;

/*Given a binary array, find the maximum number of consecutive 1s in this array.*/

public class MaxConsecutiveOnes_485 {
    public static int findMaxConsecutiveOnes(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int maxWindow = 0;


        int startWindow = 0;
        int endWindow = 0;

        while(startWindow < nums.length){
            // make sure nums[startWindow] =1
            if(nums[startWindow] != 1){
                startWindow++;
                endWindow++;
            }

            // update endWindow
            while(endWindow < nums.length && nums[endWindow] == 1){
                endWindow++;
            }

            maxWindow = Math.max(maxWindow, endWindow-startWindow);
            startWindow = endWindow;

        }
        return maxWindow;


    }
}
