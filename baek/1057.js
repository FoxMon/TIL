const readline = require("readline")
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
})
let arr = []

rl.on("line", (line) => {
    arr = line.toString().split(" ")
    rl.close()
})

rl.on("close", () => {
    const array = []
    arr.forEach((e) => {
        array.push(parseInt(e))
    })
    let count = 0
    let me = array[1]
    let you = array[2]
    while (me != you) {
        me = Math.floor((me + 1) / 2)
        you = Math.floor((you + 1) / 2)
        count++
    }
    console.log(count)
})
