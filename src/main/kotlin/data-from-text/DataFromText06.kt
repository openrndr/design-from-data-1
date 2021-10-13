import org.openrndr.application
import org.openrndr.draw.loadFont
import org.openrndr.shape.Rectangle
import org.openrndr.text.writer
import java.io.File

/**
 * This demonstrates how to sort all the characters in a text
 */

fun main() = application {
    configure {
        width = 700
        height = 700
    }
    program {
        val text = File("data/texts/news/bbc-002.txt")
            .readText()
            .map { it }
            .filter { it != '\n' && it != ' ' }
            .sorted()
            .joinToString(" ")

        extend {
            drawer.fontMap = loadFont("data/fonts/default.otf", 18.0)
            writer {
                box = Rectangle(40.0, 40.0, width - 80.0, height - 80.0)
                text(text)
            }
        }
    }
}