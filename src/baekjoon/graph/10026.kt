package baekjoon.graph

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val n = br.readLine().toInt()
    val board = Array(n) { br.readLine().toCharArray() }

//    data class Node(
//        val x: Int,
//        val y: Int,
//    )

    val dx = listOf(1, -1, 0, 0)
    val dy = listOf(0, 0, -1, 1)

//    fun bfs(): Int {
//        val deque = ArrayDeque<Node>()
//        val visited = Array(n) { Array(n) { false } }
//        var cnt = 0
//
//        for (i in 0 until n) {
//            for (j in 0 until n) {
//                if (visited[i][j]) continue
//                cnt++
//
//                deque.add(Node(i, j))
//                visited[i][j] = true
//
//                while (deque.isNotEmpty()) {
//                    val current = deque.removeFirst()
//
//                    for (k in 0 until 4) {
//                        val nx = current.x + dx[k]
//                        val ny = current.y + dy[k]
//
//                        if (nx !in 0 until n || ny !in 0 until n) continue
//                        if (visited[nx][ny]) continue
//
//                        if (board[current.x][current.y] == board[nx][ny]) {
//                            deque.add(Node(nx, ny))
//                            visited[nx][ny] = true
//                        }
//                    }
//                }
//            }
//        }
//        return cnt
//    }

    fun dfs(): Int {
        val visited = Array(n) { Array(n) { false } }
        var cnt = 0

        fun recur(
            x: Int,
            y: Int,
        ) {
            visited[x][y] = true

            for (k in 0 until 4) {
                val nx = x + dx[k]
                val ny = y + dy[k]

                if (nx !in 0 until n || ny !in 0 until n) continue
                if (visited[nx][ny]) continue

                if (board[nx][ny] == board[x][y]) {
                    recur(nx, ny)
                }
            }
        }

        for (i in 0 until n) {
            for (j in 0 until n) {
                if (visited[i][j]) continue
                cnt++

                recur(i, j)
            }
        }

        return cnt
    }

    val noCnt = dfs()

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (board[i][j] == 'G') board[i][j] = 'R'
        }
    }

    val yesCnt = dfs()

    bw.write("$noCnt $yesCnt")
    bw.flush()
}
