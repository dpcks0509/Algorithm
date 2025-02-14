package baekjoon.array

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toCharArray().map { it - '0' }

    val array = IntArray(10)

    n.forEach {
        array[it] = array[it] + 1
    }

    val six = array[6]
    array[6] = (six + array[9] + 1) / 2
    array[9] = (six + array[9] + 1) / 2

    println(array.maxOrNull())
}