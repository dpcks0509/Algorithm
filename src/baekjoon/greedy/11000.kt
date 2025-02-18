package baekjoon.greedy

import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    val time = Array(n) {
        val (start, end) = br.readLine().split(" ").map { it.toInt() }
        start to end
    }
    time.sortWith(compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second })

    val pq = PriorityQueue<Int>()
    pq.add(time[0].second)

    for (i in 1 until n) {
        if (pq.peek() <= time[i].first) {
            pq.remove()
        }

        pq.add(time[i].second)
    }

    println(pq.size)
}