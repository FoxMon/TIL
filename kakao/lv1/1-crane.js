function solution(board, moves) {
    let answer = 0
    const bascket = []
    const crane = [new Array(board.length)].fill(0)
    for(let i = 0; i < board.length; i++) {
        crane[i] = []
        for(let j = board.length - 1; j >= 0; j--) {
            if(board[j][i] != 0) crane[i].push(board[j][i])
        }
    }
    moves.forEach((e) => {
        const doll = crane[e - 1]
        if(doll.length == 0) return
        const item = doll.pop()
        if(bascket.length == 0) bascket.push(item)
        else {
            if(bascket[bascket.length - 1] == item) {
                bascket.pop()
                answer += 2
            } else bascket.push(item)
        }
    })
    return answer
}
