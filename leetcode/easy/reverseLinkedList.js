/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var reverseList = function (head) {
    if (!head) return head
    const arr = []
    while (head) {
        arr.push(head)
        head = head.next
    }
    arr[0].next = null
    // reverse
    for (let i = 1; i < arr.length; i++) {
        arr[i].next = arr[i - 1]
    }
    return arr[arr.length - 1]
}
