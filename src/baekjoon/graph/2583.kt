package baekjoon.graph

fun main() {
    val br = System.`in`.bufferedReader()

    val (m, n, k) = br.readLine().split(" ").map { it.toInt() }

    val visited = Array(m) { BooleanArray(n) }
    for (i in 0 until k) {
        val (lx, ly, rx, ry) = br.readLine().split(" ").map { it.toInt() }
        for (r in ly until ry) {
            for (c in lx until rx) {
                visited[r][c] = true
            }
        }
    }

    data class Node(val x: Int, val y: Int)

    val dx = listOf(-1, 1, 0, 0)
    val dy = listOf(0, 0, -1, 1)

    val answer = mutableListOf<Int>()
    val deque = ArrayDeque<Node>()

    for (x in 0 until m) {
        for (y in 0 until n) {
            if (visited[x][y]) continue

            deque.add(Node(x, y))
            visited[x][y] = true

            var area = 0
            while (deque.isNotEmpty()) {
                val (cx, cy) = deque.removeFirst()
                area++

                for (i in 0 until 4) {
                    val nx = cx + dx[i]
                    val ny = cy + dy[i]

                    if (nx !in 0 until m || ny !in 0 until n) continue
                    if (visited[nx][ny]) continue

                    deque.add(Node(nx, ny))
                    visited[nx][ny] = true
                }
            }

            answer.add(area)
        }
    }

    answer.sort()
    println(answer.size)
    println(answer.joinToString(" "))
}