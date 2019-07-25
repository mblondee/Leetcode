package leetcode.leetcode121_140;
/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
        add spaces in s to construct a sentence where each word is a valid dictionary word.
        Return all such possible sentences.

        Note:

        The same word in the dictionary may be reused multiple times in the segmentation.
        You may assume the dictionary does not contain duplicate words.*/

import java.util.ArrayList;
import java.util.List;

public class WordBreakII_140 {


    public static List<String> wordBreak(String s, List<String> wordDict) {

        List<String> result = new ArrayList<>();

        if(s.length() == 0 || wordDict.isEmpty()){
            return result;
        }


        if(! canBreak(s, wordDict)){
            return result;
        }

        helper(result, "", s, wordDict,0);

        return result;

    }

    private static void helper(List<String> result, String solution, String s, List<String> wordDict, int start){
        if(start == s.length()){
            result.add(solution);
            return;
        }

        // find first substring starting from start that is in wordDict
        for(int i = start; i <= s.length(); i++){
            if(wordDict.contains(s.substring(start, i))){
                if(solution == ""){
                    helper(result,s.substring(start, i), s, wordDict, i);
                }
                else{
                    helper(result, solution + " " + s.substring(start, i), s, wordDict, i);
                }
            }
        }

    }




    private static boolean canBreak(String s, List<String> wordDict){
        // dynamic programming
        // canBeBroken[i] = true if s.substring(0,i) can be broken by wordDict
        boolean[] canBeBroken = new boolean[s.length()+1];
        canBeBroken[0] = false;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(j == 0 && wordDict.contains(s.substring(j, i))){
                    canBeBroken[i] = true;
                    break;
                }
                else if(canBeBroken[j] && wordDict.contains(s.substring(j, i))){
                    canBeBroken[i] = true;
                    break;
                }
            }
        }
        return  canBeBroken[s.length()];
    }

/*    public static List<String> wordBreak(String s, List<String> wordDict) {

        if(s.length() == 0 || wordDict.isEmpty()){
            return new ArrayList<>();
        }

        // dynamic programming
        // canBeBroken[i] = set of all sentences that can be made from s.substring(0,i)
        List<String>[] canBeBroken = new ArrayList[s.length()+1];

        canBeBroken[0] = new ArrayList<>(); // is empty string
        for(int i = 1; i<= s.length(); i++){
            List<String> toAdd = new ArrayList<>();
            for(int j = 0; j <i; j++){
                if(j == 0 && wordDict.contains(s.substring(j, i))){
                    toAdd.add(s.substring(j, i));
                }
                else if((! canBeBroken[j].isEmpty()) && wordDict.contains(s.substring(j, i))){
                    for(String str : canBeBroken[j]){
                        toAdd.add(str + " " + s.substring(j, i));
                    }
                }
            }
            canBeBroken[i] = toAdd;
        }

        return canBeBroken[s.length()];
    }*/
}
