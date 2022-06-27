function solution(s) {
    let answer = ''
    let prev = s[0]
    answer += prev.toUpperCase()
    for(let i = 1; i < s.length; i++) {
        if(prev == " ") prev = s[i].toUpperCase()
        else prev = s[i].toLowerCase()
        answer += prev
    }
    return answer
}