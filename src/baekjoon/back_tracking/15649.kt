package baekjoon.back_tracking

fun main() {
    val br = System.`in`.bufferedReader()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val visited = BooleanArray(n + 1)

    fun recur(str: String, depth: Int) {
        if (depth == m) {
            println(str)
        }

        for (i in 1..n) {
            if (visited[i]) continue

            visited[i] = true
            recur(str + "$i ", depth + 1)
            visited[i] = false
        }
    }

    recur("", 0)
}