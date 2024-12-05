package baekjoon.data_structure

import java.util.PriorityQueue

class `1927` {
    fun solution(): String = with(System.`in`.bufferedReader()) {
        val answer = StringBuilder()

        val n = readLine().toInt()
        val minHeap = PriorityQueue<Int>()

        repeat(n) {
            val x = readLine().toInt()
            if (x == 0) {
                answer.append("${minHeap.poll() ?: 0}\n")
            } else {
                minHeap.add(x)
            }
        }

        close()
        return answer.toString()
    }
}

fun main(): Unit = with(System.out.bufferedWriter()) {
    write(`1927`().solution())

    flush()
    close()
}