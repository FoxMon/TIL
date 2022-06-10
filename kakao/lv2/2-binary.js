function solution(n, t, m, p) {
    let answer = '';
    const strArr = []
    for(let i = 0; i < t * m; i++) {
        const base = i
        strArr.push(base.toString(n))
    }
    const str = strArr.join("")
    for(let i = 0; i < t * m; i++) {
        if(i % m == (p - 1)) {
            answer += str[i].toUpperCase()
        }
    }
    return answer;
}