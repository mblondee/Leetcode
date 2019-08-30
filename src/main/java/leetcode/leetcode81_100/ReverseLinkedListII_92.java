package leetcode.leetcode81_100;

/*Reverse a linked list from position m to n. Do it in one-pass.

        Note: 1 ≤ m ≤ n ≤ length of list.*/

import leetcode.ListNode;

public class ReverseLinkedListII_92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || m==n){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // find node previous to m-th node (m-1)th node
        // m-th node is tail of sublist

        ListNode previous = dummy;

        // jump m-1 times
        for(int i = 1; i <= m-1; i++){
            previous = previous.next;
        }

        // subListTail is known
        ListNode subListTail = previous.next;


        // we try to find subListStart
        // node next from current has to be put in front of sublist
        ListNode subListStart = subListTail;

        for(int i = 1; i <= n-m; i++){
            ListNode next = subListTail.next;

            // node next from tail has to be put in front
            // replace with current start
            previous.next = next;
            subListTail.next = next.next;
            next.next = subListStart;
            subListStart = next;
        }

        return dummy.next;

    }
}
