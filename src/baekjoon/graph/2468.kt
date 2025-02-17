package baekjoon.graph

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    val height = Array(n) { br.readLine().split(" ").map { it.toInt() } }

    data class Node(val x: Int, val y: Int)

    val dx = listOf(-1, 1, 0, 0)
    val dy = listOf(0, 0, -1, 1)

    val maxHeight = height.maxOf { it.max() }
    var maxArea = 1

    for (rain in 1 until maxHeight) {
        val visited = Array(n) { BooleanArray(n) }
        val deque = ArrayDeque<Node>()
        var area = 0

        for (i in 0 until n) {
            for (j in 0 until n) {
                if (height[i][j] <= rain) continue
                if (visited[i][j]) continue

                deque.add(Node(i, j))
                area++

                while (deque.isNotEmpty()) {
                    val (cx, cy) = deque.removeFirst()

                    if (height[cx][cy] <= rain) continue

                    for (k in 0 until 4) {
                        val nx = cx + dx[k]
                        val ny = cy + dy[k]

                        if (nx !in 0 until n || ny !in 0 until n) continue
                        if (visited[nx][ny]) continue

                        deque.add(Node(nx, ny))
                        visited[nx][ny] = true
                    }
                }

                maxArea = maxOf(maxArea, area)
            }
        }
    }

    println(maxArea)
}