package baekjoon.implementation

class `1913` {
    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            val answer = StringBuilder()

            val n = readLine().toInt()
            val target = readLine().toInt()

            val board = Array(n) { Array(n) { 0 } }
            var num = n * n

            var x = 0
            var y = 0
            var down = n - 1
            var right = n - 1
            var up = n - 1
            var left = n - 2

            repeat(n / 2 + 1) {
                board[y][x] = num
                repeat(down) {
                    board[++y][x] = --num
                }
                down -= 2

                repeat(right) {
                    board[y][++x] = --num
                }
                right -= 2

                repeat(up) {
                    board[--y][x] = --num
                }
                up -= 2

                repeat(left) {
                    board[y][--x] = --num
                }
                left -= 2

                y++
                num--
            }

            board.forEach {
                answer.append(it.joinToString(" ") + "\n")
            }

            val index = board.flatten().indexOf(target)
            val targetY = index / n + 1
            val targetX = index % n + 1
            answer.append("$targetY $targetX")

            close()
            return answer.toString()
        }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`1913`().solution())

        flush()
        close()
    }
