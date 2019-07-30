package leetcode.leetcode1041_1060;
/*
Given a string S, consider all duplicated substrings: (contiguous) substrings of S that occur 2 or more times.
        (The occurrences may overlap.)

        Return any duplicated substring that has the longest possible length.
        (If S does not have a duplicated substring, the answer is "".)*/


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestDuplicateString_1044 {

    private static int mod = 19260817;

    public static String longestDupSubstring(String S) {
        if(S.length() == 0){
            return "";
        }

        int currentLength = 0;
        int currentStart = -1;

        int low = 0;
        int high = S.length()-1;

        while(low <= high){
            int mid = low + (high-low)/2;
            int start = check(S, mid); // search for duplicate substrings in s
            if(start == -1){
                // impossible to have duplicate substrings of larger length
                high = mid -1;
            }
            else{
                currentLength = mid;
                currentStart = start;
                // maybe there are substrings of larger length
                low = mid+1;
            }
        }

        if(currentStart == -1){
            return "";
        }
        return S.substring(currentStart, currentStart+currentLength);


    }


    // are there two equal substrings of length
    // Robin Karp hash function: every substring is a number in some base (usually the size of the character set)
    private static int check(String s, int length){

        int radix = 256;


        // (without mod) we have hash: bR + a, then we need to subtract bR^1 (length = 2)
        long RL = 1;
        for(int i = 1; i <= length-1; i++){
            RL = (radix*RL) % mod;
        }
/*        for(int i = 1; i <= length-1; i++){
            RL = (radix*RL);
        }*/

        long hash = hash(s, length, radix);

        Map<Long, Set<Integer>> seen = new HashMap<>();

        // add hash of first substring
        seen.put(hash, new HashSet<>());
        seen.get(hash).add(0);


        // rolling hash
        for(int i = 1; i <= s.length() - length; i++) {
            // remove old value
            hash = ((hash - RL*s.charAt(i-1) ) % mod + mod) % mod;
            // add new value
            hash = (hash*radix + s.charAt(i+length-1)) % mod;

            // we have seen this hash before
            if (seen.containsKey(hash)) {
                // double check if the substrings are equal
                for (int index : seen.get(hash)) {
                    if (s.substring(index, index + length).equals(s.substring(i, i + length))) {
                        return index;
                    }
                }
                seen.get(hash).add(i);
            } else {
                seen.put(hash, new HashSet<>());
                seen.get(hash).add(i);
            }
        }

        return -1;

    }

    private static long hash(String key, int length, int R){
        long h = 0;
        for(int j = 0; j < length; j++){
            h = ((R*h)%mod + key.charAt(j)) % mod;
        }
        return h;
    }
}
