package baekjoon.back_tracking

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    val numbers = Array(n + 1) { it }

    fun solution(index:Int, depth:Int, str:String) {
        if(depth == m) {
            println(str.trim())
            return
        }

        for(i in index..n) {
            solution(i,depth+1,"$str ${numbers[i]}")
        }
    }

    solution(1,0,"")
}
