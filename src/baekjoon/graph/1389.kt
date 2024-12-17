package baekjoon.graph

fun main() {
//    val (n, m) = readln().split(" ").map { it.toInt() }
//    val distances = Array(n + 1) { IntArray(n + 1) { Int.MAX_VALUE } }
//
//    for (i in 1..n) {
//        distances[i][i] = 0
//    }
//
//    repeat(m) {
//        val (a, b) = readln().split(" ").map { it.toInt() }
//        distances[a][b] = 1
//        distances[b][a] = 1
//    }
//
//    // 플로이드 워셜 알고리즘
//    for (k in 1..n) {
//        for (i in 1..n) {
//            for (j in 1..n) {
//                if (distances[i][k] != Int.MAX_VALUE && distances[k][j] != Int.MAX_VALUE) {
//                    distances[i][j] = minOf(distances[i][j], distances[i][k] + distances[k][j])
//                }
//            }
//        }
//    }
//
//    val answer = (1..n).minBy { distances[it].sum() }
//    println(answer)

    // bfs
    val (n, m) = readln().split(" ").map { it.toInt() }
    val board = Array(n + 1) { mutableListOf<Int>() }

    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        board[a].add(b)
        board[b].add(a)
    }

    var min = Int.MAX_VALUE
    var index = 0

    for (i in 1..n) {
        val visited = BooleanArray(n + 1)
        val distances = IntArray(n + 1)
        val queue = ArrayDeque<Int>()

        queue.add(i)
        visited[i] = true

        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()

            for (next in board[current]) {
                if(visited[next]) continue

                visited[next] = true
                distances[next] = distances[current] + 1
                queue.add(next)
            }
        }

        val sum = distances.sum()
        if (sum < min) {
            min = sum
            index = i
        }
    }

    println(index)
}
