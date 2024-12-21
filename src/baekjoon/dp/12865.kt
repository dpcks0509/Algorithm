package baekjoon.dp

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }

    val w = IntArray(n + 1) { 0 }
    val v = IntArray(n + 1) { 0 }
    val dp = Array(n + 1) { IntArray(k + 1) }

    for (i in 1..n) {
        val (weight, value) = readln().split(" ").map { it.toInt() }
        w[i] = weight
        v[i] = value
    }

    for (i in 1..n) {
        for (j in 1..k) {
            if (w[i] > j) {
                dp[i][j] = dp[i - 1][j]
            } else {
                dp[i][j] = maxOf(dp[i - 1][j], v[i] + dp[i - 1][j - w[i]])
            }
        }
    }

    println(dp[n][k])
}
