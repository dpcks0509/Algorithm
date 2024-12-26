package baekjoon.dp

fun main() {
    val t = readln().toInt()

    for (i in 0 until t) {
        val n = readln().toInt()
        val board = Array(2) { readln().split(" ").map { it.toInt() } }

        val dp = Array(2) { IntArray(n) }

        dp[0][0] = board[0][0]
        dp[1][0] = board[1][0]
        if (n == 1) {
            println(maxOf(dp[0][0], dp[1][0]))
            continue
        }

        dp[0][1] = board[0][1] + board[1][0]
        dp[1][1] = board[1][1] + board[0][0]
        if (n == 2) {
            println(maxOf(dp[0][1], dp[1][1]))
            continue
        }

        for (y in 2 until n) {
            dp[0][y] = board[0][y] + maxOf(dp[1][y - 1], dp[1][y - 2])
            dp[1][y] = board[1][y] + maxOf(dp[0][y - 1], dp[0][y - 2])
        }

        println(maxOf(dp[0][n - 1], dp[1][n - 1]))
    }
}
