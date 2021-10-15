package `data-from-csv`

import com.github.doyaaaaaken.kotlincsv.dsl.csvWriter
import org.openrndr.extra.noise.uniform

/**
 * Demonstration of a random dataset generator
 * */
fun main() {
    val numberOfPoints = 100
    val header = listOf("id", "x", "y", "radius")

    csvWriter().open("data/csv/points.csv") {
        writeRow(header)
        for (i in 0 until numberOfPoints) {
            writeRow(
                i,
                Double.uniform(0.0, 700.0),
                Double.uniform(0.0, 700.0),
                Double.uniform(5.0, 20.0)
            )
        }
    }
}