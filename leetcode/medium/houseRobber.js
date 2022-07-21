/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function (nums) {
    let prev = 0
    let cur = 0
    for (let n of nums) {
        let temp = cur
        cur = Math.max(prev + n, cur)
        prev = temp
    }
    return cur
}
