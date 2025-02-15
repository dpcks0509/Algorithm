package baekjoon.sort

fun main() {
    val br = System.`in`.bufferedReader()

    val (n, c) = br.readLine().split(" ").map { it.toInt() }
    val list = br.readLine().split(" ").map { it.toInt() }

    val freqMap = hashMapOf<Int, Int>()
    val orderMap = hashMapOf<Int, Int>()

    for (i in 0 until n) {
        freqMap[list[i]] = freqMap.getOrDefault(list[i], 0) + 1
        orderMap.putIfAbsent(list[i], i)
    }

    val sorted = list.sortedWith(compareByDescending<Int> { freqMap[it] }.thenBy { orderMap[it] })
    println(sorted.joinToString(" "))
}