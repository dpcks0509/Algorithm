package baekjoon.back_tracking

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    val numbers = Array(n + 1) { it }
    val visited = Array(n + 1) { false }

    fun solution(index: Int, depth: Int, str: String) {
        if (depth == m) {
            println(str.trim())
            return
        }

        for (i in index..n) {
            if(visited[i]) continue

            visited[i] = true
            solution(i + 1, depth + 1, "$str ${numbers[i]}")
            visited[i] = false
        }
    }

    solution(1, 0, "")
}

/*
    1,0,""
    1->true
        2,1,"1"
        (i==2)
        1->true , 2->true
            3,2,"1 2"
            (i==3)
            1->true , 2->true, 3->true
                4,3,"1 2 3"
                print
            1->true , 2->true
            (i==4)
            1->true , 2->true, 4->true
                5,3, "1 2 4"
                print
            1->true , 2->true
       1->true
       (i==3)
       1->true, 3->true
            4,2,"1 3"
 */