package baekjoon.sort

class `18870` {
    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            val answer = StringBuilder()

            val n = readLine().toInt()
            val list = readLine().split(' ').map { it.toInt() }
            val sortedList = list.distinct().sorted()

            for (i in 0 until n) {
                answer.append("${sortedList.binarySearch(list[i])} ")
            }

            close()
            return answer.toString()
        }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`18870`().solution())

        flush()
        close()
    }
