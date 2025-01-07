package baekjoon.brute_force

import java.util.PriorityQueue

fun main() {
    data class Node(val x: Int, val y: Int)

    val dx = listOf(1, 1, 1)
    val dy = listOf(-1, 0, 1)

    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val board = Array(n) { IntArray(m) }
    repeat(n) { x ->
        val input = br.readLine().split(" ").map { it.toInt() }
        repeat(m) { y ->
            board[x][y] = input[y]
        }
    }

    val visited = Array(n) { Array(m) { BooleanArray(3) } }
    val pq = PriorityQueue<Triple<Node, Int, Int>>(compareBy { it.second })

    repeat(m) {
        pq.add(Triple(Node(0, it), board[0][it], -1))
    }

    while (pq.isNotEmpty()) {
        val cur = pq.remove()

        if (cur.first.x == n - 1) {
            bw.write("${cur.second}")
            bw.flush()
            bw.close()
            br.close()

            return
        }

        for (i in 0 until 3) {
            if (cur.third == i) continue

            val nx = cur.first.x + dx[i]
            val ny = cur.first.y + dy[i]

            if (nx !in 0 until n || ny !in 0 until m) continue
            if (visited[nx][ny][i]) continue

            pq.add(Triple(Node(nx, ny), cur.second + board[nx][ny], i))
            visited[nx][ny][i] = true
        }
    }
}