package tony.math

class `1676` {
    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            val n = readLine().toInt()
            var count = 0

            var divisor = 5
            while (divisor <= n) {
                count += n / divisor
                divisor *= 5
            }

            return count.toString()
        }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`1676`().solution())

        flush()
        close()
    }
