/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function (nums) {
    const obj = {}
    nums.forEach((e) => {
        if (!obj[e]) obj[e] = 1
        else obj[e] += obj[e]
    })
    let result = 0
    Object.keys(obj).forEach((e) => {
        if (obj[e] == 1) result = e
    })
    return result
}
