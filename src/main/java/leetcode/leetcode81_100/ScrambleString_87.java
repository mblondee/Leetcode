package leetcode.leetcode81_100;

/*Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

        Below is one possible representation of s1 = "great":

        To scramble the string, we may choose any non-leaf node and swap its two children.

        For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
        We say that "rgeat" is a scrambled string of "great".

        Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".*/

// O(n^4)

public class ScrambleString_87 {
    public static boolean isScramble(String s1, String s2) {
        if(s1.length() == 0){
            return true;
        }

        // dynamic programming
        // isScramble[i][j][k] = true if s1(i, ..., i+k) is a scramble of s2(j, ..., j+k)
        // 0<= i,j, < len(s1) ,  0 <= k <= len(s1)

        // isScramble[i][j][k] = true <=> exists 0 < q < k such that
        // s1(i, ..., i+q) scramble of s2(j,..., j+q) and s1(i+q, .. , i+k) scramble of s2(j+q, ..., j+k)
        // or (switched)
        // s1(i, ..., i+q) scramble of s2(j+q, ..., j+k) and s1(i+q, .. , i+k) scramble of s2(j,..., j+q)
        // isScramble[i][j][q] and isScramble[i+q][j+q][k-q]
        // or
        // isScramble[i][j+k-q][q] and isScramble[i+q][j][k-q]

        boolean[][][] isScramble = new boolean[s1.length()][s1.length()][s1.length()+1];
        // base case k=0: empty strings (ignore)
        // base case k=1: substrings of length 1
        for(int k = 1; k <= s1.length(); k++){
            for(int i = 0; i + k <= s1.length(); i++){
                for(int j = 0; j + k <= s2.length(); j++){
                    if(k==1){
                        isScramble[i][j][k] = s1.charAt(i) == s2.charAt(j);
                    }
                    else{
                        // add extra condition to avoid checking same case != times
                        for(int q = 1; q < k && !isScramble[i][j][k]; q++){
                            isScramble[i][j][k] = (isScramble[i][j][q] && isScramble[i+q][j+q][k-q])
                            || (isScramble[i][j+k-q][q] && isScramble[i+q][j][k-q]);

                        }
                    }
                }
            }
        }

        return isScramble[0][0][s1.length()];

    }
}
