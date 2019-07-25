package leetcode;

import leetcode.leetcode621_640.MyCircularQueue_622;
import org.junit.Test;

import static org.junit.Assert.*;

public class test_leetcode621_640 {

    @Test
    public void testMyCircularQueue(){
        MyCircularQueue_622 queue = new MyCircularQueue_622(3);
        assertTrue(queue.enQueue(1));
        assertTrue(queue.enQueue(2));
        assertTrue(queue.enQueue(3));
        assertFalse(queue.enQueue(4));
        assertEquals(3, queue.Rear() );
        assertEquals(1, queue.Front());
        assertTrue(queue.deQueue());
        assertEquals(3, queue.Rear() );
        assertEquals(2, queue.Front());
        assertTrue(queue.enQueue(4));
        assertEquals(4, queue.Rear());
    }
}
