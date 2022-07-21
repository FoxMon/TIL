/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function (strs) {
    const obj = {}
    strs.forEach((s) => {
        const sorted = s.split("").sort().join("")
        if (obj[sorted]) {
            obj[sorted].push(s)
        } else {
            obj[sorted] = [s]
        }
    })
    return Object.values(obj)
}
