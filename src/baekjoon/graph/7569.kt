package baekjoon.graph

fun main() {
    data class Node(
        val x: Int,
        val y: Int,
        val z: Int,
    )

    val dx = listOf(1, -1, 0, 0, 0, 0)
    val dy = listOf(0, 0, 0, 0, 1, -1)
    val dz = listOf(0, 0, -1, 1, 0, 0)

    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val (m, n, h) = br.readLine().split(' ').map { it.toInt() }

    val deque = ArrayDeque<Node>()
    val board = Array(h) { Array(n) { Array(m) { 0 } } }

    val visited = Array(h) { Array(n) { Array(m) { false } } }

    for (i in 0 until h) {
        for (j in 0 until n) {
            val input = br.readLine().split(' ').map { it.toInt() }
            for (k in 0 until m) {
                board[i][j][k] = input[k]
                if (input[k] == 1) {
                    deque.add(Node(i, j, k))
                    visited[i][j][k] = true
                }
            }
        }
    }

    var day = -1
    while (deque.isNotEmpty()) {
        day++

        for (i in 0 until deque.size) {
            val current = deque.removeFirst()

            for (j in 0 until 6) {
                val next = Node(current.x + dx[j], current.y + dy[j], current.z + dz[j])

                if (next.x !in 0 until h || next.y !in 0 until n || next.z !in 0 until m) continue
                if (visited[next.x][next.y][next.z]) continue

                if (board[next.x][next.y][next.z] == 0) {
                    deque.add(next)
                    visited[next.x][next.y][next.z] = true
                    board[next.x][next.y][next.z] = 1
                }
            }
        }
    }

    for (i in 0 until h) {
        for (j in 0 until n) {
            for (k in 0 until m) {
                if (board[i][j][k] == 0) {
                    bw.write("-1")
                    bw.flush()
                    return
                }
            }
        }
    }

    bw.write("$day")
    bw.flush()
}
