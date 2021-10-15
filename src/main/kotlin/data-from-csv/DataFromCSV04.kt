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
        val rows = csvReader() {
            delimiter = ';'
        }.readAllWithHeader(File("data/csv/NVT_Hm0_OS11b.csv"))
        extend {
            drawer.clear(ColorRGBa.WHITE)
            drawer.fill = ColorRGBa.BLACK
            drawer.stroke = ColorRGBa.PINK
            for ((index, row) in rows.withIndex()) {
                val v = row["Waarde"]!!.toDouble()
                drawer.fill = ColorRGBa.BLACK
                drawer.rectangle(40.0 + index * 2.0, height/2.0, 2.0, -v)
            }
        }
    }
}