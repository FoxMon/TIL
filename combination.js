function combination(arr, numbers) {
    const result = []
    if (numbers == 1) return arr.map((v) => [v])
    arr.forEach((v, i) => {
        const fix = v
        const restArr = arr.slice(i + 1)
        const combinationArr = combination(restArr, numbers - 1)
        const combine = combinationArr.map((v) => [fix, ...v])
        result.push(...combine)
    })
    result.pop()
    return result
}
