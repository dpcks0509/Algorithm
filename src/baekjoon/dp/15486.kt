package baekjoon.dp

fun main() {
    data class Counsel(val t: Int, val p: Int)

    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    val counsels = Array(n) {
        val (t, p) = br.readLine().split(" ").map { it.toInt() }
        Counsel(t, p)
    }

    val dp = IntArray(n + 1)

    for (i in 0 until n) {
        val (t, p) = counsels[i]
        if (i + t <= n) {
            dp[i + t] = maxOf(dp[i + t], dp[i] + p)
        }

        dp[i + 1] = maxOf(dp[i + 1], dp[i])
    }

    println(dp[n])
}
