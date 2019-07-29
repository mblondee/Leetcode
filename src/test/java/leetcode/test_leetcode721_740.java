package leetcode;

import leetcode.leetcode721_740.MyCalendarThree_732;
import leetcode.leetcode721_740.MyCalendarTwo_731;
import leetcode.leetcode721_740.MyCalendar_729;
import org.junit.Test;

import static org.junit.Assert.*;

public class test_leetcode721_740 {

    @Test
    public void testMyCalendar(){
        MyCalendar_729 cal = new MyCalendar_729();
        assertTrue(cal.book(10,20));
        assertFalse(cal.book(15,25));
        assertTrue(cal.book(20,30));
        assertFalse(cal.book(10, 40));
        assertTrue(cal.book(5,10));

        MyCalendar_729 cal1 = new MyCalendar_729();
        assertTrue(cal1.book(10,20));
        assertFalse(cal1.book(5, 15));


        MyCalendar_729 cal2 = new MyCalendar_729();
        assertTrue(cal2.book(47,50));
        assertTrue(cal2.book(33,41));
        assertFalse(cal2.book(39,45));
        assertFalse(cal2.book(33,42));
        assertTrue(cal2.book(25,32));
        assertFalse(cal2.book(26,35));
        assertTrue(cal2.book(19,25));

    }

    @Test
    public void testMyCalendarTwo(){
        MyCalendarTwo_731 cal = new MyCalendarTwo_731();
        assertTrue(cal.book(10,20));
        assertTrue(cal.book(50,60));
        assertTrue(cal.book(10,40));
        assertFalse(cal.book(5,15));
        assertTrue(cal.book(5,10));
        assertTrue(cal.book(25,55));

    }

    @Test
    public void testMyCalendarThree(){
        MyCalendarThree_732 cal = new MyCalendarThree_732();
        assertEquals(1, cal.book(10,20));
        assertEquals(1, cal.book(50,60));
        assertEquals(2, cal.book(10,40));
        assertEquals(3, cal.book(5,15));
        assertEquals(3, cal.book(5,10));
        assertEquals(3, cal.book(25,55));
    }
}
