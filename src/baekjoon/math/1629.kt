package baekjoon.math

fun main() {
    var (a, b, c) = readln().split(" ").map { it.toLong() }

    var answer = 1L
    while (b > 0) {
        if (b % 2 == 1L) answer = (answer * a) % c
        a = (a * a) % c
        b /= 2
    }

    println(answer)
}