package baekjoon.graph

fun main() {
    val br = System.`in`.bufferedReader()

    data class Node(val x: Int, val y: Int, val z: Int, val time: Int)

    val dx = listOf(0, 0, 0, 0, -1, 1)
    val dy = listOf(0, 0, 1, -1, 0, 0)
    val dz = listOf(1, -1, 0, 0, 0, 0)

    while (true) {
        val (L, R, C) = br.readLine().split(" ").map { it.toInt() }

        if (L == 0 && R == 0 && C == 0) return

        val building = Array(L) { Array(R) { CharArray(C) } }
        var start = Node(0, 0, 0, 0)

        for (i in 0 until L) {
            for (j in 0..R) {
                if (j == R) {
                    br.readLine()
                    continue
                }

                val floor = br.readLine().toCharArray()
                for (k in 0 until C) {
                    if (floor[k] == 'S') start = Node(i, j, k, 0)

                    building[i][j][k] = floor[k]
                }
            }
        }

        val time = Array(L) { Array(R) { IntArray(C) { Int.MAX_VALUE } } }
        val deque = ArrayDeque<Node>()
        var canArrive = false

        deque.add(start)
        time[start.x][start.y][start.y] = 0

        while (deque.isNotEmpty()) {
            val (cx, cy, cz, cTime) = deque.removeFirst()

            if (building[cx][cy][cz] == 'E') {
                println("Escaped in ${time[cx][cy][cz]} minute(s).")
                canArrive = true
                break
            }

            for (i in 0 until 6) {
                val nx = cx + dx[i]
                val ny = cy + dy[i]
                val nz = cz + dz[i]
                val nTime = cTime + 1

                if (nx !in 0 until L || ny !in 0 until R || nz !in 0 until C) continue
                if (nTime >= time[nx][ny][nz]) continue
                if (building[nx][ny][nz] == '#') continue
                deque.add(Node(nx, ny, nz, nTime))
                time[nx][ny][nz] = nTime
            }
        }

        if (!canArrive) println("Trapped!")
    }
}