package algorithm

/**
 * Author: Deean
 * Date: 2023-04-29 19:01
 * FileName: algorithm/P2651
 * Description:
 */

class P2651 {
    class Solution {
        fun findDelayedArrivalTime(arrivalTime: Int, delayedTime: Int): Int {
            return (arrivalTime + delayedTime) % 24
        }
    }
}

fun main() {
    val solution = P2651.Solution()
    val ans = solution.findDelayedArrivalTime(13, 11)
    println(ans)
}