import org.openrndr.application
import org.openrndr.extra.noclear.NoClear
import org.openrndr.extras.imageFit.imageFit
import org.openrndr.ffmpeg.loadVideo
import org.openrndr.math.mod_

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
                val y = ((seconds * 25.0).toInt())/width
                val x = (seconds * 25.0).mod_(width.toDouble())
                drawer.image(cb, x, y * 180.0 )
            }
        }
    }
}
