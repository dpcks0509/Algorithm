package baekjoon.greedy

fun main() {
    val n = readln().toInt()
    val arr = Array(n) { readln().toInt() }.sorted()

    var max = 0
    for (i in 0 until n) {
        max = maxOf(max, arr[i] * (n - i))
    }

    println(max)
}
