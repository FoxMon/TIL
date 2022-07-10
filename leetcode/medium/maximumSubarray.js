/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function (nums) {
    if (nums.length == 1) return nums[0]
    let sum = -Number.MAX_VALUE
    let prev = 0
    for (let i = 0; i < nums.length; i++) {
        prev = Math.max(prev + nums[i], nums[i])
        sum = Math.max(sum, prev)
    }
    return sum
}
