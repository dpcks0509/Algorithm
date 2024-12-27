package baekjoon.graph

fun main() {
    data class Answer(val location: Int, val time: Int)

    val (n, k) = readln().split(" ").map { it.toInt() }

    val queue = ArrayDeque<Answer>()
    val visited = IntArray(100_001) { Int.MAX_VALUE }

    queue.add(Answer(n, 0))
    visited[n] = 0

    while (queue.isNotEmpty()) {
        val cur = queue.removeFirst()

        if (cur.location - 1 >= 0 && cur.time + 1 < visited[cur.location - 1]) {
            queue.add(Answer(cur.location - 1, cur.time + 1))
            visited[cur.location - 1] = cur.time + 1
        }

        if (cur.location + 1 <= 100_000 && cur.time + 1 < visited[cur.location + 1]) {
            queue.add(Answer(cur.location + 1, cur.time + 1))
            visited[cur.location + 1] = cur.time + 1
        }

        if (cur.location * 2 <= 100_000 && cur.time < visited[cur.location * 2]) {
            queue.add(Answer(cur.location * 2, cur.time))
            visited[cur.location * 2] = cur.time
        }
    }

    println(visited[k])
}