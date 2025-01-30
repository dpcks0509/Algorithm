package baekjoon.brute_force

fun main() {
    val br = System.`in`.bufferedReader()

    val s = br.readLine()
    val t = br.readLine()

    var isPossible = false

    fun recur(str: String) {
        if (isPossible || s.length > str.length) {
            return
        }

        if (s == str) {
            isPossible = true
            return
        }

        if (str.last() == 'A') {
            recur(str.dropLast(1))
        }

        if (str.first() == 'B') {
            recur(str.drop(1).reversed())
        }
    }

    recur(t)
    println(if (isPossible) 1 else 0)
}