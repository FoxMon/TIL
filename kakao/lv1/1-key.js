function solution(numbers, hand) {
    let answer = ''
    const center = [2, 5, 8, 11]
    let left = 10
    let right = 12
    let leftDistance = 0
    let rightDistance = 0
    numbers.forEach(n => {
        if(n == 0) n = 11
        if(n == 1 || n == 4 || n== 7) {
            answer += 'L'
            left = n
        } else if(n == 3 || n == 6 || n == 9) {
            answer += 'R'
            right = n
        } else {
            leftDistance = center.indexOf(left) != -1 ? Math.abs(n - left) / 3 : Math.abs(n - 1 - left) / 3 + 1
            rightDistance = center.indexOf(right) != -1 ? Math.abs(n - right) / 3 : Math.abs(n + 1 - right) / 3 + 1
            if(leftDistance == rightDistance) {
                if(hand == 'right') {
                    answer += 'R'
                    right = n
                } else {
                    answer += 'L'
                    left = n
                }
            } else if(leftDistance > rightDistance) {
                answer += 'R'
                right = n
            } else {
                answer += 'L'
                left = n
            }
        }
    })
    return answer
}