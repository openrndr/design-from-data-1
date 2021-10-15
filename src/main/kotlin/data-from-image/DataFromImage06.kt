import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.loadImage
import org.openrndr.draw.tint
import org.openrndr.extras.color.statistics.calculateHistogramRGB
import org.openrndr.extras.imageFit.imageFit
import org.openrndr.shape.Circle
import java.io.File

/**
 * Demonstrates loading multiple images and blending them together
 */

fun main() = application {
    configure {
        width = 700
        height = 700
    }
    program {
        val images = File("data/images/bbc/").listFiles()
            .filter { it.isFile && !it.isHidden }
            .map { loadImage(it) }

        extend {
            drawer.clear(ColorRGBa.BLACK)
            for (image in images) {
                drawer.drawStyle.colorMatrix = tint(ColorRGBa.WHITE.opacify(1.0/images.size))
                drawer.imageFit(image, drawer.bounds)
            }
        }
    }
}