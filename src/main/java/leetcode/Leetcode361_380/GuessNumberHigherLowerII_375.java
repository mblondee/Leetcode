package leetcode.Leetcode361_380;

/*We are playing the Guess Game. The game is as follows:

        I pick a number from 1 to n. You have to guess which number I picked.

        Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.

        However, when you guess a particular number x, and you guess wrong, you pay $x.
        You win the game when you guess the number I picked.*/

public class GuessNumberHigherLowerII_375 {


    public static int getMoneyAmount(int n) {

        int[][] minCost = new int[n+1][n+1];  // minCost[i][j] minCost if guess in the interval [i,j] and you know
        // correct is in that interval

/*        for(int i = 1; i<=n; i++){
            minCost[i][i] = 0; // you have only one option -> is the correct option
        }*/

        // minCost[i][j]: you make a guess k which is incorrect, then you will be told where to go
        // we will be told to go where so we pick the minimum of both minCost[i][k-1] and minCost[k+1][j]
        // note: make sure k is not a border case

        // loop over lengths: because larger intervals depend on smaller intervals

        for(int length = 2; length <= n; length++){
            // 1 2 3 4 5 6, n = 6, length = 2
            // left can be at most 5, 5+2 = 7 = 6+1
            for(int left = 1; left + length <= n+1; left++){
                // current interval is [left, left+length-1]
                minCost[left][left+length-1] = Integer.MAX_VALUE;

                // we know the correct answer is between left and left+length-1
                // we look at the worst case
                int currentCost = 0; // this the cost we will try to maximize

                for(int guess = left; guess <= left + length -1; guess++){
                    if(guess == left){
                        // we have to go right
                        currentCost = Math.max(currentCost, guess + minCost[left+1][left+length-1]);
                    }
                    else if(guess == left + length -1){
                        // we have to go left
                        currentCost = Math.max(currentCost, guess + minCost[left-1][left+length-1]);
                    }
                    else{
                        currentCost = guess + Math.max(
                                minCost[left][guess-1],
                                minCost[guess+1][left+length-1]
                        );
                    }
                    minCost[left][left+length-1] = Math.min(currentCost, minCost[left][left+length-1]);
                }
            }
        }

        return minCost[1][n];



    }


}
