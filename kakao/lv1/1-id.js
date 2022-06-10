function solution(new_id) {
    let answer = '';
    let id1 = new_id.toLowerCase()
    let id2 = ''
    for(let i = 0; i < id1.length; i++) {
        const temp = id1[i]
        if((temp >= 'a' && temp <= 'z') || (parseInt(temp) >= 0 && parseInt(temp) <= 9) ||
            temp == '-' || temp == '_' || temp == '.') {
                id2 += temp
            }
    }
    while(id2.includes('..')) id2 = id2.replace('..', '.')
    let id3 = id2
    if(id3.charAt(0) == '.') id3 = id3.substring(1)
    if(id3.charAt(id3.length - 1) == '.') id3 = id3.substring(0, id3.length - 1)
    if(id3.length == 0) id3 = 'a'
    if(id3.length >= 16) id3 = id3.substring(0, 15)
    if(id3.charAt(0) == '.') id3 = id3.substring(1, id3.length)
    if(id3.charAt(id3.length - 1) == '.') id3 = id3.substring(0, id3.length - 1)
    if(id3.length <= 2) {
        const temp = id3.charAt(id3.length - 1)
        while(id3.length != 3) {
            id3 += temp
        }
    }
    answer = id3
    return answer
}