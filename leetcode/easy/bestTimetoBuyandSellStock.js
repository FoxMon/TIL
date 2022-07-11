/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function (prices) {
    let min = prices[0]
    let sum = 0
    for (let i = 1; i < prices.length; i++) {
        min = Math.min(min, prices[i])
        sum = Math.max(sum, prices[i] - min)
    }
    return sum
}
