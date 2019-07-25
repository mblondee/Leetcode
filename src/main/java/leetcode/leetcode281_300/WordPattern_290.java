package leetcode.leetcode281_300;

/*
Given a pattern and a string str, find if str follows the same pattern.

        Here follow means a full match, such that there is a bijection
        between a letter in pattern and a non-empty word in str.
*/

import java.util.HashMap;
import java.util.Map;

public class WordPattern_290 {
    public static boolean wordPattern(String pattern, String str) {

        // every char corresponds to one str
        // every string corresponds to one char
        Map<Character, String> charToStr = new HashMap<>();
        Map<String, Character> strToChar = new HashMap<>();

        int indexPattern = 0;
        int indexString = 0;

        while(indexString < str.length()){
            // still pattern left?
            if(indexPattern >= pattern.length()){
                return false;
            }

            int i = indexString;
            while(i < str.length() && str.charAt(i) != ' '){
                i++;
            }
            String subString = str.substring(indexString, i);
            if(! charToStr.containsKey(pattern.charAt(indexPattern)) && ! strToChar.containsKey(subString)){
                charToStr.put(pattern.charAt(indexPattern), subString);
                strToChar.put(subString, pattern.charAt(indexPattern));
            }
            else if(! charToStr.containsKey(pattern.charAt(indexPattern))){
                return false;
            }
            else if(! charToStr.get(pattern.charAt(indexPattern)).equals(subString)){
                return false;
            }

            // str.charAt(i) == ' ', take next one for next word
            indexString = i+1;
            indexPattern++;

            // still pattern left but no more string
            if(indexString >= str.length() && indexPattern < pattern.length()){
                return false;
            }

        }

        return true;



    }
}
