package leetcode.leetcode621_640;


/*Design your implementation of the circular queue.
The circular queue is a linear data structure in which the operations are performed based on
 FIFO (First In First Out) principle and the last position is connected back to the first position to make a circle.
 It is also called "Ring Buffer".

        One of the benefits of the circular queue is that we can make use of the spaces in front of the queue.
        In a normal queue, once the queue becomes full, we cannot insert the next element even
        if there is a space in front of the queue. But using the circular queue, we can use the space to store new values.

        Your implementation should support following operations:

        MyCircularQueue(k): Constructor, set the size of the queue to be k.
        Front: Get the front item from the queue. If the queue is empty, return -1.
        Rear: Get the last item from the queue. If the queue is empty, return -1.
        enQueue(value): Insert an element into the circular queue. Return true if the operation is successful.
        deQueue(): Delete an element from the circular queue. Return true if the operation is successful.
        isEmpty(): Checks whether the circular queue is empty or not.
        isFull(): Checks whether the circular queue is full or not.*/

public class MyCircularQueue_622 {

    private Integer[] array;
    private int head; // dequeue at the start
    private int rear; // enqueue at the end
    private int size;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue_622(int k) {
        array = new Integer[k];
        size = 0;
        head = 0;
        rear = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }

        // enqueue at rear!

        //update pointers head and rear
        if(isEmpty()){
            head = 0;
            rear = 0;
        } else if (rear == array.length-1) {
           rear = 0;
        }
        else{
            rear++;
        }

        array[rear] = value;
        size++;
        return true;

    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }

        array[head] = null;

        // dequeue at start!
        // update pointers head and rear
        if(size == 1){
            head = 0;
            rear = 0;
        }
        else if(head == array.length-1){
            head = 0;
        }
        else{
            head++;
        }

        size--;
        return true;

    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return array[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return array[rear];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == array.length;
    }
}
