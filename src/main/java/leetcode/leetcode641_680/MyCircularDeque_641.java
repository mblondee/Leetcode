package leetcode.leetcode641_680;

/*Design your implementation of the circular double-ended queue (deque).

        Your implementation should support following operations:

        MyCircularDeque(k): Constructor, set the size of the deque to be k.
        insertFront(): Adds an item at the front of Deque. Return true if the operation is successful.
        insertLast(): Adds an item at the rear of Deque. Return true if the operation is successful.
        deleteFront(): Deletes an item from the front of Deque. Return true if the operation is successful.
        deleteLast(): Deletes an item from the rear of Deque. Return true if the operation is successful.
        getFront(): Gets the front item from the Deque. If the deque is empty, return -1.
        getRear(): Gets the last item from Deque. If the deque is empty, return -1.
        isEmpty(): Checks whether Deque is empty or not.
        isFull(): Checks whether Deque is full or not.*/

public class MyCircularDeque_641 {

    private Integer[] array;
    private int headIndex; // head index
    private int rearIndex; // rear index
    private int size;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque_641(int k) {
        array = new Integer[k];
        headIndex = 0;
        rearIndex = 0;
        size = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }

        //update headIndex (and rearIndex)

        if(isEmpty()){
            headIndex = 0;
            rearIndex = 0;
        }
        else if(headIndex == 0){
            headIndex = array.length-1;
        }
        else{
            headIndex--;
        }

        array[headIndex] = value;
        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }
        //update rearIndex
        if(isEmpty()){
            headIndex = 0;
            rearIndex = 0;
        }
        else if(rearIndex == array.length-1){
            rearIndex = 0;
        }
        else{
            rearIndex++;
        }

        array[rearIndex] = value;
        size++;
        return true;

    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }

        array[headIndex] = null;

        // update headIndex (and rearIndex if after deletion empty) (needs to increase)
        if (size == 1) {
            // after this will be empty -> reset
            headIndex = 0;
            rearIndex = 0;
        }
        else if(headIndex == array.length -1){
            headIndex = 0;
        }
        else{
            headIndex++;
        }

        size--;
        return true;



    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }

        array[rearIndex] = null;

        // update rearIndex (and headIndex)
        if (size == 1) {
            // after this will be empty -> reset
            headIndex = 0;
            rearIndex = 0;
        }
        else if(rearIndex == 0){
            rearIndex = array.length -1;
        }
        else{
            rearIndex--;
        }

        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty()){
            return -1;
        }
        return array[headIndex];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty()){
            return -1;
        }
        return array[rearIndex];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;

    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == array.length;
    }
}
