function solution(id_list, report, k) {
    let answer = new Array(id_list.length).fill(0)
    const users = {}
    id_list.forEach(e => users[e] = [])
    report.forEach(e => {
        const arr = e.split(" ")
        if(!users[arr[1]].includes(arr[0])) users[arr[1]].push(arr[0])
    })
    Object.keys(users).forEach(e => {
        if(users[e].length >= k) {
            users[e].forEach(u => {
                const findIndex = id_list.indexOf(u)
                answer[findIndex] += 1
            })
        }
    })
    return answer
}
