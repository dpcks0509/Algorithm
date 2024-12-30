package baekjoon.string

fun main() {
    val word = readln().toCharArray()
    val target = readln().toCharArray()

    var cnt = 0

    var index = 0
    while (index <= word.size - target.size) {
        var isEqual = true
        for (i in 0 until target.size) {
            if (target[i] != word[index + i]) {
                isEqual = false
                break
            }
        }
        if (isEqual) {
            cnt++
            index += target.size
        } else {
            index++
        }
    }

    println(cnt)
}