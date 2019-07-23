package leetcode;

import leetcode.Leetcode361_380.GuessNumberHigherLowerII_375;
import leetcode.Leetcode361_380.GuessNumberHigherLower_374;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeetCode361_380 {

    @Test
    public void testGuessNumberHigherLower(){
        GuessNumberHigherLower_374 guessGame = new GuessNumberHigherLower_374();
        guessGame.picked = 8;
        assertEquals(8,guessGame.guessNumber(10));
    }

    @Test
    public void testGuessNumberHigherLowerII(){
        GuessNumberHigherLowerII_375.getMoneyAmount(2);

    }
}
