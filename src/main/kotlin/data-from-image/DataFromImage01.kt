import org.openrndr.application
import org.openrndr.draw.loadImage

/**
 * Demonstrates loading and drawing a single image
 */

fun main() = application {
    configure {
        width = 700
        height = 700
    }
    program {
        val image = loadImage("data/images/cheeta.jpg")
        extend {
            drawer.image(image)
        }

    }
}