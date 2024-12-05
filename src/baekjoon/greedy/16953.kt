package baekjoon.greedy

class `16953` {
    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            val answer = StringBuilder()

            val input = readLine().split(' ').map { it.toInt() }
            val a = input[0]
            var b = input[1]

            var cnt = 0
            while (a != b) {
                if (a > b) return "-1"

                if (b % 10 == 1) {
                    b /= 10
                } else if (b % 2 == 0) {
                    b /= 2
                } else {
                    return "-1"
                }
                cnt++
            }

            answer.append("${cnt + 1}")

            close()
            return answer.toString()
        }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`16953`().solution())

        flush()
        close()
    }
