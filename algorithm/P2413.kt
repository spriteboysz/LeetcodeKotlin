package algorithm

/**
 * Author: Deean
 * Date: 2023-04-16 17:46
 * FileName: algorithm
 * Description:
 */

class P2413 {
    class Solution {
        fun smallestEvenMultiple(n: Int): Int {
            return if (n % 2 == 0) {
                n
            } else {
                n * 2
            }
        }
    }
}

fun main() {
    val solution = P2413.Solution()
    val ans = solution.smallestEvenMultiple(10)
    println(ans)
}