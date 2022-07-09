function solution(numbers) {
    const arr = numbers.map((e) => e.toString()).sort((a, b) => (b + a) - (a + b)).join('')
    return arr[0] == '0' ? '0' : arr
}