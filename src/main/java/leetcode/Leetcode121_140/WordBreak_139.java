package leetcode.Leetcode121_140;

/*Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 determine if s can be segmented into a space-separated sequence of one or more dictionary words.

        Note:

        The same word in the dictionary may be reused multiple times in the segmentation.
        You may assume the dictionary does not contain duplicate words.*/

//O(n^3)

import java.util.List;

public class WordBreak_139 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0 || wordDict.isEmpty()){
            return false;
        }

        // dynamic programming
        // canBeBroken[i] = true if s.subString(0,i) can be segmented into a sequence, else false
        boolean[] canBeBroken = new boolean[s.length()+1];
        canBeBroken[0] = true; // is empty string
        for(int i = 1; i<= s.length(); i++){
            for(int j = 0; j <i; j++){
                if(canBeBroken[j] && wordDict.contains(s.substring(j, i))){
                    canBeBroken[i] = true;
                    break;
                }
            }
        }

        return canBeBroken[s.length()];

    }
}
