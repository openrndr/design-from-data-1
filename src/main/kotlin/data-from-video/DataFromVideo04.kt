import org.openrndr.application
import org.openrndr.extra.noclear.NoClear
import org.openrndr.extras.imageFit.imageFit
import org.openrndr.ffmpeg.loadVideo
import org.openrndr.math.mod_
import org.openrndr.shape.Circle

fun main() = application {
    configure {
        width = 700
        height = 700
    }
    program {
        val video = loadVideo("data/video/nos.mp4")
        video.play()
        extend(NoClear())
        extend {
            video.draw(drawer, blind = true)
            val cb = video.colorBuffer
            if (cb != null) {

                val c = Circle(width/2.0, height/2.0, 300.0).contour
                val position = c.position((seconds * 0.1).mod_(1.0))

                drawer.image(cb, position.x - cb.width * 0.25 * 0.5,position.y - cb.height * 0.25 * 0.5, cb.width * 0.25, cb.height * 0.25)
            }
        }
    }
}
