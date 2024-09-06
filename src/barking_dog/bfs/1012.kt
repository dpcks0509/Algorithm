package barking_dog.bfs

class `1012` {
    data class Node(
        val x: Int,
        val y: Int,
    )

    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            val answer = StringBuilder()

            val t = readLine().toInt()
            val dx = listOf(1, 0, -1, 0)
            val dy = listOf(0, 1, 0, -1)
            repeat(t) {
                val (m, n, k) = readLine().split(' ').map { it.toInt() }
                val board = Array(n) { Array(m) { 0 } }
                repeat(k) {
                    val (c, r) = readLine().split(' ').map { it.toInt() }
                    board[r][c] = 1
                }
                val queue = ArrayDeque<Node>()
                var cnt = 0

                fun bfs(node: Node) {
                    cnt++
                    board[node.x][node.y] = 0
                    queue.addLast(Node(node.x, node.y))
                    while (queue.isNotEmpty()) {
                        val cur = queue.removeFirst()
                        for (i in 0 until 4) {
                            val nx = cur.x + dx[i]
                            val ny = cur.y + dy[i]

                            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue
                            if (board[nx][ny] == 1) {
                                board[nx][ny] = 0
                                queue.addLast(Node(nx, ny))
                            }
                        }
                    }
                }

                for (i in 0 until n) {
                    for (j in 0 until m) {
                        if (board[i][j] == 1) {
                            bfs(Node(i, j))
                        }
                    }
                }

                answer.append("${cnt}\n")
            }

            close()
            return answer.toString()
        }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`1012`().solution())

        flush()
        close()
    }
