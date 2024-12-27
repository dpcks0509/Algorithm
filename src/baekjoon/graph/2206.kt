package baekjoon.graph

fun main() {
    data class Node(val x: Int, val y: Int, val cnt: Int, var breakable: Boolean)

    val dx = listOf(1, -1, 0, 0)
    val dy = listOf(0, 0, -1, 1)

    val (n, m) = readln().split(" ").map { it.toInt() }
    val board = Array(n) { readln().map { it.toString().toInt() } }

    var min = Int.MAX_VALUE

    fun bfs() {
        val queue = ArrayDeque<Node>()
        val visited = Array(n) { Array(m) { BooleanArray(2) } }

        queue.add(Node(0, 0, 1, true))
        visited[0][0][0] = true

        while (queue.isNotEmpty()) {
            val cur = queue.removeFirst()

            if (cur.x == n - 1 && cur.y == m - 1) {
                min = minOf(min, cur.cnt)
            }

            for (k in 0 until 4) {
                val nx = cur.x + dx[k]
                val ny = cur.y + dy[k]

                if (nx !in 0 until n || ny !in 0 until m) continue

                if (board[nx][ny] == 1 && cur.breakable && !visited[nx][ny][1]) {
                    queue.add(Node(nx, ny, cur.cnt + 1, false))
                    visited[nx][ny][1] = true
                }

                if (board[nx][ny] == 0 && !visited[nx][ny][if (cur.breakable) 0 else 1]) {
                    queue.add(Node(nx, ny, cur.cnt + 1, cur.breakable))
                    visited[nx][ny][if (cur.breakable) 0 else 1] = true
                }
            }
        }
    }

    bfs()

    val answer = if (min != Int.MAX_VALUE) min else -1
    println(answer)
}