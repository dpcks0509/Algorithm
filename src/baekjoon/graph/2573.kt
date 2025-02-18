package baekjoon.graph

fun main() {
    data class Node(val x: Int, val y: Int)

    val dx = listOf(-1, 1, 0, 0)
    val dy = listOf(0, 0, -1, 1)

    val br = System.`in`.bufferedReader()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val board = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }

    var year = 0

    while (true) {
        val visited = Array(n) { BooleanArray(m) }
        val deque = ArrayDeque<Node>()
        var glacier = 0

        // 빙하 개수 세기
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (board[i][j] == 0) continue
                if (visited[i][j]) continue

                glacier++

                deque.add(Node(i, j))
                visited[i][j] = true

                while (deque.isNotEmpty()) {
                    val (cx, cy) = deque.removeFirst()

                    for (k in 0 until 4) {
                        val nx = cx + dx[k]
                        val ny = cy + dy[k]

                        if (nx !in 0 until n || ny !in 0 until m) continue
                        if (board[nx][ny] == 0) continue
                        if (visited[nx][ny]) continue

                        deque.add(Node(nx, ny))
                        visited[nx][ny] = true
                    }
                }
            }
        }

        if (glacier == 0) {
            println(0)
            break
        }

        if (glacier >= 2) {
            println(year)
            break
        }

        // 빙하 녹이기
        val tmp = Array(n) { IntArray(m) }
        for (i in 0 until n) {
            for (j in 0 until m) {
                tmp[i][j] = board[i][j]
            }
        }

        for (i in 0 until n) {
            for (j in 0 until m) {
                if (board[i][j] == 0) continue

                for (k in 0 until 4) {
                    val nx = i + dx[k]
                    val ny = j + dy[k]

                    if (nx !in 0 until n || ny !in 0 until m) continue
                    if (board[nx][ny] == 0 && tmp[i][j] > 0) {
                        tmp[i][j]--
                    }
                }
            }
        }

        for (i in 0 until n) {
            for (j in 0 until m) {
                board[i][j] = tmp[i][j]
            }
        }
        year++
    }
}