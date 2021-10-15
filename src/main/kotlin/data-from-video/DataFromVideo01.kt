import org.openrndr.application
import org.openrndr.extras.imageFit.imageFit
import org.openrndr.ffmpeg.loadVideo

fun main() = application {
    program {
        val video = loadVideo("data/video/nos.mp4")
        video.play()
        extend {
            video.draw(drawer, blind = true)
            val cb = video.colorBuffer
            if (cb != null) {
                drawer.imageFit(cb, drawer.bounds)
            }
        }
    }
}
