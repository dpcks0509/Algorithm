package baekjoon.divide_and_conquer

class `17829` {
    val answer = StringBuilder()

    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            val n = readLine().toInt()
            val square = Array(n) { Array(n) { 0 } }
            repeat(n) {
                square[it] = readLine().split(" ").map { it.toInt() }.toTypedArray()
            }

            divide(square, n)

            close()
            return answer.toString()
        }

    private fun divide(
        square: Array<Array<Int>>,
        n: Int,
    ) {
        if (n == 1) {
            answer.append("${square[0][0]}")
            return
        } else {
            val divideNum = n / 2
            val divideSquare = Array(divideNum) { Array(divideNum) { 0 } }

            for (i in 0..<divideNum) {
                for (j in 0..<divideNum) {
                    divideSquare[i][j] = (conquer(square, i * 2, j * 2))
                }
            }

            divide(divideSquare, divideNum)
        }
    }

    private fun conquer(
        square: Array<Array<Int>>,
        x: Int,
        y: Int,
    ): Int {
        val list = mutableListOf<Int>()
        for (i in x..<x + 2) {
            for (j in y..<y + 2) {
                list.add(square[i][j])
            }
        }
        return list.sortedDescending()[1]
    }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`17829`().solution())

        flush()
        close()
    }
