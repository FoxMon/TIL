/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function (l1, l2) {
    let first = l1
    let last = l2
    let head = new ListNode()
    let pointer = head
    let carry = 0
    while (first != null || last != null) {
        let value1 = first == null ? 0 : first.val
        let value2 = last == null ? 0 : last.val
        const sum = carry + value1 + value2
        if (sum > 9) carry = 1
        else carry = 0
        head.next = new ListNode(sum % 10)
        head = head.next
        first = first == null ? null : first.next
        last = last == null ? null : last.next
    }
    if (carry > 0) {
        head.next = new ListNode(carry)
    }
    return pointer.next
}
