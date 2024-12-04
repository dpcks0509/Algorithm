package tony.dp

class `11726` {
    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            val answer = StringBuilder()

            val n = readLine().toInt()
            val dp = Array(1001) { 0 }
            dp[1] = 1
            dp[2] = 2
            for (i in 3..1000) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 10007
            }

            answer.append("${dp[n]}")

            close()
            return answer.toString()
        }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`11726`().solution())

        flush()
        close()
    }

/*
    dp[1] -> 1
    dp[2] -> 2
    dp[3] -> 3
    dp[4] -> 5
 */
