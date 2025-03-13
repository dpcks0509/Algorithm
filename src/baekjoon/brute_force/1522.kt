package baekjoon.brute_force

fun main() {
    val br = System.`in`.bufferedReader()
    val input = br.readLine().toCharArray()

    val numberOfA = input.count { it == 'a' }

    var min = Int.MAX_VALUE
    for (i in 0 until input.size) {
        var numberOfB = 0
        for (j in i until i + numberOfA) {
            val index = j % input.size

            if (input[index] == 'b') numberOfB++
        }

        min = minOf(min, numberOfB)
    }

    println(min)
}