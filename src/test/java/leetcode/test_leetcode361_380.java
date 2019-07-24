package leetcode;

import leetcode.Leetcode361_380.GuessNumberHigherLowerII_375;
import leetcode.Leetcode361_380.GuessNumberHigherLower_374;
import leetcode.Leetcode361_380.RandomizedSet_380;
import org.junit.Test;

import static org.junit.Assert.*;

public class test_leetcode361_380 {

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

    @Test
    public void testRandomizedSet(){
        RandomizedSet_380 set = new RandomizedSet_380();
        assertFalse(set.remove(0));
        assertFalse(set.remove(0));
        assertTrue(set.insert(0));
        assertEquals(0, set.getRandom());
        assertTrue(set.remove(0));
        assertFalse(set.remove(0));

        RandomizedSet_380 set1 = new RandomizedSet_380();
        set1.insert(1);
        set1.remove(2);
        set1.insert(2);
        set1.remove(1);
        set1.insert(2);
        assertEquals(2, set1.getRandom());
    }
}
