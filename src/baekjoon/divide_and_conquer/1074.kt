package baekjoon.divide_and_conquer

import java.io.BufferedReader
import java.io.BufferedWriter
import kotlin.math.pow

fun main() {
    val br = BufferedReader(System.`in`.bufferedReader())
    val bw = BufferedWriter(System.`out`.bufferedWriter())

    val (n, r, c) = br.readLine().split(' ').map { it.toInt() }

    val size = 2.0.pow(n).toInt()
    var cnt = 0

    fun recur(
        x: Int,
        y: Int,
        size: Int,
    ) {
        // 크기가 1인 경우 더 이상 분할할 수 없으므로 종료
        if (size == 1) return

        val half = size / 2

        // 1번째 구간: 왼쪽 위
        if (r < x + half && c < y + half) {
            recur(x, y, half)
        }
        // 2번째 구간: 오른쪽 위
        else if (r < x + half && c >= y + half) {
            cnt += half * half
            recur(x, y + half, half)
        }
        // 3번째 구간: 왼쪽 아래
        else if (r >= x + half && c < y + half) {
            cnt += 2 * half * half
            recur(x + half, y, half)
        }
        // 4번째 구간: 오른쪽 아래
        else {
            cnt += 3 * half * half
            recur(x + half, y + half, half)
        }
    }

    recur(0, 0, size)

    bw.write("$cnt")
    bw.flush()
}
