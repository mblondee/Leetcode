package leetcode.leetcode421_440;

/*Given a string s that consists of only uppercase English letters,
        you can perform at most k operations on that string.

        In one operation, you can choose any character of the string and
        change it to any other uppercase English character.

        Find the length of the longest sub-string containing all repeating
        letters you can get after performing the above operations.

        Note:
        Both the string's length and k will not exceed 104.*/


public class LongestRepeatingCharacterReplacement_424 {
    public static int characterReplacement(String s, int k) {

        int startWindow = 0;
        int endWindow = 0; // length of window endWindow-startWindow (endWindow is not included)
        int maxLength = 0;

        int maxFrequencyInWindow = 0; // integer saving the

        int frequencies[] = new int[26]; // frequencies for all capital letters A---Z  x -> index x-'A'

        while(endWindow < s.length()){
            // add new char to the window and update its frequency
            frequencies[s.charAt(endWindow)-'A']++;
            // update maxFrequencyInWindow if necessary
            if(maxFrequencyInWindow < frequencies[s.charAt(endWindow)-'A']){
                maxFrequencyInWindow = frequencies[s.charAt(endWindow) - 'A'];
            }

            // make window greater (endWindow is not included)
            endWindow++;

            // check is window is still valid
            // window is valid when windowLength - maxFrequency <= k
            // if the window is not valid anymore we have to make it smaller by removing startWindow
            // until it is a valid window
            // when startWindow = s.length() - maxLength, it is not necessary to update startWindow because
            // the new window would be smaller than the max already encountered
            while(startWindow < s.length() - maxLength && endWindow - startWindow - maxFrequencyInWindow > k){
                frequencies[s.charAt(startWindow)-'A']--;
                startWindow++;
                // update maxFrequencyInWindow, find max in frequencies
                maxFrequencyInWindow = 0;
                for(int i = 0; i < 26; i++){
                    if(maxFrequencyInWindow < frequencies[i]){
                        maxFrequencyInWindow = frequencies[i];
                    }

                }
            }

            // it is a valid window update maxLength
            // might not be the case if startWindow hasn't been updated
            if(endWindow - startWindow - maxFrequencyInWindow <= k) {
                maxLength = Math.max(maxLength, endWindow - startWindow);
            }
        }
        return maxLength;
    }
}
