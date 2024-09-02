package barking_dog.bfs

class `1926` {
    data class Node(
        val x: Int,
        val y: Int,
    )

    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            val answer = StringBuilder()

            val (n, m) = readLine().split(' ').map { it.toInt() }
            val graph = Array(n) { readLine().split(' ').map { it.toInt() }.toIntArray() }
            val visited = Array(n) { Array(m) { false } }
            val queue = ArrayDeque<Node>()
            val dx = listOf(-1, 0, 1, 0)
            val dy = listOf(0, 1, 0, -1)

            fun bfs(node: Node): Int {
                queue.addLast(node)
                visited[node.x][node.y] = true
                var cnt = 1

                while (queue.isNotEmpty()) {
                    val cur = queue.removeFirst()
                    for (i in 0 until 4) {
                        val nx = cur.x + dx[i]
                        val ny = cur.y + dy[i]
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue
                        if (graph[nx][ny] == 1 && !visited[nx][ny]) {
                            cnt++
                            visited[nx][ny] = true
                            queue.addLast(Node(nx, ny))
                        }
                    }
                }
                return cnt
            }

            val list = mutableListOf<Int>()

            for (i in 0 until n) {
                for (j in 0 until m) {
                    if (graph[i][j] == 1 && !visited[i][j]) {
                        list.add(bfs(Node(i, j)))
                    }
                }
            }

            answer.append("${list.size}\n")
            answer.append("${list.maxOrNull() ?: 0}\n")

            close()
            return answer.toString()
        }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`1926`().solution())

        flush()
        close()
    }
