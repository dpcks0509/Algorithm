package tony.dp

import kotlin.math.min
import kotlin.math.sqrt

class `17626` {
    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            val answer = StringBuilder()

            val n = readLine().toInt()

            val dp = IntArray(n + 1) { n }
            dp[0] = 0

            for (i in 1..n) {
                for (j in 1..sqrt(i.toDouble()).toInt()) {
                    dp[i] = min(dp[i], dp[i - j * j] + 1)
                }
            }

            answer.append("${dp[n]}")

            close()
            return answer.toString()
        }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`17626`().solution())

        flush()
        close()
    }
