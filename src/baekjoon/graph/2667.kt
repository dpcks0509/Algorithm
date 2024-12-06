package baekjoon.graph

fun main() {
    data class Node(
        val x: Int,
        val y: Int,
    )

    val dx = listOf(1, -1, 0, 0)
    val dy = listOf(0, 0, -1, 1)

    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val n = br.readLine().toInt()
    val board = Array(n) { br.readLine().toCharArray() }

    val visited = Array(n) { Array(n) { false } }
    val deque = ArrayDeque<Node>()

    val list = mutableListOf<Int>()

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (visited[i][j] || board[i][j] == '0') continue

            visited[i][j] = true
            deque.add(Node(i, j))

            var cnt = 1
            while (deque.isNotEmpty()) {
                val node = deque.removeFirst()

                for (k in 0 until 4) {
                    val nx = node.x + dx[k]
                    val ny = node.y + dy[k]

                    if (nx !in 0 until n || ny !in 0 until n) continue
                    if (visited[nx][ny] || board[nx][ny] == '0') continue

                    visited[nx][ny] = true
                    deque.add(Node(nx, ny))
                    cnt++
                }
            }
            list.add(cnt)
        }
    }

    bw.write("${list.size}\n")
    bw.write(list.sorted().joinToString("\n"))
    bw.flush()
}
