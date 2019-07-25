package leetcode.Leetcode381_400;

/*Design a data structure that supports all following operations in average O(1) time.

        Note: Duplicate elements are allowed.
        insert(val): Inserts an item val to the collection.
        remove(val): Removes an item val from the collection if present.
        getRandom: Returns a random element from current collection of elements.
        The probability of each element being returned is linearly related to the number
        of same value the collection contains.*/

// insert: all operations are O(1) on average (n inserts are O(n))
// remove: all operations are O(1) on average (n inserts are O(n))

import java.util.*;

public class RandomizedCollection_381 {

    private static Random rand = new Random();
    private List<Integer> elementsList; // list containing the elements
    private Map<Integer, Set<Integer>> valueToIndices; // map from value to a set of corresponding values

    /** Initialize your data structure here. */
    public RandomizedCollection_381() {
        elementsList = new ArrayList<>();
        valueToIndices = new HashMap<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        elementsList.add(val); // add is amortized constant time

        if( !valueToIndices.containsKey(val)){
            // is not yet a key -> initialize a new set
            valueToIndices.put(val, new HashSet<>());
            valueToIndices.get(val).add(elementsList.size()-1);
            return true;
        }

        // if already a key, then add new index to set of indices
        valueToIndices.get(val).add(elementsList.size()-1);
        return false;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(! valueToIndices.containsKey(val)){
            return false;
        }
        else{
            // remove last element and put in spot of val to remove
            int lastIndex = elementsList.size()-1;
            int lastElement = elementsList.remove(lastIndex);
            if(lastElement == val){
                // no swap has to be made
                // only remove from valueToIndices
                valueToIndices.get(val).remove(lastIndex);
                if(valueToIndices.get(val).size() == 0){
                    valueToIndices.remove(val);
                }
            }
            else{
                // a swap has to be made, we choose next index in set
                int index = valueToIndices.get(val).iterator().next();

                elementsList.remove(index);
                elementsList.add(index, lastElement);


                // update valueToIndices
                // remove index
                valueToIndices.get(val).remove(index);
                // update index of lastElement
                valueToIndices.get(lastElement).remove(lastIndex);
                valueToIndices.get(lastElement).add(index);
                if(valueToIndices.get(val).size() == 0){
                    valueToIndices.remove(val);
                }
            }
            return true;
        }
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return elementsList.get(rand.nextInt(elementsList.size()));

    }
}
