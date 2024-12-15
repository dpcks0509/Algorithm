package baekjoon.graph

fun main() {
    val n = readln().toInt()
    val graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }

    // floyd-warshall
    for(k in 0 until n) {
        for(i in 0 until n) {
            for(j in 0 until n) {
                if(graph[i][k] == 1 && graph[k][j] == 1) graph[i][j] = 1
            }
        }
    }

    graph.forEach {
        println(it.joinToString(" "))
    }

    // bfs
//    val answer = Array(n) { IntArray(n) }
//    for (i in 0 until n) {
//        val queue = ArrayDeque<Int>()
//        for (j in 0 until n) {
//            val visited = BooleanArray(n)
//
//            if (graph[i][j] == 1) {
//                queue.add(j)
//                answer[i][j] = 1
//                visited[j] = true
//
//                while (queue.isNotEmpty()) {
//                    val v = queue.removeFirst()
//
//                    for (k in 0 until n) {
//                        if (graph[v][k] == 1) {
//                            if (visited[k]) continue
//
//                            queue.add(k)
//                            answer[i][k] = 1
//                            visited[k] = true
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    answer.forEach {
//        println(it.joinToString(" "))
//    }
}
