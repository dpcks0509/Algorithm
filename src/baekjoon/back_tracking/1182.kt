package baekjoon.back_tracking

fun main() {
    val br = System.`in`.bufferedReader()

    val (n, s) = br.readLine().split(" ").map { it.toInt() }
    val list = br.readLine().split(" ").map { it.toInt() }

    var cnt = 0

    fun recur(index: Int, sum: Int) {
        if (index == n) return

        val newSum = sum + list[index]
        if (newSum == s) cnt++

        recur(index + 1, newSum)
        recur(index + 1, sum)
    }

    recur(0, 0)

    println(cnt)
}