package baekjoon.string

fun main() {
    val br = System.`in`.bufferedReader()

    val str = br.readLine()

    val alphabet = IntArray(26)
    str.forEach {
        alphabet[it - 'A']++
    }

    if (alphabet.count { it % 2 == 1 } > 1) {
        println("I'm Sorry Hansoo")
        return
    }

    var odd = -1

    for (i in 0 until 26) {
        if (alphabet[i] % 2 == 1) {
            odd = i
            alphabet[i]--
            break
        }
    }

    var half = ""

    for (i in 0 until 26) {
        repeat(alphabet[i] / 2) {
            half += ('A' + i)
        }
    }

    val answer = half + (if (odd != -1) ('A' + odd) else "") + half.reversed()
    println(answer)
}