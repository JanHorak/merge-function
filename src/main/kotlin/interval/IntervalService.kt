package interval

import java.util.*
import kotlin.math.max

/**
 * IntervalService provides the merge-function for merging intervals
 */
class IntervalService {

    /**
     * Function for merging the passed list of pairs and returns the merged one.
     *
     * Example:
     *
     * Incoming Intervals:
     *
     * [11, 28],
     * [4, 17],
     * [30, 35],
     * [40, 100]
     *
     * Returned merged intervals:
     *
     * [4, 28],
     * [30, 35],
     * [40, 100]
     *
     * The function works under the consideration that the smaller value is the first one
     * of the given Pair. Means Pair(534, 2234) OK |  Pair(22, -4) NOK
     *
     * Moreover, the function can handle that the Pairs are unsorted as long as it is kept to the upper constraint.
     *
     * @param intervals - List of Pairs (probably unsorted) which following the described constraint
     * @return merged intervals  - sorted and merged
     */
    fun merge(intervals: List<Pair>): List<Pair> {
        if (intervals.isEmpty()) {
            return emptyList()
        }
        val result = mutableListOf<Pair>()
        Collections.sort(intervals) { (first): Pair, (other): Pair ->
            first.compareTo(other)
        }

        var resultPair = Pair(intervals[0].first, intervals[0].second)
        for (index in 1 until intervals.size) {
            val current = intervals[index]
            if (current.first <= resultPair.second) {
                resultPair.second = max(current.second, resultPair.second)
            } else {
                result.add(resultPair)
                resultPair = Pair(current.first, current.second)
            }
        }
        result.add(resultPair)
        return result
    }
}
