package leetCode.insertionOfTwoLinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

class ListNode {
    int val;
    ListNode next;

    public ListNode() {}
    public ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null && headB == null) {
            return null;
        }

        ListNode first = headA;
        ListNode last = headB;

        while(first != null && last != null) {
            if(first == last) {
                return first;
            }

            first = first.next;
            last = last.next;
            if(first == null && last == null) {
                return null;
            }

            if(first == null) {
                first = headB;
            }

            if(last == null) {
                last = headA;
            }
        }

        return null;
    }
}
