package algorithm

/**
 * Author: Deean
 * Date: 2023-04-29 19:07
 * FileName: algorithm/P2644
 * Description:
 */

class P2644 {
    class Solution {
        fun maxDivScore(nums: IntArray, divisors: IntArray): Int {
            var maximum = 0
            var maxCnt = -1
            for (divisor in divisors) {
                var cnt = 0
                for (num in nums) {
                    if (num % divisor == 0) {
                        cnt++
                    }
                }
                if (cnt > maxCnt || cnt == maxCnt && divisor < maximum) {
                    maximum = divisor
                    maxCnt = cnt
                }
            }
            return maximum
        }
    }
}

fun main() {
    val solution = P2644.Solution()
    val nums: IntArray = intArrayOf(20,14,21,10)
    val divisors: IntArray = intArrayOf(5,7,5)
    val ans = solution.maxDivScore(nums, divisors)
    println(ans)
}