package baekjoon.back_tracking

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val numbers = readln().split(" ").map { it.toInt() }.sorted()
    val visited = BooleanArray(n)

    fun backTracking(
        depth: Int,
        str: String,
    ) {
        if (depth == m) {
            println(str.trim())
            return
        }

        for (i in 0 until n) {
            if (visited[i]) continue

            visited[i] = true
            backTracking(depth + 1, "$str ${numbers[i]}")
            visited[i] = false
        }
    }

    backTracking(0, "")
}
