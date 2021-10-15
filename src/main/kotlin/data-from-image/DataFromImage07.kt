import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.loadImage
import org.openrndr.draw.tint
import org.openrndr.extra.noclear.NoClear
import org.openrndr.extras.color.statistics.calculateHistogramRGB
import org.openrndr.extras.imageFit.imageFit
import org.openrndr.shape.Circle
import java.io.File

/**
 * Demonstrates loading multiple images and using the image as a brush
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

        var brushImage = images[0]

        keyboard.keyDown.listen {
            brushImage = images.random()
        }

        extend(NoClear())

        extend {
            drawer.imageFit(brushImage, mouse.position.x, mouse.position.y, 40.0, 40.0)
        }
    }
}