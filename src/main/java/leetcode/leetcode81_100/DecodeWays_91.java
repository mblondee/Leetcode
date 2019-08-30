package leetcode.leetcode81_100;

/*A message containing letters from A-Z is being encoded to numbers using the following mapping:

        'A' -> 1
        'B' -> 2
        ...
        'Z' -> 26
        Given a non-empty string containing only digits, determine the total number of ways to decode it.*/


// dynamic programming approach
// decodings[i] = number of decodings of substring of s from index 0 to i not included s.substring(i)

public class DecodeWays_91 {
    public int numDecodings(String s) {
        if(s.length() == 0){
            return 0;
        }

        int[] decodings = new int[s.length()+1];

        // first character -> only one way to decode
        // but it cannot be 0!
        if(s.charAt(0) == '0'){
            return 0;
        }

        decodings[0] = 1; // to able to go back index-2


        for(int i = 0; i < s.length(); i++){
            // there is always one decoding, considering only the char in index i, if it is not equal to zero
            // if it is equal to zero, the char before has to be 1 or 2, otherwise there cannot be any decoding
            if(s.charAt(i) == '0' && s.charAt(i-1) != '1' && s.charAt(i-1)!= '2'){
                return 0;
            }
            // if we encounter a 0 and the char before is 1 or 2
            // then it has to seen together with the char in i-1
            // hence decodings[i] = decodings[i-2] (if i == 1, then
            else if(s.charAt(i) == '0'){
                decodings[i+1] = decodings[i-1];
            }
            else {

                // check if a decoding exists for substring from index i-1 to i included
                if ( i > 0 && (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) <= '6')) {
                    decodings[i + 1] += decodings[i - 1];
                }

                decodings[i + 1] += decodings[i];
            }

        }

        return decodings[s.length()];

    }
}
