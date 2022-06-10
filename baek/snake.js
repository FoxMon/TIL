const input = require('fs').readFileSync('example.txt').toString().split('\n')
const n = parseInt(input.shift())
const k = parseInt(input.shift())
const apples = []
const dy = [0, 1, 0, -1]
const dx = [1, 0, -1, 0]
for(let i = 0; i < k; i++) {
    const appleArr = input.shift().split(' ')
    apples.push([parseInt(appleArr[0]), parseInt(appleArr[1])])
}
const l = parseInt(input.shift())
const commands = []
for(let i = 0; i < l; i++) {
    const command = input.shift().split(' ')
    commands.push([parseInt(command[0]), command[1]])
}
const board = []
for(let i = 0; i < n + 1; i++) {
    board[i] = new Array(n + 1).fill(0)
}
apples.forEach(e => board[e[0]][e[1]] = 1)

function turn(direction, command) {
    if(command == 'L') direction = (direction - 1) % 4
    else direction = (direction + 1) % 4
    return direction
}
// start -> 동쪽 0 -> 시계방향 + 1, 반대 - 1
function solution() {
    let row = 1
    let col = 1
    let time = 0
    let dir = 0
    let nextDir = 0
    const snake = []
    snake.push([row, col])
    board[row][col] = 2
    while(true) {
        const curRow = row + dy[dir]
        const curCol = col + dx[dir]
        if(curRow >= 1 && curCol >= 1 && curRow <= n && curCol <= n && board[curRow][curCol] != 2) {
            if(board[curRow][curCol] == 0) {
                board[curRow][curCol] = 2
                snake.push([curRow, curCol])
                const snakeSpot = snake.shift()
                board[snakeSpot[0]][snakeSpot[1]] = 0
            } else if(board[curRow][curCol] == 1) {
                board[curRow][curCol] = 2
                snake.push([curRow, curCol])
            }
        } else {
            time++
            break
        }
        row = curRow
        col = curCol
        time++
        if(nextDir < 1 && time == commands[nextDir][0]) {
            dir = turn(dir, commands[nextDir][1])
            nextDir++
        }
    }
    return time
}

console.log(solution())