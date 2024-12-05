package baekjoon.graph

class `7576` {
    data class Node(
        val x: Int,
        val y: Int,
    )

    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            val answer = StringBuilder()

            val (m, n) = readLine().split(' ').map { it.toInt() }
            val graph = Array(n) { readLine().split(' ').map { it.toInt() }.toTypedArray() }
            val dist = Array(n) { Array(m) { 0 } }
            val queue = ArrayDeque<Node>()
            val dx = listOf(1, 0, -1, 0)
            val dy = listOf(0, 1, 0, -1)

            for (i in 0 until n) {
                for (j in 0 until m) {
                    if (graph[i][j] == 1) {
                        queue.addLast(Node(i, j))
                    }
                    if (graph[i][j] == 0) {
                        dist[i][j] = -1
                    }
                }
            }

            while (queue.isNotEmpty()) {
                val cur = queue.removeFirst()
                for (i in 0 until 4) {
                    val nx = cur.x + dx[i]
                    val ny = cur.y + dy[i]

                    if (!(nx in 0..<n && ny in 0..<m)) continue
                    if (dist[nx][ny] == -1) {
                        dist[nx][ny] = dist[cur.x][cur.y] + 1
                        queue.addLast(Node(nx, ny))
                    }
                }
            }

            if (dist.flatten().contains(-1)) {
                answer.append("-1")
            } else {
                answer.append("${dist.flatten().max()}")
            }

            close()
            return answer.toString()
        }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`7576`().solution())

        flush()
        close()
    }
