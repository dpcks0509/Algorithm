package baekjoon.greedy

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    val lines = Array(n) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        x to y
    }
    lines.sortWith(compareBy<Pair<Int, Int>> { it.first }.thenByDescending { it.second })

    var (start, end) = lines[0]
    var sum = 0

    for (i in 1 until n) {
        val (x, y) = lines[i]

        if (x <= end) {
            end = maxOf(y, end)
        } else {
            sum += end - start
            start = x
            end = y
        }
    }
    sum += end - start

    println(sum)
}