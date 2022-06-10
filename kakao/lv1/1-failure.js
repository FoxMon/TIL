function solution(N, stages) {
    const failure = []
    for(let i = 0; i < N; i++) {
        const curStage = i + 1
        let total = 0
        let count = 0
        stages.forEach((s) => {
            if(curStage <= s) {
                if(s <= curStage) {
                    count++
                }
                total++
            }
        })
        const obj = {
            stage: curStage,
            curStage: count / total,
        }
        failure.push(obj)
    }
    failure.sort((a, b) => b.curStage - a.curStage)
    const answer = failure.map((e) => {
        return e.stage
    })
    return answer
}