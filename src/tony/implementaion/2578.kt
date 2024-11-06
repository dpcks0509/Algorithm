package tony.implementaion

data class Bingo(
    val number: Int,
    val isChecked: Boolean = false,
)

class `2578` {
    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            val answer = StringBuilder()

            val board =
                Array(5) { _ ->
                    val numbers = readLine().split(' ').map { it.toInt() }
                    numbers.map { Bingo(it) }.toTypedArray()
                }

            val input =
                Array(5) { _ ->
                    readLine().split(' ').map { it.toInt() }.toIntArray()
                }

            var cnt = 0
            for (i in 0 until 5) {
                for (j in 0 until 5) {
                    cnt++

                    val index = board.flatten().indexOfFirst { it.number == input[i][j] }
                    board[index / 5][index % 5] = board[index / 5][index % 5].copy(isChecked = true)

                    var line = 0
                    for (r in 0 until 5) {
                        if (board[r].all { it.isChecked }) line++
                    }

                    for (c in 0 until 5) {
                        if ((0 until 5).all { r -> board[r][c].isChecked }) line++
                    }

                    if ((0 until 5).all { board[it][it].isChecked }) line++

                    if ((0 until 5).all { board[it][4 - it].isChecked }) line++

                    if (line >= 3) return "$cnt"
                }
            }

            close()
            return answer.toString()
        }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`2578`().solution())

        flush()
        close()
    }
