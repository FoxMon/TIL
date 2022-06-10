function solution(n, arr1, arr2) {
    const answer = [];
    for(let i = 0; i < n; i++) {
        const first = arr1[i].toString(2).split("")
        while(first.length < n) first.unshift(0)
        const second = arr2[i].toString(2).split("")
        while(second.length < n) second.unshift(0)
        answer.push(doCompareMap(first, second))
    }
    return answer;
}

function doCompareMap(first, second) {
    let result = ""
    for(let i = 0; i < first.length; i++) {
        if(first[i] == '1' || second[i] == '1') result += '#'
        else result += " "
    }
    return result
}