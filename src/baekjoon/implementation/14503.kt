package baekjoon.implementation

fun main() {
    data class Node(val x: Int, val y: Int, val d: Int) // d =  0 -> 북, 1 -> 동, 2 -> 남, 3 -> 서

    val dx = listOf(-1, 0, 1, 0)
    val dy = listOf(0, 1, 0, -1)

    val br = System.`in`.bufferedReader()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val (r, c, d) = br.readLine().split(" ").map { it.toInt() }
    val board = Array(n) { br.readLine().split(" ").map { it.toInt() } }

    val visited = Array(n) { BooleanArray(m) }
    var cnt = 0
    var current = Node(r, c, d)

    while (true) {
        if (!visited[current.x][current.y] && board[current.x][current.y] == 0) {
            cnt++
            visited[current.x][current.y] = true
        }

        var canMove = false
        for (i in 0 until 4) {
            val nx = current.x + dx[i]
            val ny = current.y + dy[i]

            if (nx !in 0 until n || ny !in 0 until m) continue
            if (visited[nx][ny]) continue
            if (board[nx][ny] == 1) continue

            canMove = true
            break
        }

        if (!canMove) {
            val nx = current.x - dx[current.d]
            val ny = current.y - dy[current.d]

            if (nx !in 0 until n || ny !in 0 until m) continue
            if (board[nx][ny] == 1) {
                println(cnt)
                return
            }

            current = Node(nx, ny, current.d)
        } else {
            var nd = current.d

            for (i in 0 until 4) {
                nd = if (nd == 0) 3 else nd - 1
                val nx = current.x + dx[nd]
                val ny = current.y + dy[nd]

                if (nx !in 0 until n || ny !in 0 until m) continue
                if (visited[nx][ny]) continue
                if (board[nx][ny] == 1) continue

                current = Node(nx, ny, nd)
                break
            }
        }
    }
}