package tony.data_structure

import java.util.PriorityQueue
import kotlin.math.abs

class `11286` {
    fun solution(): String = with(System.`in`.bufferedReader()) {
        val answer = StringBuilder()

        val n = readLine().toInt()
        val heap = PriorityQueue<Int> { a, b ->
            if (abs(a) == abs(b)) {
                a - b
            } else {
                abs(a) - abs(b)
            }
        }

        repeat(n) {
            val x = readLine().toInt()
            if (x == 0) {
                answer.append("${heap.poll() ?: 0}\n")
            } else {
                heap.add(x)
            }
        }

        close()
        return answer.toString()
    }
}

fun main(): Unit = with(System.out.bufferedWriter()) {
    write(`11286`().solution())

    flush()
    close()
}