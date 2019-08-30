package leetcode.leetcode201_220;

/*Reverse a singly linked list.*/


//iterative and recursive version

import leetcode.ListNode;

public class ReverseLinkedList_206 {
    public ListNode reverseListit(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode previous = null;
        ListNode current = head;

        while(current != null){
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;

    }

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        ListNode reverse = reverseList(next);
        next.next = head;
        head.next = null;

        return reverse;

    }
}
