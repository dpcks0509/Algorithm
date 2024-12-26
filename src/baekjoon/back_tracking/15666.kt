package baekjoon.back_tracking

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val numbers = readln().split(" ").map { it.toInt() }.distinct().sorted()

    fun backTracking(index: Int, depth: Int, str: String) {
        if (depth == m) {
            println(str.trim())
            return
        }

        for (i in index until numbers.size) {
            backTracking(i, depth + 1, "$str ${numbers[i]}")
        }
    }

    backTracking(0, 0, "")
}