package baekjoon.sort

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    val array = Array<String>(n) { br.readLine() }
    array.sortWith(compareBy<String> { it.length }
        .thenBy { it.filter { ch -> ch.isDigit() }.sumOf { ch -> ch.digitToInt() } }
        .thenBy { it }
    )

    println(array.joinToString("\n"))
}