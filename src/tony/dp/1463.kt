package tony.dp

class `1463` {
    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            val answer = StringBuilder()

            val n = readLine().toInt()

            val dp = IntArray(n + 1)
            dp[0] = 0
            dp[1] = 0

            for (i in 2..n) {
                dp[i] = dp[i - 1] + 1
                if (i % 2 == 0) {
                    dp[i] = minOf(dp[i], dp[i / 2] + 1)
                }
                if (i % 3 == 0) {
                    dp[i] = minOf(dp[i], dp[i / 3] + 1)
                }
            }

            answer.append(dp[n])

            close()
            return answer.toString()
        }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`1463`().solution())

        flush()
        close()
    }

/*
    1 -> 0
    2 -> 1 (2/2)
    3 -> 1 (3/3)
    4 -> 2 (4/2/2)
    5 -> 3 (5-1)/2
    6 -> 2 (6/3/2)
    7 -> 3 (7-1)/3/2
    8 -> 3 (8/2/2/2)
    9 -> 2 (9/3/3)
    10 -> 3 (10-1)/3/3
    11 -> 4 (11-1-1)/3/3
 */
