package leetcode.Leetcode701_720;

/*We have two special characters. The first character can be represented by one bit 0.
        The second character can be represented by two bits (10 or 11).

        Now given a string represented by several bits.
        Return whether the last character must be a one-bit character or not.
        The given string will always end with a zero.*/

public class OneTwoBitCharacters_717 {
    public static boolean isOneBitCharacter(int[] bits) {
        if(bits.length == 0){
            return false;
        }

/*        if(bits.length == 1){
            return bits[0] == 0;
        }*/

        int next = 0;

        while(next < bits.length) {
            if (bits[next] == 1) {
                next += 2;
            } else if(next == bits.length-1) {
                return true;
            }
            else{
                next++;
            }
        }

        return false;

    }
}
