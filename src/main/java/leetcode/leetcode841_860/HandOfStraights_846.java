package leetcode.leetcode841_860;

/*Alice has a hand of cards, given as an array of integers.

        Now she wants to rearrange the cards into groups so that each group is size W,
        and consists of W consecutive cards.

        Return true if and only if she can.*/

import java.util.TreeMap;

public class HandOfStraights_846 {
    public static boolean isNStraightHand(int[] hand, int W) {
        if(W <= 0 || W > hand.length || hand.length % W != 0){
            return false;
        }

        if(hand.length == 0){
            return false;
        }

        // for every int we count the frequencies in the hand
        // we use tree map to have the keys ordered
        // containsKey, get, put remove are log(n) operations
        TreeMap<Integer, Integer> frequencies = new TreeMap<>();

        // construct frequencies
        for(int card : hand){
            if(frequencies.containsKey(card)){
                frequencies.put(card, frequencies.get(card)+1);
            }
            else{
                frequencies.put(card,1);
            }
        }


        // key observation: the smallest integer in keys must be start of some group
        // otherwise it cannot be in any group
        // so if we cannot construct a group starting with that key, the hand cannot be rearranged
        // after finding a group, there is another smallest key, this must also be the start of group
        // and so on

        // starting there is at least one key in frequencies
        // we get the smallest key and decrease the count or remove if there are none left
        int current = frequencies.firstKey();
        if(frequencies.get(current) == 1){
            frequencies.remove(current);
        }
        else{
            frequencies.put(current, frequencies.get(current) -1);
        }

        // in current group there is one element
        int count = 1;

        while(count <= W){
            if(count == W && ! frequencies.isEmpty()){
                // we have found enough for this group and there are still elements in frequencies
                // then we reset count and take new smallest element
                current = frequencies.firstKey();
                if(frequencies.get(current) == 1){
                    frequencies.remove(current);
                }
                else{
                    frequencies.put(current, frequencies.get(current) -1);
                }
                count = 1;
            }
            else if(count == W && frequencies.isEmpty()){
                // the group is complete and there are no more elements in map
                return true;
            }
            else if(count < W && frequencies.isEmpty()){
                // the group is not complete and there are no more elements in map
                return false;
            }
            // frequencies is not empty -> we have to check that current+1 is in map
            // if it is not the group cannot be completed
            else if(! frequencies.containsKey(current+1)){
                return false;
            }
            else{
                //update current, count and update map
                current++;
                count++;
                if(frequencies.get(current) == 1){
                    frequencies.remove(current);
                }
                else{
                    frequencies.put(current, frequencies.get(current) -1);
                }
            }

        }





        return false; // will never be reached
    }
}
