import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import org.openrndr.application
import org.openrndr.color.ColorRGBa
import java.io.File

/**
 * Demonstration of loading data from CSV and drawing it as points
 */

fun main() = application {
    configure {
        width = 700
        height = 700
    }
    program {
        val rows = csvReader().readAllWithHeader(File("data/csv/points.csv"))
        extend {
            drawer.clear(ColorRGBa.WHITE)
            drawer.fill = ColorRGBa.BLACK
            drawer.stroke = ColorRGBa.PINK
            for (row in rows) {
                drawer.fill = ColorRGBa.BLACK
                val x = row["x"]!!.toDouble()
                val y = row["y"]!!.toDouble()
                val radius = row["radius"]!!.toDouble()
                drawer.circle(x, y, radius)
                drawer.fill = ColorRGBa.GREEN
                drawer.text(row["id"]!!, x, y)
            }
        }
    }
}