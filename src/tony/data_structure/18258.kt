package tony.data_structure

import java.util.Deque
import java.util.LinkedList

class `18258` {
    fun solution(): String = with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        val answer = StringBuilder()

        val queue: Deque<Int> = LinkedList()
        repeat(n) {
            val input = readLine().split(" ")
            val cmd = input[0]

            when (cmd) {
                "push" -> {
                    val num = input[1].toInt()
                    queue.addLast(num)
                }

                "pop" -> {
                    answer.append(if (queue.isNotEmpty()) "${queue.removeFirst()}\n" else "-1\n")
                }

                "size" -> {
                    answer.append("${queue.size}\n")
                }

                "empty" -> {
                    answer.append(if (queue.isEmpty()) "1\n" else "0\n")
                }

                "front" -> {
                    answer.append(if (queue.isNotEmpty()) "${queue.peekFirst()}\n" else "-1\n")
                }

                "back" -> {
                    answer.append(if (queue.isNotEmpty()) "${queue.peekLast()}\n" else "-1\n")
                }
            }
        }
        close()

        return answer.toString()
    }
}

fun main(): Unit = with(System.out.bufferedWriter()) {
    write(`18258`().solution())

    flush()
    close()
}