function solution(dartResult) {
    let answer = 0;
    let index = -1
    const dart = dartResult.split("")
    const arr = []
    for(let i = 0; i < dart.length; i++) {
        if(dart[i] == 'S' || dart[i] == 'D' || dart[i] == 'T') {
            if(dart[i] == 'D') arr[index] *= arr[index]
            else if(dart[i] == 'T') arr[index] *= arr[index] * arr[index]
        } else if(dart[i] == '*' || dart[i] == '#') {
            if(dart[i] == '#') arr[index] *= -1
            else {
                if(index >= 1) arr[index - 1] *= 2
                arr[index] *= 2
            }
        } else {
            if(dart[i] == '1' && dart[i + 1] == '0') {
                i++
                index++
                arr[index] = 10
            } else {
                index++
                arr[index] = dart[i] - '0'
            }
        }
    }
    arr.forEach(r => answer += r)
    return answer;
}