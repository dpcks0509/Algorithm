package baekjoon.graph

class `11724` {
    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            val answer = StringBuilder()

            val (n, m) = readLine().split(' ').map { it.toInt() }
            val graph = Array(n + 1) { ArrayList<Int>() }
            repeat(m) {
                val (v1, v2) = readLine().split(' ').map { it.toInt() }
                graph[v1].add(v2)
                graph[v2].add(v1)
            }

            val visited = Array(n + 1) { false }
            var count = 0

            fun dfs(i: Int) {
                visited[i] = true
                for (v in graph[i]) {
                    if (!visited[v]) {
                        dfs(v)
                    }
                }
            }

            for (i in 1..n) {
                if (!visited[i]) {
                    dfs(i)
                    count++
                }
            }

            answer.append("$count")

            close()
            return answer.toString()
        }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`11724`().solution())

        flush()
        close()
    }
