package leetcode;

import leetcode.leetcode281_300.ExpressionAddOperators_282;
import leetcode.leetcode281_300.WordPattern_290;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

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

    @Test
    public void testExpressionAddOperators(){
        List<String> result1 = ExpressionAddOperators_282.addOperators("123", 6);
        assertEquals(2, result1.size());
        List<String> result2 = ExpressionAddOperators_282.addOperators("105", 5);
        assertEquals(2, result2.size());
    }
}
