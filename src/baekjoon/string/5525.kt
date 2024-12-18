package baekjoon.string

fun main() {
    val n = readln().toInt() // N
    val m = readln().toInt() // M
    val s = readln() // S

    var count = 0
    var i = 0
    var consecutive = 0

    while (i < m - 1) {
        if (s[i] == 'I' && s[i + 1] == 'O') {
            consecutive++
            if (consecutive == n && i + 2 < m && s[i + 2] == 'I') {
                count++
                consecutive-- // 연속 카운트를 유지
            }
            i += 2 // `IO` 패턴은 두 문자씩 건너뜁니다.
        } else {
            consecutive = 0
            i++
        }
    }

    println(count)
}