function solution(s){
    if(s[0] == ")") return false
    let answer = true
    const arr = []
    const bracket = {}
    bracket['('] = ')'
    s.split("").forEach((e) => {
        if(e == '(') arr.push(e)
        else {
            if(arr.length == 0) return false
            const top = arr.pop()
            if(bracket[top] != e) return false
        }
    })
    if(arr.length != 0) return false
    return answer
}