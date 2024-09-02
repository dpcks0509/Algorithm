package tony.data_structure

import java.util.Deque
import java.util.LinkedList

class `2164` {
    fun solution(): String = with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()

        val queue: Deque<Int> = LinkedList()
        for (i in 1..n) {
            queue.addLast(i)
        }

        repeat(n - 1) {
            queue.removeFirst()
            queue.addLast(queue.removeFirst())
        }

        close()
        return queue.peekFirst().toString()
    }
}

fun main(): Unit = with(System.out.bufferedWriter()) {
    write(`2164`().solution())

    flush()
    close()
}