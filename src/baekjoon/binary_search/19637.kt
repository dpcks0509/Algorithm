package baekjoon.binary_search

fun main() {
    data class Title(val name: String, val maxValue: Int)

    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val sb = StringBuilder()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val titles = Array(n) {
        val (name, maxValue) = br.readLine().split(" ")
        Title(name, maxValue.toInt())
    }

    repeat(m) {
        val value = br.readLine().toInt()

        var left = 0
        var right = n - 1
        var answer = ""

        while (left <= right) {
            val mid = (left + right) / 2

            if (value <= titles[mid].maxValue) {
                answer = titles[mid].name
                right = mid - 1
            } else {
                left = mid + 1
            }
        }

        sb.appendLine(answer)
    }

    bw.write(sb.toString())
    bw.flush()
    bw.close()
    br.close()
}
