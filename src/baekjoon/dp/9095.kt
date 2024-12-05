package baekjoon.dp

class `9095` {
    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            val answer = StringBuilder()

            val t = readLine().toInt()
            val numbers = List(t) { readLine().toInt() }

            fun dp(n: Int): Int =
                when (n) {
                    1 -> 1
                    2 -> 2
                    3 -> 4
                    else -> dp(n - 1) + dp(n - 2) + dp(n - 3)
                }

            numbers.forEach { n ->
                answer.appendLine("${dp(n)}")
            }

            close()
            return answer.toString()
        }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`9095`().solution())

        flush()
        close()
    }
