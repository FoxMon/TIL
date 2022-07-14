/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {boolean}
 */
var isPalindrome = function (head) {
    let result = ""
    while (head) {
        result += head.val
        head = head.next
    }
    for (let i = 0; i < result.length / 2; i++) {
        if (result[i] != result[result.length - 1 - i]) return false
    }
    return true
}
