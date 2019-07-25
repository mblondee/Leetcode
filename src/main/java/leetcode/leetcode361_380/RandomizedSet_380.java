package leetcode.leetcode361_380;

/*Design a data structure that supports all following operations in average O(1) time.

        insert(val): Inserts an item val to the set if not already present.
        remove(val): Removes an item val from the set if present.
        getRandom: Returns a random element from current set of elements.
        Each element must have the same probability of being returned.*/

import java.util.*;

public class RandomizedSet_380 {
    private Map<Integer, Integer> valToIndex; // map each value to its index in the arraylast
    private List<Integer> elementsList; // list for storing the actual elements
    private static Random rand = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet_380() {
        elementsList = new ArrayList<>();
        valToIndex = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(! valToIndex.containsKey(val)){
            // add element to list
            elementsList.add(val);
            // add val + index to map
            valToIndex.put(val, elementsList.size()-1);
            return true;
        }

        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(valToIndex.containsKey(val)){
            // remove value from valToIndex and get index
            int index = valToIndex.remove(val);


            // now update elementsList
            // remove last element, if this is val we can stop, if not we put it in index
            int lastVal = elementsList.remove(elementsList.size() - 1);

            if(lastVal != val){
                // add to elementsList
                elementsList.remove(index);
                elementsList.add(index, lastVal);
                // update index
                valToIndex.put(lastVal, index);
            }

            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return elementsList.get(rand.nextInt(elementsList.size()));
    }

}
