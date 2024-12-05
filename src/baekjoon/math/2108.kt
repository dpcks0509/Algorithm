package baekjoon.math

import kotlin.math.roundToInt

class `2108` {
    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            val answer = StringBuilder()

            val n = readLine().toInt()
            val numbers =
                List(n) {
                    readLine().toInt()
                }

            answer.appendLine("${(numbers.sum().toDouble() / n).roundToInt()}")

            val sortedNumbers = numbers.sorted()
            answer.appendLine("${(sortedNumbers[n / 2])}")

            val freqMap = numbers.groupingBy { it }.eachCount()
            val maxFreq = freqMap.maxOf{it.value}
            val maxFreqNumbers = freqMap.filter { it.value == maxFreq }.keys.sorted()
            val freq = if(maxFreqNumbers.size == 1) maxFreqNumbers[0] else maxFreqNumbers[1]
            answer.appendLine("$freq")

            answer.appendLine("${sortedNumbers.last() - sortedNumbers.first()}")

            close()
            return answer.toString()
        }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`2108`().solution())

        flush()
        close()
    }
