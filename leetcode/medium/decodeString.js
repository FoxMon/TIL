/**
 * @param {string} s
 * @return {string}
 */
var decodeString = function (s) {
    const arr = []
    for (let i = 0; i < s.length; i++) {
        if (s[i] != "]") {
            arr.push(s[i])
        } else {
            let str = ""
            while (arr[arr.length - 1] != "[") str = arr.pop() + str
            arr.pop()
            let number = ""
            while (arr && !isNaN(arr[arr.length - 1]))
                number = arr.pop() + number
            arr.push(str.repeat(parseInt(number)))
        }
    }
    return arr.join("")
}
console.log(decodeString("100[leetcode]"))
