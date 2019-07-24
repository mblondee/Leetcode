package leetcode.Leetcode741_760;

/*There is a box protected by a password. The password is a sequence of n digits
        where each digit can be one of the first k digits 0, 1, ..., k-1.

        While entering a password, the last n digits entered will automatically
        be matched against the correct password.

        For example, assuming the correct password is "345", if you type "012345",
        the box will open because the correct password matches the suffix of the entered password.

        Return any password of minimum length that is guaranteed to open the box at some point of entering it.*/

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CrackingTheSafe_753 {
    public static String crackSafe(int n, int k) {

        // de Bruijn sequence: B(k,n) each length n string from a k alphabet occurs only once as a substring
        // eg n = k = 2
        // start with string of n zeroes
        // visited has to contain all strings of length n in alphabet k => we want it to contain {00, 01, 10, 11}
        // or we want it to have length k^n
        // visited = {00}, pwd = 00

        // take suffix of length n-1: 0, try to add chars from {0,1}
        // try 00 -> is already in visited
        // try 01 -> is not yet in visited pwd = 001, visited = {00, 01}
            // suffix of length n-1: 1, try to add chars from {0,1}
            // try 10 -> is not yet in visited pwd = 0010, visited = {00, 01,10}
                // suffix of length n-1: 0, try to add chars from {0,1}
                // try 00 -> is already in visited
                // try 01 -> is already in visited
                // backtrack: pwd = 001, visited = {00, 01}
            // try 11 -> is not yet in visited pwd = 0011, visited = {00,01,11}
                // suffix of length n-1: 1, try to add chars from {0,1}
                // try 10 -> is not yet in visited pwd = 00110, visited = {00,01,11,10} finished

        String pwd = String.join("", Collections.nCopies(n, "0"));
        StringBuffer pwdBuffer = new StringBuffer(pwd);

        Set<String> visited = new HashSet<>();
        visited.add(pwd);

        int total = (int) Math.pow(k,n);

        crack(pwdBuffer, visited, total, n,k); // will always be true according to proof of de Bruijn sequence

        return pwdBuffer.toString();

    }

    private static boolean crack(StringBuffer pwdBuffer, Set<String> visited, int total, int n, int k){
        if(total == visited.size()){
            return true;
        }

        String last = pwdBuffer.substring(pwdBuffer.length() - n + 1);
        for(char c = '0'; c < '0' + k; c ++){
            String tryComb = last + c;
            if(! visited.contains(tryComb)){
                visited.add(tryComb);
                pwdBuffer.append(c);
                if(crack(pwdBuffer, visited, total, n, k)){
                    return true;
                }
                visited.remove(tryComb);
                pwdBuffer.deleteCharAt(pwdBuffer.length() -1);
            }
        }

        return false;

    }
}
