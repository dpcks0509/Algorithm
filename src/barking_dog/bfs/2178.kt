package barking_dog.bfs

class `2178` {
    data class Node(
        val x: Int,
        val y: Int,
    )

    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            val answer = StringBuilder()

            val (n, m) = readLine().split(' ').map { it.toInt() }
            val graph = Array(n) { readLine().map { it.toString().toInt() }.toIntArray() }
            val dist = Array(n) { IntArray(m) { -1 } }
            val queue = ArrayDeque<Node>()
            val dx = listOf(1, 0, -1, 0)
            val dy = listOf(0, 1, 0, -1)

            queue.addLast(Node(0, 0))
            dist[0][0] = 0

            while (queue.isNotEmpty()) {
                val cur = queue.removeFirst()
                for (i in 0 until 4) {
                    val nx = cur.x + dx[i]
                    val ny = cur.y + dy[i]
                    if ((nx in 0..<n && ny in 0..<m) && (graph[nx][ny] == 1 && dist[nx][ny] == -1)) {
                        dist[nx][ny] = dist[cur.x][cur.y] + 1
                        queue.addLast(Node(nx, ny))
                    }
                }
            }

            answer.append("${dist[n - 1][m - 1] + 1}")

            close()
            return answer.toString()
        }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`2178`().solution())

        flush()
        close()
    }
