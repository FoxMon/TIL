function solution(str1, str2) {
    const arr1 = toChangeForJ(str1.toLowerCase())
    const arr2 = toChangeForJ(str2.toLowerCase())
    const merge = new Set([...arr1, ...arr2])
    let union = 0
    let inter = 0
    merge.forEach(e => {
        const temp1 = arr1.filter(item => item == e).length
        const temp2 = arr2.filter(item => item == e).length
        union += Math.max(temp1, temp2)
        inter += Math.min(temp1, temp2)
    })
    return union == 0 ? 65536 : Math.floor(inter / union * 65536)
}

function toChangeForJ(arr) {
    const result = []
    for(let i = 0; i < arr.length - 1; i++) {
        const str = arr.substr(i, 2)
        if(str.split("").every(s => s >= 'a' && s <= 'z')) result.push(str)
    }
    return result
}
