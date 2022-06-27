function solution(m, n, board) {
    board = board.map(e => e.split(""))
    while(true) {
        const arr = []
        for(let i = 0; i < m - 1; i++) {
            for(let j = 0; j < n - 1; j++) {
                if(board[i][j] && board[i][j] == board[i + 1][j] &&
                    board[i][j] == board[i][j + 1] && board[i][j] == board[i + 1][j + 1]) arr.push([i, j])
            }
        }
        if(!arr.length) return [].concat(...board).filter(e => e == 0).length
        for (let i = 0; i < arr.length; i++) {
            const row = arr[i][0];
            const col = arr[i][1];
            board[row][col] = 0;
            board[row][col + 1] = 0;
            board[row + 1][col] = 0;
            board[row + 1][col + 1] = 0;
          }
        for(let i = m - 1; i > 0; i--) {
            if(!board[i].some(e => !e)) continue
            for(let j = 0; j < n; j++) {
                for(let k = i - 1; k >= 0 && !board[i][j]; k--) {
                    if(board[k][j]) {
                        board[i][j] = board[k][j]
                        board[k][j] = 0
                        break
                    }
                }
            }
        }
    }
}