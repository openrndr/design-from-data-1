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
        for (row in rows) {
            println(row["Waarde"])
        }
        extend {
            drawer.clear(ColorRGBa.WHITE)
            drawer.fill = ColorRGBa.BLACK
            drawer.stroke = ColorRGBa.PINK
            for (i in 0 until 55) {
                for ((index, row) in rows.withIndex()) {
                    val v = row["Waarde"]!!.toDouble()
                    drawer.fill = ColorRGBa.BLACK
                    drawer.circle(40.0 + index * 2.2, height / 4.0 - v + i * 10.0, 14.0)
                }
            }
        }
    }
}