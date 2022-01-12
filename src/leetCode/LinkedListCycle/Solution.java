package leetCode.LinkedListCycle;

import java.util.ArrayList;

/**
 * Definition for singly-linked list.
 * class ListNode {
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
    ListNode() {}
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public boolean hasCycle(ListNode head) {
        ArrayList<ListNode> results = new ArrayList<>();
        ListNode node = new ListNode();
        node.next = head;

        while(node != null) {
            ListNode value = node;
            if(!results.contains(value)) {
                results.add(value);
            } else {
                return true;
            }
            node = node.next;
        }

        return false;
    }
}
