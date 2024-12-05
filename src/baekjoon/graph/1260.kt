package baekjoon.graph

class `1260` {
    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            val answer = StringBuilder()

            val (n, m, v) = readLine().split(' ').map { it.toInt() }
            val graph = Array(n + 1) { Array(n + 1) { false } }
            repeat(m) {
                val (v1, v2) = readLine().split(' ').map { it.toInt() }
                graph[v1][v2] = true
                graph[v2][v1] = true
            }

            val visited = mutableListOf<Int>()

            // DFS
            fun dfs(current: Int) {
                visited.add(current)
                for (i in 1..n) {
                    if (graph[current][i] && !visited.contains(i)) {
                        dfs(i)
                    }
                }
            }

            dfs(v)
            answer.appendLine(visited.joinToString(" "))

            visited.clear()

            // BFS
            val deque = ArrayDeque<Int>()
            deque.add(v)
            visited.add(v)
            while (deque.isNotEmpty()) {
                val current = deque.removeFirst()
                for (i in 1..n) {
                    if (graph[current][i] && !visited.contains(i)) {
                        deque.add(i)
                        visited.add(i)
                    }
                }
            }
            answer.appendLine(visited.joinToString(" "))

            close()
            return answer.toString()
        }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`1260`().solution())

        flush()
        close()
    }
