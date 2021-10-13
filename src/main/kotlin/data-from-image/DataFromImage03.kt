import org.openrndr.application
import org.openrndr.draw.loadImage

/**
 * Demonstrates loading and drawing a single image multiple times
 */

fun main() = application {
    configure {
        width = 700
        height = 700
    }
    program {
        val image = loadImage("data/images/cheeta.jpg")
        extend {
            for (i in 0 until 40) {
                drawer.image(image, i * 10.0, i * 10.0)
            }
        }
    }
}