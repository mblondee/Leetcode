package leetcode;

import leetcode.leetcode741_760.CrackingTheSafe_753;
import leetcode.leetcode741_760.FindSmallestLetterGreaterThanTarget_744;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class test_leetcode741_760 {

    @Test
    public void testCrackingTheSafe(){
        assertEquals("00110", CrackingTheSafe_753.crackSafe(2,2));
    }

    @Test
    public void testFindSmallestLetterGreaterThanTarget(){
        assertEquals('c', FindSmallestLetterGreaterThanTarget_744.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));
        assertEquals('f', FindSmallestLetterGreaterThanTarget_744.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));
        assertEquals('f', FindSmallestLetterGreaterThanTarget_744.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd'));
        assertEquals('j', FindSmallestLetterGreaterThanTarget_744.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j'));

        assertEquals('k',
                FindSmallestLetterGreaterThanTarget_744.nextGreatestLetter(new char[]{'c', 'f', 'k', 'k', 'l', 'm'}, 'i'));
    }
}
