package leetcode;

import leetcode.leetcode281_300.WordPattern_290;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class test_leetcode281_300 {

    @Test
    public void WordPattern(){
        assertTrue(WordPattern_290.wordPattern("abba", "dog cat cat dog"));
        assertFalse(WordPattern_290.wordPattern("abba", "dog cat cat fish"));
        assertFalse(WordPattern_290.wordPattern("aaaa", "dog cat cat dog"));
        assertFalse(WordPattern_290.wordPattern("abba", "dog dog dog dog"));
        assertFalse(WordPattern_290.wordPattern("aaa", "dog dog dog dog"));
        assertFalse(WordPattern_290.wordPattern("aaaa", "dog dog dog"));
        assertFalse(WordPattern_290.wordPattern("", "beef"));

    }
}
