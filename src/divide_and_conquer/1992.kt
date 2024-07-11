package divide_and_conquer

class `1992` {
    private lateinit var arrays: Array<Array<Int>>
    val answer = StringBuilder()

    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            val n = readLine().toInt()

            arrays = Array(n) { readLine().map { it - '0' }.toTypedArray() }

            divide(n, 0, 0)

            close()
            return answer.toString()
        }

    private fun divide(
        n: Int,
        x: Int,
        y: Int,
    ) {
        if (n == 1 || conquer(n, x, y)) {
            answer.append(if (arrays[x][y] == 0) "0" else "1")
        } else {
            answer.append("(")
            divide(n / 2, x, y)
            divide(n / 2, x, y + n / 2)
            divide(n / 2, x + n / 2, y)
            divide(n / 2, x + n / 2, y + n / 2)
            answer.append(")")
        }
    }

    private fun conquer(
        n: Int,
        x: Int,
        y: Int,
    ): Boolean {
        val target = arrays[x][y]

        for (i in x until x + n) {
            for (j in y until y + n) {
                if (arrays[i][j] != target) return false
            }
        }

        return true
    }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`1992`().solution())

        flush()
        close()
    }
