package baekjoon.shortest_path

import java.util.PriorityQueue

fun main() {
    data class Node(val location: Int, val distance: Int)

    val (n, m, x) = readln().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Node>() }

    repeat(m) {
        val (start, end, distance) = readln().split(" ").map { it.toInt() }
        graph[start].add(Node(end, distance))
    }

    fun dijkstra(s: Int, e: Int, graph: Array<MutableList<Node>>): Int {
        val distances = IntArray(n + 1) { Int.MAX_VALUE }
        val pq = PriorityQueue<Node>(compareBy { it.distance })

        distances[s] = 0
        pq.add(Node(s, 0))

        while (pq.isNotEmpty()) {
            val current = pq.remove()

            if (current.location == e) break

            for (next in graph[current.location]) {
                val newDist = distances[current.location] + next.distance

                if (newDist < distances[next.location]) {
                    distances[next.location] = newDist
                    pq.add(Node(next.location, newDist))
                }
            }
        }

        return distances[e]
    }

    var maxDistance = 0
    for (i in 1..n) {
        val go = dijkstra(i, x, graph)
        val back = dijkstra(x, i, graph)

        if (back != Int.MAX_VALUE && go != Int.MAX_VALUE) {
            maxDistance = maxOf(maxDistance, go + back)
        }
    }

    println(maxDistance)
}
