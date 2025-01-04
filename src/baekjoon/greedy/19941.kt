package baekjoon.greedy

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val arr = br.readLine().toCharArray()

    val persons = BooleanArray(n)
    for (i in 0 until n) {
        if (arr[i] == 'P') {
            persons[i] = true
        }
    }

    var answer = 0
    for (i in 0 until n) {
        if (arr[i] == 'H') {
            for (j in i - k..i + k) {
                if (j < 0 || j >= n) continue
                if (persons[j]) {
                    answer++
                    persons[j] = false
                    break
                }
            }
        }
    }

    bw.write("$answer")
    bw.flush()
    bw.close()
    br.close()
}