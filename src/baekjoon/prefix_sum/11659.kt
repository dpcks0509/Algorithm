package baekjoon.prefix_sum

class `11659` {
    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            val answer = StringBuilder()

            val (n, m) = readLine().split(' ').map { it.toInt() }
            val numbers = readLine().split(' ').map { it.toInt() }

            val prefixSum = Array(n + 1) { 0 }
            for (i in 1..n) {
                prefixSum[i] = prefixSum[i - 1] + numbers[i - 1]
            }

            repeat(m) {
                val (i, j) = readLine().split(' ').map { it.toInt() }
                val sum = prefixSum[j] - prefixSum[i - 1]
                answer.appendLine("$sum")
            }

            close()
            return answer.toString()
        }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`11659`().solution())

        flush()
        close()
    }
