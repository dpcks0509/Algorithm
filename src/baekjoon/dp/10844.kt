package baekjoon.dp

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val dp = Array(n + 1) { IntArray(10) }
    for (j in 1..9) {
        dp[1][j] = 1
    }

    for (i in 2..n) {
        for (j in 0..9) {
            if (j == 0) {
                dp[i][j] = dp[i - 1][j + 1]
            } else if (j == 9) {
                dp[i][j] = dp[i - 1][j - 1]
            } else {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1_000_000_000
            }
        }
    }

    var answer = 0
    for (i in 0..9) {
        answer = (answer + dp[n][i]) % 1_000_000_000
    }
    println(answer)
}