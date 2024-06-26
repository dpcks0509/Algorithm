package data_structure

import java.util.PriorityQueue

class `2075` {
    fun solution(): String = with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        val maxHeap = PriorityQueue<Int>(Comparator.reverseOrder())

        repeat(n) {
            val row = readLine().split(" ").map { it.toInt() }
            maxHeap.addAll(row)
        }

        repeat(n - 1) {
            maxHeap.poll()
        }
        val answer = maxHeap.poll()

        close()
        return answer.toString()
    }
}

fun main(): Unit = with(System.out.bufferedWriter()) {
    write(`2075`().solution())

    flush()
    close()
}