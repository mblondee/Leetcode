package leetcode;

import leetcode.leetcode421_440.LongestRepeatingCharacterReplacement_424;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class test_leetcode421_440 {

    @Test
    public void testLongestRepeatingCharacterReplacement(){
        assertEquals(0, LongestRepeatingCharacterReplacement_424.characterReplacement("", 2));
        assertEquals(1, LongestRepeatingCharacterReplacement_424.characterReplacement("A", 2));
        assertEquals(4, LongestRepeatingCharacterReplacement_424.characterReplacement("ABAB", 2));
        assertEquals(4, LongestRepeatingCharacterReplacement_424.characterReplacement("AABABBA", 1));
    }
}
