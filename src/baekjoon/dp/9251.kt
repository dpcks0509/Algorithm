package baekjoon.dp

fun main() {
    val first = readln()
    val second = readln()

    val dp = Array(first.length + 1) { IntArray(second.length + 1) }

    for (i in 1..first.length) {
        for (j in 1..second.length) {
            if (first[i - 1] == second[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1
            } else {
                dp[i][j] = maxOf(dp[i - 1][j], dp[i][j - 1])
            }
        }
    }

    println(dp[first.length][second.length])
}
