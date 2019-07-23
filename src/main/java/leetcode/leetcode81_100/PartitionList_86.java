package leetcode.leetcode81_100;

/*Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

        You should preserve the original relative order of the nodes in each of the two partitions.*/

import leetcode.ListNode;

public class PartitionList_86 {
    public static ListNode partition(ListNode head, int x) {
        if(head == null){
            return head;
        }
        // pointer to run through original list
        ListNode pointer = head;

        ListNode dummySmaller = new ListNode(0);
        ListNode pointerSmaller = dummySmaller;

        ListNode dummyLarger = new ListNode(0);
        ListNode pointerLarger = dummyLarger;

        while(pointer != null){
            if(pointer.val <= x){
                pointerSmaller.next = pointer;
                pointerSmaller = pointer;
            }
            else{
                pointerLarger.next = pointer;
                pointerLarger = pointer;
            }


            pointer = pointer.next;
        }

        pointerSmaller.next = dummyLarger.next;
        pointerLarger.next = null;

        return dummySmaller.next;

    }
}
