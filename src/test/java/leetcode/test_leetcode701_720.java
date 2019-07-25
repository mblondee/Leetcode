package leetcode;

import leetcode.leetcode701_720.OneTwoBitCharacters_717;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class test_leetcode701_720 {

    @Test
    public void testOneTwoBitCharacters(){
        assertTrue(OneTwoBitCharacters_717.isOneBitCharacter(new int[]{1,0,0}));
        assertFalse(OneTwoBitCharacters_717.isOneBitCharacter(new int[]{1,1,1,0}));
        assertFalse(OneTwoBitCharacters_717.isOneBitCharacter(new int[]{1,0}));
        assertTrue(OneTwoBitCharacters_717.isOneBitCharacter(new int[]{0}));
        assertTrue(OneTwoBitCharacters_717.isOneBitCharacter(new int[]{0,0,0}));
    }
}
