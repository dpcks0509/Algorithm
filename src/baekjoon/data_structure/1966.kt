package baekjoon.data_structure

import java.util.Deque
import java.util.LinkedList

class `1966` {
    fun solution(): String = with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        val answer = StringBuilder()

        repeat(n) {
            val (size, target) = readLine().split(" ").map { it.toInt() }
            val priorities = readLine().split(" ").map { it.toInt() }

            val queue: Deque<Pair<Int, Int>> = LinkedList()
            for (i in 0 until size) {
                queue.addLast(Pair(i, priorities[i]))
            }

            var count = 0
            while (true) {
                val max = queue.maxOf { it.second }
                val firstPair = queue.removeFirst()

                if (firstPair.second == max) {
                    count++
                    if (firstPair.first == target) {
                        answer.append("${count}\n")
                        break
                    }
                } else {
                    queue.addLast(firstPair)
                }
            }
        }
        close()

        return answer.toString()
    }
}

fun main(): Unit = with(System.out.bufferedWriter()) {
    write(`1966`().solution())

    flush()
    close()
}