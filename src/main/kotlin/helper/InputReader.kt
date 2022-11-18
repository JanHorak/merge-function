package helper

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import interval.Pair
import java.io.File

/**
 * Helping class for reading in a file consists the test data array and parsing to
 * a list of Pairs. The output can be used as input of the merge-function.
 *
 * The mandatory given structure of the JSON file is an array of integer arrays.
 *
 * E.g. Input file content
 * [
 *    [22, 55],
 *    [2, 83],
 *    [-4, 10]
 * ]
 *
 * Note: class not tested because of purpose
 */
class InputReader {

    /**
     * Reads a json file located in resources folder and converts it to a list of pairs.
     * If a single interval array contains more than two values just the first and second will be picked.
     *
     * @param file - input file located in resources folder
     * @return List<Pair> - parsed Pairs based on the input file
     */
    fun readInputs(file: File): List<Pair>? = this::class.java.getResource(file.path)?.let {
        ObjectMapper().readValue(it.readText(), object : TypeReference<List<List<Int>>>() {}).map {
            Pair(it[0], it[1])
        }
    }
}
