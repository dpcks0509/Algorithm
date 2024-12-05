package baekjoon.graph

class `4179` {
    data class Node(
        val x: Int,
        val y: Int,
    )

    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            val (r, c) = readLine().split(' ').map { it.toInt() }
            val board = Array(r) { readLine().toCharArray() }
            val fireDist = Array(r) { IntArray(c) { -1 } }
            val personDist = Array(r) { IntArray(c) { -1 } }
            val fireQueue = ArrayDeque<Node>()
            val personQueue = ArrayDeque<Node>()
            val dx = listOf(1, 0, -1, 0)
            val dy = listOf(0, 1, 0, -1)

            for (i in 0 until r) {
                for (j in 0 until c) {
                    when (board[i][j]) {
                        'J' -> {
                            personDist[i][j] = 0
                            personQueue.addLast(Node(i, j))
                        }

                        'F' -> {
                            fireDist[i][j] = 0
                            fireQueue.addLast(Node(i, j))
                        }
                    }
                }
            }

            while (fireQueue.isNotEmpty()) {
                val cur = fireQueue.removeFirst()

                for (i in 0 until 4) {
                    val nx = cur.x + dx[i]
                    val ny = cur.y + dy[i]

                    if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue
                    if (fireDist[nx][ny] >= 0 || board[nx][ny] == '#') continue

                    fireDist[nx][ny] = fireDist[cur.x][cur.y] + 1
                    fireQueue.addLast(Node(nx, ny))
                }
            }

            while (personQueue.isNotEmpty()) {
                val cur = personQueue.removeFirst()

                for (i in 0 until 4) {
                    val nx = cur.x + dx[i]
                    val ny = cur.y + dy[i]

                    if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                        return "${personDist[cur.x][cur.y] + 1}"
                    }
                    if (personDist[nx][ny] >= 0 || board[nx][ny] == '#') continue
                    if (fireDist[nx][ny] != -1 && fireDist[nx][ny] <= personDist[cur.x][cur.y] + 1) continue

                    personDist[nx][ny] = personDist[cur.x][cur.y] + 1
                    personQueue.addLast(Node(nx, ny))
                }
            }

            close()
            return "IMPOSSIBLE"
        }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`4179`().solution())

        flush()
        close()
    }
