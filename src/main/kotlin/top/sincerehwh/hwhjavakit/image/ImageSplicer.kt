package top.sincerehwh.hwhjavakit.image

import java.awt.image.BufferedImage

/**
 * @Author: louis
 * @Date: 2020/9/18 10:52 上午
 * @Version: 1.0
 * @Description:
 */
open class ImageSplicer {

    companion object {

        open fun combineImage(fImage: BufferedImage, sImage: BufferedImage, isHorizontal: Boolean=true): BufferedImage {
            val fW = fImage.getWidth()
            val fH = fImage.getHeight()
            val sW = sImage.getWidth()
            val sH = sImage.getHeight()

            var fImageArray = IntArray(fH * fW)
            fImageArray = fImage.getRGB(0,0, fW, fH, fImageArray, 0, fW)

            var sImageArray = IntArray(sH * sW)
            sImageArray = sImage.getRGB(0,0, sW, sH, sImageArray, 0, sW)

            return  when {
                isHorizontal -> {
                    val imageH = if(fH > sH) fH else sH
                    val image = BufferedImage(fW+sW, imageH, BufferedImage.TYPE_INT_RGB)
                    image.setRGB(0,0,fW, fH, fImageArray, 0, fW)
                    image.setRGB(fW,0,sW, sH, sImageArray, 0, sW)
                    image
                }
                else -> {
                    val imageW = if(fW > sW) fW else sW
                    val image = BufferedImage(imageW, fH+sH, BufferedImage.TYPE_INT_RGB)
                    image.setRGB(0,0,fW, fH, fImageArray, 0, fW)
                    image.setRGB(0, fH, sW, sH, sImageArray, 0, sW)
                    image
                }
            }
        }

    }

}


