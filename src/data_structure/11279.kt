package data_structure

import java.util.PriorityQueue

class `11279` {
    fun solution(): String = with(System.`in`.bufferedReader()) {
        val answer = StringBuilder()

        val n = readLine().toInt()
        val maxHeap = PriorityQueue<Int>(Comparator.reverseOrder())

        repeat(n) {
            val x = readLine().toInt()
            if (x == 0) {
                answer.append("${maxHeap.poll() ?: 0}\n")
            } else {
                maxHeap.add(x)
            }
        }

        close()
        return answer.toString()
    }
}

fun main(): Unit = with(System.out.bufferedWriter()) {
    write(`11279`().solution())

    flush()
    close()
}