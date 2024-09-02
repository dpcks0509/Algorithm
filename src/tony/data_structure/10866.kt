package tony.data_structure

import java.util.Deque
import java.util.LinkedList

class `10866` {
    fun solution(): String = with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        val answer = StringBuilder()

        val deque: Deque<Int> = LinkedList()
        repeat(n) {
            val input = readLine().split(" ")
            val cmd = input[0]

            when (cmd) {
                "push_front" -> {
                    val num = input[1].toInt()
                    deque.addFirst(num)
                }

                "push_back" -> {
                    val num = input[1].toInt()
                    deque.addLast(num)
                }

                "pop_front" -> {
                    answer.append(if (deque.isNotEmpty()) "${deque.removeFirst()}\n" else "-1\n")
                }

                "pop_back" -> {
                    answer.append(if (deque.isNotEmpty()) "${deque.removeLast()}\n" else "-1\n")
                }

                "size" -> {
                    answer.append("${deque.size}\n")
                }

                "empty" -> {
                    answer.append(if (deque.isEmpty()) "1\n" else "0\n")
                }

                "front" -> {
                    answer.append(if (deque.isNotEmpty()) "${deque.peekFirst()}\n" else "-1\n")
                }

                "back" -> {
                    answer.append(if (deque.isNotEmpty()) "${deque.peekLast()}\n" else "-1\n")
                }
            }
        }
        close()

        return answer.toString()
    }
}

fun main(): Unit = with(System.out.bufferedWriter()) {
    write(`10866`().solution())

    flush()
    close()
}