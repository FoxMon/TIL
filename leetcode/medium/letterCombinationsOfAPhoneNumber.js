/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function (digits) {
    if (!digits) return []
    const phone = {
        2: ["a", "b", "c"],
        3: ["d", "e", "f"],
        4: ["g", "h", "i"],
        5: ["j", "k", "l"],
        6: ["m", "n", "o"],
        7: ["p", "q", "r", "s"],
        8: ["t", "u", "v"],
        9: ["w", "x", "y", "z"],
    }
    const result = []
    function combi(str, index) {
        if (index == digits.length) {
            result.push(str)
            return
        }
        for (let a of phone[digits[index]]) {
            combi(str + a, index + 1)
        }
    }
    combi("", 0)
    return result
}
