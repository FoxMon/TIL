var isValid = function (s) {
    if (s.length == 1) return false
    let result = true
    const arr = []
    const obj = {}
    obj["("] = ")"
    obj["{"] = "}"
    obj["["] = "]"
    s.split("").forEach((v) => {
        if (v == "(" || v == "[" || v == "{") {
            arr.push(v)
        } else {
            if (arr.length > 0) {
                const top = arr.pop()
                if (v != obj[top]) {
                    result = false
                    return
                }
            } else {
                result = false
                return
            }
        }
    })
    if (arr.length != 0) return false
    return result
}
