package tony

class `1003` {
    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            val answer = StringBuilder()

            val t = readLine().toInt()
            val list = Array(t) { readLine().toInt() }

            val dp = Array(41) { Pair(0, 0) }
            dp[0] = Pair(1, 0)
            dp[1] = Pair(0, 1)

            for (i in 2..40) {
                dp[i] = Pair(dp[i - 1].first + dp[i - 2].first, dp[i - 1].second + dp[i - 2].second)
            }

            list.forEach { i ->
                answer.appendLine("${dp[i].first} ${dp[i].second}")
            }

            close()
            return answer.toString()
        }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`1003`().solution())

        flush()
        close()
    }
