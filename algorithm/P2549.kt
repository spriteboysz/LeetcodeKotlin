package algorithm

/**
 * Author: Deean
 * Date: 2023-04-16 17:49
 * FileName: algorithm
 * Description:
 */

class P2549 {
    class Solution {
        fun distinctIntegers(n: Int): Int {
            return if (n == 1) {
                1
            } else {
                n - 1
            }
        }
    }
}

fun main() {
    val solution = P2549.Solution()
    val ans = solution.distinctIntegers(10)
    println(ans)
}