/**
 * @param {number[]} nums
 * @return {number[]}
 */
var findDisappearedNumbers = function (nums) {
    const arr = new Array(nums.length)
    for (let i = 0; i < nums.length; i++) {
        arr[i] = i + 1
    }
    const result = arr.filter((e) => !nums.includes(e))
    return result
}
