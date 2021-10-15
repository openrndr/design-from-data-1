import org.openrndr.application
import org.openrndr.draw.loadImage
import org.openrndr.extras.color.statistics.calculateHistogramRGB
import org.openrndr.shape.Circle

/**
 * Demonstrates obtaining the dominant colors from an image
 */

fun main() = application {
    configure {
        width = 600
        height = 600
    }
    program {
        val image = loadImage("data/images/cheeta.jpg")

        val histogram = calculateHistogramRGB(image)
        val dominantColors = histogram.sortedColors()

        extend {
            for (y in 0 until 20) {
                for (x in 0 until 20) {
                    drawer.fill = dominantColors[y*20+x].first
                    drawer.rectangle(x * 30.0, y * 30.0, 30.0, 30.0)
                }
            }
        }
    }
}