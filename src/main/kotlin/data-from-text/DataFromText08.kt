import org.openrndr.application
import org.openrndr.draw.loadFont
import org.openrndr.shape.Rectangle
import org.openrndr.text.writer
import java.io.File

/**
 * This demonstrates how to count words
 */

fun main() = application {
    configure {
        width = 700
        height = 700
    }
    program {
        val counts = File("data/texts/news/bbc-002.txt")
            .readText().split(" ", "\n").groupBy { it }.mapValues { it.value.size }.toList().sortedByDescending { it.second }

        extend {
            drawer.fontMap = loadFont("data/fonts/default.otf", 18.0)
            writer {
                box = Rectangle(40.0, 40.0, width - 80.0, height - 80.0)

                for ((word, count) in counts) {
                    //text("$word $count, ")
                    text("$word, ")
                }

            }
        }
    }
}