package baekjoon.greedy

fun main() {
    data class Person(
        val document: Int,
        val interview: Int,
    )

    val t = readln().toInt()

    for (i in 0 until t) {
        val n = readln().toInt()

        val persons = Array(n) { Person(0, 0) }

        for (j in 0 until n) {
            val (document, interview) = readln().split(" ").map { it.toInt() }
            persons[j] = Person(document, interview)
        }

        persons.sortWith(compareBy { it.document })
        var minInterview = persons[0].interview
        var cnt = 1
        for (j in 0 until n) {
            if(persons[j].interview < minInterview) {
                cnt++
                minInterview = persons[j].interview
            }
        }
        println(cnt)
    }
}

/*
1.
3 2
1 4
4 1
2 3
5 5 (X)

2.
1 4
2 5 (x)
3 6 (x)
4 2
5 7 (x)
6 1
7 3 (x)


3 6 (x)
7 3 (x)
4 2
1 4
5 7 (x)
2 5 (x)
6 1
 */
