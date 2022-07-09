function solution(priorities, location) {
    let answer = 0
    const arr = []
    priorities.forEach((e, i) => {
        arr.push({
            value: e,
            target: i == location
        })
    })
    while(true) {
        const first = arr.shift()
        if(arr.some(e => e.value > first.value)) {
            arr.push(first)
        } else {
            answer++
            if(first.target) {
                return answer
            }
        }
    }
}