package tony.data_structure

import java.util.Deque
import java.util.LinkedList

class `2841` {
    fun solution(): String = with(System.`in`.bufferedReader()) {
        val (n, p) = readLine().split(" ").map { it.toInt() }

        val lines: List<Deque<Int>> = List(7) { LinkedList() } // line 범위 1 ~ 6
        var answer = 0

        repeat(n) {
            val (line, fret) = readLine().split(" ").map { it.toInt() }
            val targetLine = lines[line]
            while (targetLine.isNotEmpty() && targetLine.last > fret) {
                targetLine.removeLast()
                answer += 1
            }

            if (targetLine.isEmpty() || targetLine.last != fret) {
                targetLine.addLast(fret)
                answer += 1
            }
        }

        close()
        return answer.toString()
    }
}

fun main(): Unit = with(System.out.bufferedWriter()) {
    write(`2841`().solution())

    flush()
    close()
}