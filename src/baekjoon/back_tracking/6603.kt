package baekjoon.back_tracking

fun main() {
    val br = System.`in`.bufferedReader()

    while (true) {
        val input = br.readLine().split(" ").map { it.toInt() }
        val n = input[0]

        if (n == 0) break

        val list = input.drop(1)
        val visited = BooleanArray(n)

        fun recur(index: Int, depth: Int, str: String) {
            if (depth == 6) {
                println(str)
                return
            }

            for (i in index until n) {
                if (visited[i]) continue

                visited[i] = true
                recur(i + 1, depth + 1, str + "${list[i]} ")
                visited[i] = false
            }
        }

        recur(0, 0, "")
        println()
    }
}