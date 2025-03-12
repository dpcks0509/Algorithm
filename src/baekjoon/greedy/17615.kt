package baekjoon.greedy

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    val balls = br.readLine().toCharArray()

    var redLeft = 0
    val firstBlue = balls.indexOfFirst { it == 'B' }
    for (i in firstBlue + 1 until n) {
        if (balls[i] == 'R') {
            redLeft++
        }
    }

    var blueLeft = 0
    val firstRed = balls.indexOfFirst { it == 'R' }
    for (i in firstRed + 1 until n) {
        if (balls[i] == 'B') {
            blueLeft++
        }
    }

    var redRight = 0
    val lastBlue = balls.indexOfLast { it == 'B' }
    for (i in lastBlue - 1 downTo 0) {
        if (balls[i] == 'R') {
            redRight++
        }
    }

    var blueRight = 0
    val lastRed = balls.indexOfLast { it == 'R' }
    for (i in lastRed - 1 downTo 0) {
        if (balls[i] == 'B') {
            blueRight++
        }
    }

    val answer = minOf(redLeft, blueLeft, redRight, blueRight)
    println(answer)
}