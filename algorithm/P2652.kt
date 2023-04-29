package algorithm

/**
 * Author: Deean
 * Date: 2023-04-29 15:48
 * FileName: algorithm/P2652
 * Description:
 */

class P2652 {
    class Solution {
        fun sumOfMultiples(n: Int): Int {
            var sum = 0
            for (i in 1..n) {
                if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                    sum += i
                }
            }
            return sum
        }
    }
}

fun main() {
    val solution = P2652.Solution()
    val ans = solution.sumOfMultiples(21)
    println(ans)
}