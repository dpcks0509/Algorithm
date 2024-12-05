package baekjoon.greedy

data class Time(
    val start: Int,
    val end: Int,
)

class `1931` {
    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            val answer = StringBuilder()

            val n = readLine().toInt()
            val times =
                Array(n) {
                    val (start, end) = readLine().split(' ').map { it.toInt() }
                    Time(start, end)
                }

            times.sortWith { t1, t2 ->
                if (t1.end == t2.end) {
                    t1.start - t2.start
                } else {
                    t1.end - t2.end
                }
            }

            var cnt = 0
            var currentEnd = 0

            times.forEach {
                if (currentEnd <= it.start) {
                    currentEnd = it.end
                    cnt++
                }
            }

            answer.append("$cnt")

            close()
            return answer.toString()
        }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`1931`().solution())

        flush()
        close()
    }
