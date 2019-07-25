package leetcode.leetcode201_220;

/*Given two strings s and t, determine if they are isomorphic.

        Two strings are isomorphic if the characters in s can be replaced to get t.

        All occurrences of a character must be replaced with another character while
        preserving the order of characters. No two characters may map to the same character
        but a character may map to itself.*/

public class IsomorphicStrings_205 {
    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        // for every char in s we add the corresponding char in t
        // this is to check that every char in s is mapped to the corresponding char
        char[] sMapping = new char[256];

        // we also need to check that no two chars c != d from s are mapped to the same char
        char[] tMapping = new char[256];



        for(int i = 0; i < s.length(); i++){
            // not initialized yet
            if(sMapping[s.charAt(i)] == 0 && tMapping[t.charAt(i)] == 0) {
                sMapping[s.charAt(i)] = t.charAt(i);
                tMapping[t.charAt(i)] = s.charAt(i);
            }
            // there is already another char mapped to t.charAt(i)
            else if(sMapping[s.charAt(i)] == 0){
                return false;
            }
            else if (sMapping[s.charAt(i)] != t.charAt(i)){
                return false;
            }
        }

        return true;

    }
}
