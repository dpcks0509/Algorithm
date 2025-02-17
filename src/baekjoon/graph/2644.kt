package baekjoon.graph

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    val (a, b) = br.readLine().split(" ").map { it.toInt() }
    val m = br.readLine().toInt()

    val relation = Array(n + 1) { ArrayList<Int>() }
    for (i in 0 until m) {
        val (parent, child) = br.readLine().split(" ").map { it.toInt() }
        relation[parent].add(child)
        relation[child].add(parent)
    }

    val visited = IntArray(n + 1) { Int.MAX_VALUE }
    val deque = ArrayDeque<Int>()

    deque.add(a)
    visited[a] = 0

    while (deque.isNotEmpty()) {
        val current = deque.removeFirst()

        if (current == b) {
            println(visited[b])
            return
        }

        for (people in relation[current]) {
            if (visited[current] + 1 < visited[people]) {
                deque.add(people)
                visited[people] = visited[current] + 1
            }
        }
    }

    println(-1)
}