/**
 * @param {number} n
 * @return {number[]}
 */
var countBits = function (n) {
    const arr = []
    for (let i = 0; i <= n; i++) {
        const binary = i.toString(2)
        const count = binary
            .toString()
            .split("")
            .filter((e) => e == "1").length
        arr.push(count)
    }
    return arr
}
