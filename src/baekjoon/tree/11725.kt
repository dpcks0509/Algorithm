package baekjoon.tree

fun main() {
    val n = readln().toInt()

    val tree = Array(n + 1) { mutableListOf<Int>() }
    for (i in 0 until n - 1) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        tree[a].add(b)
        tree[b].add(a)
    }

    val parent = IntArray(n + 1)

    fun bfs() {
        val queue = ArrayDeque<Int>()
        val visited = BooleanArray(n + 1)

        queue.add(1)
        visited[1] = true

        while (queue.isNotEmpty()) {
            val cur = queue.removeFirst()

            for (i in tree[cur]) {
                if (visited[i]) continue

                parent[i] = cur

                queue.add(i)
                visited[i] = true
            }
        }
    }

    bfs()

    for (i in 2..n) {
        println("${parent[i]}")
    }
}
