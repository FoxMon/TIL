/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function (nums) {
    const number = {}
    nums.forEach((e) => {
        if (!number[e]) number[e] = 1
        else number[e] += 1
    })
    let max = 0
    let maxKey = 0
    Object.keys(number).forEach((e) => {
        if (number[e] >= max) {
            maxKey = parseInt(e)
            max = number[e]
        }
    })
    return maxKey
}
