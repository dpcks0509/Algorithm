package baekjoon.back_tracking

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val list = br.readLine().split(" ").map { it.toInt() }.sorted()

    fun recur(index: Int, depth: Int, str: String) {
        if (depth == m) {
            sb.append(str).append("\n")
            return
        }

        for (i in index until n) {
            recur(i + 1, depth + 1, str + "${list[i]} ")
        }
    }

    recur(0, 0, "")
    println(sb.toString())
}