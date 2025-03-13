package baekjoon.brute_force

fun main() {
    val br = System.`in`.bufferedReader()

    val (n, d, k, c) = br.readLine().split(" ").map { it.toInt() }
    val sushis = Array(n) { br.readLine().toInt() }

    var max = 0
    val eat = mutableSetOf<Int>()

    for (i in 0 until n) {
        for (j in 0 until k) {
            val index = (i + j) % n

            eat.add(sushis[index])
        }
        eat.add(c)
        max = maxOf(max, eat.size)
        eat.clear()
    }

    println(max)
}