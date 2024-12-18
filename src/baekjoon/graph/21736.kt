package baekjoon.graph

fun main() {
    data class Node(
        val x: Int,
        val y: Int,
    )

    val (n, m) = readln().split(" ").map { it.toInt() }
    val campus = Array(n) { CharArray(m) }

    var start = Node(0, 0)

    for (i in 0 until n) {
        val input = readln().toCharArray()
        if (input.contains('I')) {
            val j = input.indexOfFirst { it == 'I' }
            start = Node(i, j)
        }
        campus[i] = input
    }

    val dx = listOf(1, -1, 0, 0)
    val dy = listOf(0, 0, -1, 1)

    val queue = ArrayDeque<Node>()
    val visited = Array(n) { BooleanArray(m) }

    queue.add(start)
    visited[start.x][start.y] = true

    var cnt = 0
    while (queue.isNotEmpty()) {
        val current = queue.removeFirst()

        for (i in 0 until 4) {
            val next = Node(current.x + dx[i], current.y + dy[i])

            if (next.x !in 0 until n || next.y !in 0 until m) continue
            if (visited[next.x][next.y] || campus[next.x][next.y] == 'X') continue

            if (campus[next.x][next.y] == 'P') {
                cnt++
            }

            queue.add(next)
            visited[next.x][next.y] = true
        }
    }

    if (cnt != 0) println(cnt) else println("TT")
}
