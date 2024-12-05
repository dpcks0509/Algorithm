package baekjoon.graph

class `14940` {
    data class Node(
        val x: Int,
        val y: Int,
    )

    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            val answer = StringBuilder()

            val (n, m) = readLine().split(' ').map { it.toInt() }

            val deque = ArrayDeque<Node>()
            val distances = Array(n) { Array(m) { -1 } }

            val board =
                Array(n) { x ->
                    val input = readLine().split(' ').map { it.toInt() }
                    Array(m) { y ->
                        when (input[y]) {
                            0 -> distances[x][y] = 0
                            2 -> {
                                deque.add(Node(x, y))
                                distances[x][y] = 0
                            }
                        }
                        input[y]
                    }
                }

            val dx = listOf(1, 0, -1, 0)
            val dy = listOf(0, 1, 0, -1)

            while (deque.isNotEmpty()) {
                val current = deque.removeFirst()
                for (i in 0 until 4) {
                    val next = Node(current.x + dx[i], current.y + dy[i])

                    if (next.x < 0 || next.x >= n || next.y < 0 || next.y >= m) continue
                    if (distances[next.x][next.y] != -1) continue

                    if (board[next.x][next.y] == 1) {
                        distances[next.x][next.y] = distances[current.x][current.y] + 1
                        deque.add(next)
                    }
                }
            }

            distances.forEach {
                answer.appendLine(it.joinToString(" "))
            }

            close()
            return answer.toString()
        }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`14940`().solution())

        flush()
        close()
    }
