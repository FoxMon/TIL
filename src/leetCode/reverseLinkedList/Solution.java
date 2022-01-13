package leetCode.reverseLinkedList;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;

    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode temp = head;
        Stack<ListNode> stack = new Stack<>();

        while(temp.next != null) {
            stack.push(temp);
            temp = temp.next;
        }

        head = temp;

        while(!stack.isEmpty()) {
            temp.next = stack.peek();
            stack.pop();
            temp = temp.next;
        }

        temp.next = null;

        return head;
    }
}
