function permutation(arr, numbers) {
    const result = []
    if (numbers == 1) return arr.map((v) => [v])
    arr.forEach((v, i) => {
        const fix = v
        const restArr = arr.filter((_, index) => index != i)
        const permutationArr = permutation(restArr, numbers - 1)
        const combine = permutationArr.map((v) => [fix, ...v])
        result.push(...combine)
    })
    return result
}
