package leetCode.palindromeLinkedList;

import java.util.ArrayList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public boolean isPalindrome(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<>();

        while(head != null) {
            list.add(head);
            head = head.next;
        }

        for(int i = 0; i < list.size() / 2; i++) {
            if(list.get(i).val != list.get(list.size() - i - 1).val) {
                return false;
            }
        }

        return true;
    }
}
