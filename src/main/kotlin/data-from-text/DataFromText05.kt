import org.openrndr.application
import org.openrndr.draw.loadFont
import org.openrndr.shape.Rectangle
import org.openrndr.text.writer
import java.io.File

/**
 * This demonstrates loading all text files
 */

fun main() = application {
    configure {
        width = 700
        height = 700
    }
    program {
        val files = File("data/texts/news").listFiles { f:File -> f.isFile }
        val texts = files.map {
            it.readText()
        }
        
        extend {
            drawer.fontMap = loadFont("data/fonts/default.otf", 18.0)
            for (text in texts) {
                writer {
                    box = Rectangle(40.0, 40.0, width - 80.0, height - 80.0)
                    text(text)
                }
            }
        }
    }
}