package leetcode.leetcode401_420;

/*
Suppose you have a random list of people standing in a queue.
        Each person is described by a pair of integers (h, k),
        where h is the height of the person and k is the number of people
        in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

        Note:
        The number of people is less than 1,100.*/

// idea: sort from tallest to smallest, then by k number
// one by one insert in index k-value

// arraylist add: could be worst case, finding index + adding


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstruction_406 {
    public static int[][] reconstructQueue(int[][] people) {
        if(people.length <= 1){
            return people;
        }
        List<int[]> queue = new ArrayList<>(people.length);

        Arrays.sort(people, (a,b) -> a[0] == b[0] ? a[1] - b[1] : b[0]-a[0]);
        // a <= b (a comes before b in sorted array) <=> a.compare(b) <= 0
        // a <= b means a[0] is greater than or equals to b[0], b[0] - a[0] >= 0

        // insert one by one in given index
        for(int[] person : people){
            queue.add(person[1], person);
        }


        return queue.toArray(new int[people.length][2]);





    }
}
