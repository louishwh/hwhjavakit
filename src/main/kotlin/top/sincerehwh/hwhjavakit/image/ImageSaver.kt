package top.sincerehwh.hwhjavakit.image

import java.awt.image.BufferedImage
import java.io.FileOutputStream
import javax.imageio.ImageIO

/**
 * @Author: louis
 * @Date: 2020/9/18 10:50 上午
 * @Version: 1.0
 * @Description:
 */
open class ImageSaver {

    companion object {
        open fun saveImage(image: BufferedImage, path: String, format: String="JPEG") {
            try {
                ImageIO.write(image, format, FileOutputStream(path))
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }



}