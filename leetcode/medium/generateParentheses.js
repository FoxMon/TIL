/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function (n) {
    const result = []
    function dfs(current, left, right) {
        if (current.length == 2 * n) {
            result.push(current)
            return
        }
        if (left < n) {
            dfs(current.concat("("), left + 1, right)
        }
        if (left > right) {
            dfs(current.concat(")"), left, right + 1)
        }
    }
    dfs("", 0, 0)
    return result
}
