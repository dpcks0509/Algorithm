package baekjoon.shortest_path

import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val n = br.readLine().toInt()
    val m = br.readLine().toInt()

    val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    for (i in 0 until m) {
        val (start, end, cost) = br.readLine().split(' ').map { it.toInt() }
        graph[start].add(Pair(end, cost))
    }

    val (origin, destination) = br.readLine().split(' ').map { it.toInt() }

    val costs = Array(n + 1) { Int.MAX_VALUE }
    val priorityQueue = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })

    costs[origin] = 0
    priorityQueue.add(Pair(origin, 0))

    while (priorityQueue.isNotEmpty()) {
        val (currentNode, currentCost) = priorityQueue.remove()
        if (currentCost >= costs[destination]) break

        graph[currentNode].forEach { (nextNode, nextCost) ->
            val sumCost = currentCost + nextCost

            if (sumCost < costs[nextNode]) {
                costs[nextNode] = sumCost
                priorityQueue.add(Pair(nextNode, sumCost))
            }
        }
    }

    bw.write("${costs[destination]}")
    bw.flush()
}
