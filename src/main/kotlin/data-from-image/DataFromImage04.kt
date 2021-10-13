import org.openrndr.application
import org.openrndr.draw.loadImage
import org.openrndr.shape.Circle

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

            val circle = Circle(width / 2.0, height / 2.0, 300.0).contour
            val points = circle.equidistantPositions(40)
            for (point in points) {
                drawer.image(image, point.x - image.width*0.1*0.5, point.y - image.height*0.1*0.5, image.width*0.1, image.height*0.1)
            }
        }
    }
}