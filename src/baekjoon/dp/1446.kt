package baekjoon.dp

fun main() {
    data class Shortcut(val start: Int, val end: Int, val length: Int)

    val br = System.`in`.bufferedReader()
    val (n, d) = br.readLine().split(" ").map { it.toInt() }
    val shortcuts = Array(n) {
        val (start, end, length) = br.readLine().split(" ").map { it.toInt() }
        Shortcut(start, end, length)
    }
    shortcuts.sortWith(compareBy<Shortcut> { it.start }.thenBy { it.end }.thenBy { it.length })

    val dp = IntArray(d + 1) { it }
    for (i in 0 until n) {
        val (s, e, l) = shortcuts[i]

        if (s > d || e > d) continue
        dp[e] = minOf(dp[e], dp[s] + l)

        for (j in s..d) {
            if(j <= 0) continue
            dp[j] = minOf(dp[j], dp[j - 1] + 1)
        }
    }

    println(dp[d])
}