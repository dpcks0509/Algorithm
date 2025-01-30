package baekjoon.back_tracking

import kotlin.math.abs
import kotlin.math.min

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val houses = mutableListOf<Pair<Int, Int>>()
    val chickens = mutableListOf<Pair<Int, Int>>()

    for (x in 0 until n) {
        val input = br.readLine().split(" ").map { it.toInt() }
        for (y in 0 until n) {
            when (input[y]) {
                1 -> houses.add(x to y)
                2 -> chickens.add(x to y)
            }
        }
    }

    var minCityDistance = Int.MAX_VALUE
    val selected = mutableListOf<Int>()

    fun totalDistance(): Int {
        var totalDistance = 0

        for (house in houses) {
            var minDistance = Int.MAX_VALUE
            for (index in selected) {
                val chicken = chickens[index]
                val distance = abs(house.first - chicken.first) + abs(house.second - chicken.second)
                minDistance = min(minDistance, distance)
            }
            totalDistance += minDistance
        }

        return totalDistance
    }

    fun backTracking(index: Int) {
        if (selected.size == m) {
            minCityDistance = min(minCityDistance, totalDistance())
            return
        }

        for (i in index until chickens.size) {
            selected.add(i)
            backTracking(i + 1)
            selected.removeLast()
        }
    }

    backTracking(0)

    println(minCityDistance)
}
