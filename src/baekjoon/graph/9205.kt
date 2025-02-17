package baekjoon.graph

import java.util.ArrayDeque
import kotlin.math.abs

fun main() {
    val br = System.`in`.bufferedReader()

    val t = br.readLine().toInt()

    repeat(t) {
        val n = br.readLine().toInt()

        val (sx, sy) = br.readLine().split(" ").map { it.toInt() }
        val stores = Array(n) { br.readLine().split(" ").map { it.toInt() } }
        val (ex, ey) = br.readLine().split(" ").map { it.toInt() }

        val visited = BooleanArray(n)
        val deque = ArrayDeque<Pair<Int, Int>>()
        deque.add(sx to sy)

        var canGo = false
        while (deque.isNotEmpty()) {
            val current = deque.removeFirst()

            if (abs(current.first - ex) + abs(current.second - ey) <= 1000) {
                canGo = true
                break
            }

            for (i in 0 until n) {
                if (visited[i]) continue

                if (abs(current.first - stores[i][0]) + abs(current.second - stores[i][1]) <= 1000) {
                    deque.add(stores[i][0] to stores[i][1])
                    visited[i] = true
                }
            }
        }

        if (canGo) println("happy") else println("sad")
    }
}