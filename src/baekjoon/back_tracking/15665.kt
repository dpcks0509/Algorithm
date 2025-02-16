package baekjoon.back_tracking

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val list = br.readLine().split(" ").map { it.toInt() }.distinct().sorted()

    fun recur(depth: Int, str: String) {
        if (depth == m) {
            sb.append(str).append("\n")
            return
        }

        for (i in 0 until list.size) {
            recur(depth + 1, str + "${list[i]} ")
        }
    }

    recur(0, "")
    println(sb.toString())
}