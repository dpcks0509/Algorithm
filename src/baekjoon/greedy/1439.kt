package baekjoon.greedy

fun main() {
    val br = System.`in`.bufferedReader()

    val s = br.readLine().toCharArray()

    var zero = 0
    var one = 0

    var current = ' '
    for (ch in s) {
        if (current != ch) {
            current = ch
            if (ch == '0') zero++ else one++
        }
    }

    val answer = minOf(zero, one)
    println(answer)
}