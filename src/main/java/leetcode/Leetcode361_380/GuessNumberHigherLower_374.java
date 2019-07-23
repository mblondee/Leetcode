package leetcode.Leetcode361_380;

/*We are playing the Guess Game. The game is as follows:

        I pick a number from 1 to n. You have to guess which number I picked.

        Every time you guess wrong, I'll tell you whether the number is higher or lower.

        You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

        -1 : My number is lower
        1 : My number is higher
        0 : Congrats! You got it!*/

public class GuessNumberHigherLower_374 {

    public int picked;

    public int guessNumber(int n) {
        return binarySearch(1,n);
    }

    private int binarySearch(int start, int end){
        if(end < start){
            return -1;
        }
        int mid = start + (end-start)/2;
        if(guess(mid) == 0){
            return mid;
        }
        else if(guess(mid) == -1){
            return binarySearch(start, mid-1);
        }
        else{
            return binarySearch(mid+1, end);
        }

    }

    private int guess(int guess){
        if(guess < picked){
            return 1;
        }
        else if (picked > guess){
            return -1;
        }
        else{
            return 0;
        }
    }
}
