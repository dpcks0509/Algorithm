package baekjoon.sort

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    val array = IntArray(n) { br.readLine().toInt() }
    array.sort()

    println(array.joinToString("\n"))
}