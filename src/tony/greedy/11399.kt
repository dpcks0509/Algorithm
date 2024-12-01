package tony.greedy

class `11399` {
    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            val answer = StringBuilder()

            val n = readLine().toInt()
            val times = readLine().split(' ').map { it.toInt() }.sorted()

            var sum = times[0]
            for (i in 1 until n) {
                sum += times.subList(0, i).sum() + times[i]
            }

            answer.append("$sum")

            close()
            return answer.toString()
        }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`11399`().solution())

        flush()
        close()
    }
