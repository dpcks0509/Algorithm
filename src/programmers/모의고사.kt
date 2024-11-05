package programmers

class `모의고사` {
    fun solution(answers: IntArray): IntArray {
        val one = listOf(1, 2, 3, 4, 5)
        val two = listOf(2, 1, 2, 3, 2, 4, 2, 5)
        val three = listOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)

        var oneCount = 0
        var twoCount = 0
        var threeCount = 0

        answers.forEachIndexed { index, answer ->
            if (answer == one[index % 5]) oneCount++
            if (answer == two[index % 8]) twoCount++
            if (answer == three[index % 10]) threeCount++
        }

        val answer = mutableListOf<Int>()

        val max = listOf(oneCount, twoCount, threeCount).maxOrNull()
        if (oneCount == max) answer.add(1)
        if (twoCount == max) answer.add(2)
        if (threeCount == max) answer.add(3)

        return answer.toIntArray()
    }
}
