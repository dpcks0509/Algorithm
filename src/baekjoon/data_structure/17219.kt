package baekjoon.data_structure

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val hashMap = HashMap<String, String>()

    for (i in 0 until n) {
        val (addr, pwd) = readln().split(" ")
        hashMap[addr] = pwd
    }

    for (i in 0 until m) {
        val addr = readln()
        val pwd = hashMap.get(addr)
        println(pwd)
    }
}
