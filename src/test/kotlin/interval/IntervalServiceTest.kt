package interval

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class IntervalServiceTest {

    @Test
    fun `merge function should return reduce overlapping and sorted intervals`() {
        // Testsetup
        val testinput = listOf(
            Pair(25, 30),
            Pair(2, 19),
            Pair(14, 23),
            Pair(4, 8),
            Pair(-3, 1)
        )
        val expectedResult = listOf(
            Pair(-3, 1),
            Pair(2, 23),
            Pair(25, 30)
        )

        // Defining class under test
        val cut = IntervalService()

        // Execution
        val result = cut.merge(testinput)

        // Assertion
        assertEquals(expectedResult, result)
    }

    @Test
    fun `empty input should return an empty list`() {
        // Defining class under test
        val cut = IntervalService()

        // Execution
        val result = cut.merge(emptyList())

        // Assertion
        assertEquals(emptyList<Pair>(), result)
    }
}
