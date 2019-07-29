package leetcode.leetcode741_760;

/*Given a list of sorted characters letters containing only lowercase letters,
        and given a target letter target, find the smallest element in the list that is larger than the given target.

        Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.

        letters has a length in range [2, 10000].
letters consists of lowercase letters, and contains at least 2 unique letters.
target is a lowercase letter.
        */

public class FindSmallestLetterGreaterThanTarget_744 {
    public static char nextGreatestLetter(char[] letters, char target) {
        // there are at least 2 unique chars in letters
        return helper(letters, 0, letters.length -1, target);
    }

    private static char helper(char[] letters, int start, int end, char target){

        if(start > end){
            return letters[0]; // we haven't found it so we return the first char in letters
        }

        int mid = start + (end-start)/2;


        // check if this index is the one we are looking for
        if( (mid == 0 || letters[mid-1] <= target) && letters[mid] > target){
            return letters[mid];
        }

        if(letters[mid] <= target){
            return helper(letters, mid+1, end, target);
        }
        else{
            return helper(letters, start, mid-1, target);
        }

    }
}
