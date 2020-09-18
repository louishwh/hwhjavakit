package top.sincerehwh.hwhjavakit.image

import java.awt.image.BufferedImage
import java.io.File
import java.net.URL
import javax.imageio.ImageIO

/**
 * @Author: louis
 * @Date: 2020/9/18 10:48 上午
 * @Version: 1.0
 * @Description:
 */
open class ImageLoader {

    companion object {
        fun loadImage(path: String): BufferedImage? {
            val url = URL(path)
            return try {
                ImageIO.read(url)
            } catch (e: Exception) {
                null
            }
        }

        fun loadLocalImage(path: String): BufferedImage? {
            return try {
                ImageIO.read(File(path))
            } catch (e: Exception) {
                null
            }
        }
    }



}