package divide_and_conquer

class `2630` {
    var whiteCount = 0
    var blueCount = 0

    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            val answer = StringBuilder()

            val n = readLine().toInt()
            val papers =
                Array(n) {
                    readLine().split(" ").map { it.toInt() }.toTypedArray()
                }

            divide(papers, n)

            answer.append("${whiteCount}\n")
            answer.append("${blueCount}\n")

            close()
            return answer.toString()
        }

    private fun divide(
        papers: Array<Array<Int>>,
        n: Int,
    ) {
        if (n == 1) {
            if (papers[0][0] == 0) whiteCount++ else blueCount++
        } else {
            if (papers.flatten().all { it == 0 }) {
                whiteCount++
            } else if (papers.flatten().all { it == 1 }) {
                blueCount++
            } else {
                val divideNum = n / 2

                val firstPaper = Array(divideNum) { Array(divideNum) { 0 } }
                val secondPaper = Array(divideNum) { Array(divideNum) { 0 } }
                val thirdPaper = Array(divideNum) { Array(divideNum) { 0 } }
                val fourthPaper = Array(divideNum) { Array(divideNum) { 0 } }

                papers.forEachIndexed { i, paper ->
                    paper.forEachIndexed { j, num ->
                        if (i in 0..<divideNum && j in 0..<divideNum) {
                            firstPaper[i][j] = num
                        }

                        if (i in 0..<divideNum && j >= divideNum) {
                            secondPaper[i][j - divideNum] = num
                        }

                        if (i >= divideNum && j in 0..<divideNum) {
                            thirdPaper[i - divideNum][j] = num
                        }

                        if (i >= divideNum && j >= divideNum) {
                            fourthPaper[i - divideNum][j - divideNum] = num
                        }
                    }
                }

                divide(firstPaper, divideNum)
                divide(secondPaper, divideNum)
                divide(thirdPaper, divideNum)
                divide(fourthPaper, divideNum)
            }
        }
    }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`2630`().solution())

        flush()
        close()
    }
