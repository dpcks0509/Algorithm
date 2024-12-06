package baekjoon.greedy

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val (n, k) = br.readLine().split(' ').map { it.toInt() }
    val arr = Array(n) { br.readLine().toInt() }.reversed()

    var cnt = 0
    var sum = 0
    arr.forEach {
        if (it <= (k - sum)) {
            val quantity = (k - sum) / it
            cnt += quantity
            sum += it * quantity
        }
    }

    bw.write("$cnt")
    bw.flush()
}
