package tony.greedy

class `20115` {
    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            val answer = StringBuilder()

            val n = readLine().toInt()
            val list = readLine().split(' ').map { it.toDouble() }

            val max = list.max()
            var drink = max
            for (i in 0 until n) {
                if (list[i] == max) continue
                drink += list[i] / 2
            }

            answer.append(drink)

            close()
            return answer.toString()
        }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`20115`().solution())

        flush()
        close()
    }
