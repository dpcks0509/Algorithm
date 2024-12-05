package baekjoon.data_structure

import java.util.Deque
import java.util.LinkedList
import kotlin.math.abs

class `2346` {
    fun solution(): String = with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        val balloons = readLine().split(" ").mapIndexed { index, it -> Pair(index + 1, it.toInt()) }
        val answer = mutableListOf<Int>()

        val deque: Deque<Pair<Int, Int>> = LinkedList()
        balloons.forEach {
            deque.addLast(it)
        }

        repeat(n) {
            val balloon = deque.removeFirst()
            answer.add(balloon.first)
            deque.rotate(balloon.second)
        }

        close()
        return answer.joinToString(" ")
    }

    private fun Deque<Pair<Int, Int>>.rotate(number: Int) {
        if (isEmpty()) return
        if (number > 0) {
            repeat((number - 1) % size) {
                addLast(removeFirst())
            }
        } else {
            repeat(abs(number) % size) {
                addFirst(removeLast())
            }
        }
    }
}

fun main(): Unit = with(System.out.bufferedWriter()) {
    write(`2346`().solution())

    flush()
    close()
}