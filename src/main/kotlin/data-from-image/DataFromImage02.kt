import org.openrndr.application
import org.openrndr.draw.loadImage
import org.openrndr.extras.imageFit.imageFit

/**
 * Demonstrates loading and drawing a single image such that it fills the window
 */

fun main() = application {
    configure {
        width = 700
        height = 700
    }
    program {
        val image = loadImage("data/images/cheeta.jpg")
        extend {
            drawer.imageFit(image, drawer.bounds)
        }

    }
}