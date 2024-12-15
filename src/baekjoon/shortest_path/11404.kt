package baekjoon.shortest_path

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()

    val INF = 1_000_000_000
    val dist = Array(n) { IntArray(n) { INF } }
    for (i in 0 until n) {
        dist[i][i] = 0
    }

    for (i in 0 until m) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        dist[a - 1][b - 1] = minOf(dist[a - 1][b - 1], c)
    }

    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                dist[i][j] = minOf(dist[i][j], dist[i][k] + dist[k][j])
            }
        }
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (dist[i][j] == INF) dist[i][j] = 0
        }
    }

    dist.forEach {
        println(it.joinToString(" "))
    }
}
