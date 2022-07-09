function solution(s) {
    let answer = []
    answer.push(0)
    answer.push(0)
    while(s.length != 1) {
        for(let i = 0; i < s.length; i++) {
            if(s[i] == '0') answer[1]++
        }
        while(s.includes("0")) s = s.replace("0", "")
        s = s.length.toString(2)
        answer[0]++
    }
    return answer
}