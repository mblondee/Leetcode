package leetcode;

import leetcode.leetcode641_680.MyCircularDeque_641;
import org.junit.Test;

import static org.junit.Assert.*;

public class test_leetcode641_680 {

    @Test
    public void testMyCircularDeque(){
        //MyCircularDeque_641 deque = new MyCircularDeque_641(4);
/*        assertTrue(deque.isEmpty());
        assertFalse(deque.isFull());


        // delete from empty
        assertFalse(deque.deleteFront());
        assertTrue(deque.isEmpty());
        assertFalse(deque.isFull());
        assertFalse(deque.deleteLast());
        assertTrue(deque.isEmpty());
        assertFalse(deque.isFull());

        assertTrue(deque.insertFront(1));
        assertEquals(1, deque.getFront());
        assertFalse(deque.isEmpty());
        assertFalse(deque.isFull());
        assertTrue(deque.insertFront(2));
        assertEquals(2, deque.getFront());
        assertEquals(1, deque.getRear());
        assertTrue(deque.insertFront(3));
        assertTrue(deque.insertFront(4));
        assertEquals(1, deque.getRear());
        assertFalse(deque.isEmpty());
        assertTrue(deque.isFull());
        assertFalse(deque.insertFront(5));

        // 4 - 3 - 2 - 1
        assertTrue(deque.deleteFront());
        assertEquals(3, deque.getFront());
        assertTrue(deque.deleteLast());
        assertEquals(3, deque.getFront());
        assertTrue(deque.deleteLast());
        assertEquals(3, deque.getFront());
        assertEquals(3, deque.getRear());*/

        MyCircularDeque_641 deque = new MyCircularDeque_641(3);
        assertTrue(deque.insertLast(1));
        assertTrue(deque.insertLast(2));
        assertTrue(deque.insertFront(3));
        assertFalse(deque.insertFront(4));
        assertEquals(2, deque.getRear());
        assertTrue(deque.isFull());
        assertTrue(deque.deleteLast());
        assertTrue(deque.insertFront(4));
        assertEquals(4, deque.getFront());




    }
}
