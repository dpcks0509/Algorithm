package tony.divide_and_conquer

class `18222` {
    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            val answer = StringBuilder()

            val n = readLine().toLong()

            answer.append("${divide((n - 1))}")

            close()
            return answer.toString()
        }

    private fun divide(n: Long): Int =
        if (n == 0L) {
            0
        } else if (n == 1L) {
            1
        } else if (n % 2 == 0L) {
            divide(n / 2)
        } else {
            1 - divide(n / 2)
        }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`18222`().solution())

        flush()
        close()
    }
