package baekjoon.sort

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val sb = StringBuilder()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val words = Array(n) { br.readLine() }.filter { it.length >= m }

    val map = mutableMapOf<String, Int>()
    for (i in 0 until words.size) {
        map[words[i]] = map.getOrDefault(words[i], 0) + 1
    }

    val sortedWords = map.keys.sortedWith(
        compareByDescending<String> { map[it] }
            .thenByDescending { it.length }
            .thenBy { it })

    sortedWords.forEach {
        sb.appendLine(it)
    }

    bw.write(sb.toString())
    bw.flush()
    bw.close()
    br.close()
}