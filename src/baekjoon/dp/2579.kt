package baekjoon.dp

import kotlin.math.max

class `2579` {
    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            val answer = StringBuilder()

            val n = readLine().toInt()
            val scores = IntArray(n)
            for (i in 0 until n) {
                scores[i] = readLine().toInt()
            }
            // 방법 1.
//            val dp = Array(n) { IntArray(2) }
//            dp[0][0] = scores[0]
//            if (n > 1) {
//                dp[1][0] = scores[1]
//                dp[1][1] = scores[0] + scores[1]
//            }
//
//            for (i in 2 until n) {
//                dp[i][0] = maxOf(dp[i - 2][0], dp[i - 2][1]) + scores[i]
//                dp[i][1] = dp[i - 1][0] + scores[i]
//            }
//
//            answer.append(dp[n - 1].max())

            // 방법 2.
            val dp = IntArray(n)
            dp[0] = scores[0]
            if (n > 1) {
                dp[1] = scores[0] + scores[1]
            }
            if (n > 2) {
                dp[2] = max(scores[0], scores[1]) + scores[2]
            }

            for (i in 3 until n) {
                dp[i] = max(dp[i - 2], dp[i - 3] + scores[i - 1]) + scores[i]
            }

            answer.append(dp[n - 1])

            close()
            return answer.toString()
        }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`2579`().solution())

        flush()
        close()
    }

/*
    dp[0] -> scores[0]
    dp[1] -> scores[0] + scores[1]
    dp[2] -> max(scores[0], scores[1]) + scores[2]
    dp[3] -> max(dp[1],dp[0] + scores[2]) + scores[3]
    dp[4] -> max(dp[2],dp[1] + scores[3]) + scores[4]
 */
