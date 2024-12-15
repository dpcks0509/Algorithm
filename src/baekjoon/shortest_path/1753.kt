package baekjoon.shortest_path

import java.util.PriorityQueue

fun main() {
    data class Path(
        val v: Int,
        val w: Int,
    )

    val INF = 1_000_000_000

    val (n, e) = readln().split(" ").map { it.toInt() }
    val k = readln().toInt()

    val graph = Array(n + 1) { mutableListOf<Path>() }
    val dist = IntArray(n + 1) { INF }
    val pq = PriorityQueue<Path>(compareBy { it.w })

    for (i in 0 until e) {
        val (u, v, w) = readln().split(" ").map { it.toInt() }
        graph[u].add(Path(v, w))
    }

    dist[k] = 0
    pq.add(Path(k, 0))

    while (pq.isNotEmpty()) {
        val current = pq.remove()

        if (current.w > dist[current.v]) continue

        for (next in graph[current.v]) {
            if (dist[next.v] > current.w + next.w) {
                dist[next.v] = current.w + next.w
                pq.add(Path(next.v, dist[next.v]))
            }
        }
    }

    for (i in 1..n) {
        if (dist[i] != INF) {
            println(dist[i])
        } else {
            println("INF")
        }
    }
}
