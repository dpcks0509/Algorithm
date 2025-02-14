package baekjoon.graph

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()

    data class Node(val x: Int, val y: Int)

    val dx = listOf(-2, -1, 1, 2, 2, 1, -1, -2)
    val dy = listOf(1, 2, 2, 1, -1, -2, -2, -1)

    for (i in 0 until n) {
        val size = br.readLine().toInt()
        val (cx, cy) = br.readLine().split(" ").map { it.toInt() }
        val (tx, ty) = br.readLine().split(" ").map { it.toInt() }

        val visited = Array(size) { IntArray(size) { -1 } }
        val deque = ArrayDeque<Node>()

        deque.add(Node(cx, cy))
        visited[cx][cy] = 0

        while (deque.isNotEmpty()) {
            val current = deque.removeFirst()

            if (current.x == tx && current.y == ty) {
                println(visited[current.x][current.y])
                break
            }

            for (j in 0 until 8) {
                val nx = current.x + dx[j]
                val ny = current.y + dy[j]

                if (nx !in 0 until size || ny !in 0 until size) continue
                if (visited[nx][ny] >= 0) continue

                deque.add(Node(nx, ny))
                visited[nx][ny] = visited[current.x][current.y] + 1
            }
        }
    }
}