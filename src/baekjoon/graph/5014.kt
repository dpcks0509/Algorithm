package baekjoon.graph

fun main() {
    val br = System.`in`.bufferedReader()

    val (f, s, g, u, d) = br.readLine().split(" ").map { it.toInt() }

    val dir = listOf(u, -d)
    val visited = IntArray(f + 1) { Int.MAX_VALUE }
    val deque = ArrayDeque<Int>()

    deque.add(s)
    visited[s] = 0

    while (deque.isNotEmpty()) {
        val current = deque.removeFirst()

        if (current == g) {
            println(visited[current])
            return
        }

        for (i in 0 until 2) {
            val next = current + dir[i]

            if (next !in 1..f) continue
            if (visited[current] + 1 >= visited[next]) continue

            deque.add(next)
            visited[next] = visited[current] + 1
        }
    }

    println("use the stairs")
}