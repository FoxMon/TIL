/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function (s) {
    if (!s) return 0
    const obj = {}
    let left = 0
    let max = 0
    for (let i = 0; i < s.length; i++) {
        const ch = s[i]
        if (!obj[ch]) obj[ch] = 1
        else obj[ch] += 1
        while (obj[ch] > 1 && left < i) {
            obj[s.charAt(left)]--
            left++
        }
        max = Math.max(max, i - left + 1)
    }
    return max
}
