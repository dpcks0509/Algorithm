package baekjoon.implementation

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val board = Array(n) { br.readLine().split(" ").map { it.toInt() } }

    val visited = Array(n) { Array(m) { false } }
    var max = 0

    val dx = listOf(1, -1, 0, 0)
    val dy = listOf(0, 0, -1, 1)

    fun dfs(
        depth: Int,
        sum: Int,
        x: Int,
        y: Int,
    ) {
        if (depth == 4) {
            max = maxOf(max, sum)
            return
        }

        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx !in 0 until n || ny !in 0 until m) continue
            if (visited[nx][ny]) continue

            visited[nx][ny] = true
            dfs(depth + 1, sum + board[nx][ny], nx, ny)
            visited[nx][ny] = false
        }
    }

    fun remain(
        x: Int,
        y: Int,
    ) {
        if (x + 2 < n) {
            val sum = board[x][y] + board[x + 1][y] + board[x + 2][y]
            // 'ㅏ'
            if (y + 1 < m) {
                max = maxOf(max, sum + board[x + 1][y + 1])
            }
            // 'ㅓ'
            if (y - 1 >= 0) {
                max = maxOf(max, sum + board[x + 1][y - 1])
            }
        }

        if (y + 2 < m) {
            val sum = board[x][y] + board[x][y + 1] + board[x][y + 2]
            // 'ㅜ'
            if (x + 1 < n) {
                max = maxOf(max, sum + board[x + 1][y + 1])
            }
            // 'ㅗ'
            if (x - 1 >= 0) {
                max = maxOf(max, sum + board[x - 1][y + 1])
            }
        }
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            visited[i][j] = true
            dfs(1, board[i][j], i, j)
            visited[i][j] = false

            remain(i, j)
        }
    }

    bw.write("$max")
    bw.flush()
}
