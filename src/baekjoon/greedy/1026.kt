package baekjoon.greedy

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    val a = br.readLine().split(" ").map { it.toInt() }.sorted()
    val b = br.readLine().split(" ").map { it.toInt() }.sortedDescending()

    var sum = 0
    for (i in 0 until n) {
        sum += a[i] * b[i]
    }

    println(sum)
}