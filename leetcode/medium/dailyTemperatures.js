/**
 * @param {number[]} temperatures
 * @return {number[]}
 */
var dailyTemperatures = function (temperatures) {
    const result = new Array(temperatures.length).fill(0)
    for (let i = 0; i < temperatures.length; i++) {
        for (let j = i + 1; j < temperatures.length; j++) {
            if (temperatures[i] < temperatures[j]) {
                result[i] = j - i
                break
            }
        }
    }
    return result
}
