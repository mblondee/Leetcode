package leetcode;

import leetcode.Leetcode121_140.WordBreakII_140;
import leetcode.Leetcode121_140.WordBreak_139;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class test_leetcode212_240 {

    @Test
    public void testWordBreak(){
        List<String> dict = new ArrayList<>();
        dict.add("leet");
        dict.add("code");
        assertTrue(WordBreak_139.wordBreak("leetcode", dict));
    }

    @Test
    public void testWordBreakII(){
        List<String> dict = new ArrayList<>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");
        List<String> result = new ArrayList<>();
        result.add("cat sand dog");
        result.add("cats and dog");
        List<String> ans = WordBreakII_140.wordBreak("catsanddog", dict);
        assertEquals(result.size(), ans.size());
        for(int i = 0; i < ans.size(); i++){
            assertEquals(result.get(i), ans.get(i));
        }

        List<String> ans2 = WordBreakII_140.wordBreak("catsandog", dict);
        assertEquals(0, ans2.size());

        List<String> dict1 = new ArrayList<>();
        dict1.add("apple");
        dict1.add("pen");
        dict1.add("applepen");
        dict1.add("pine");
        dict1.add("pineapple");
        List<String> ans1 = WordBreakII_140.wordBreak("pineapplepenapple", dict1);
        assertEquals(3, ans1.size());
    }
}
