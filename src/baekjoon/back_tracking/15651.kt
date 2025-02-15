package baekjoon.back_tracking

fun main() {
    val br = System.`in`.bufferedReader()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val sb = StringBuilder()

    fun recur(depth: Int, str: String) {
        if (depth == m) {
            sb.append(str).append("\n")
            return
        }

        for (i in 1..n) {
            recur(depth + 1, str + "$i ")
        }
    }

    recur(0, "")
    println(sb.toString())
}