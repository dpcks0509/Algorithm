package data_structure

import java.util.Deque
import java.util.LinkedList

class `1158` {
    fun solution(): String = with(System.`in`.bufferedReader()) {
        val input = readLine().split(" ").map { it.toInt() }
        val n = input[0]
        val k = input[1]
        val queue: Deque<Int> = LinkedList()
        val answer = mutableListOf<Int>()

        for (i in 0 until n) {
            queue.addLast(i + 1)
        }

        repeat(n) {
            repeat(k - 1) {
                queue.addLast(queue.removeFirst())
            }
            answer.add(queue.removeFirst())
        }
        close()

        return answer.joinToString(", ", "<", ">")
    }
}

fun main(): Unit = with(System.out.bufferedWriter()) {
    write(`1158`().solution())

    flush()
    close()
}