function solution(s) {
    let answer = 0;
    const numObj = {
        'zero': '0',
        'one': '1',
        'two': '2',
        'three': '3',
        'four': '4',
        'five': '5',
        'six': '6',
        'seven': '7',
        'eight': '8',
        'nine': '9',
    }
    let temp = ""
    for(let i = 0; i < s.length; i++) {
        const ch = s[i]
        if(parseInt(ch) >= 0 && parseInt(ch) <= 9) {
            answer += ch
        } else {
            temp += s[i]
            if(numObj[temp] != null) {
                answer += numObj[temp]
                temp = ""
            }
        }
    }
    return parseInt(answer)
}
