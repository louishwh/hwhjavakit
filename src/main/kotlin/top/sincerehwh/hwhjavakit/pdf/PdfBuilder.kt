package top.sincerehwh.hwhjavakit.pdf

import com.itextpdf.html2pdf.ConverterProperties
import com.itextpdf.html2pdf.HtmlConverter
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider
import com.itextpdf.io.font.FontProgram
import com.itextpdf.io.font.FontProgramFactory
import com.itextpdf.layout.font.FontProvider
import org.apache.pdfbox.io.MemoryUsageSetting
import org.apache.pdfbox.multipdf.PDFMergerUtility
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream

open class PdfBuilder {

    companion object {

        private val FONTS = arrayOf(
                "./src/main/resources/fonts/NotoSansCJKsc-Regular.otf",
                "./src/main/resources/fonts/NotoSansCJKtc-Regular.otf",
                "./src/main/resources/fonts/NotoSansCJKhk-Regular.otf"
        )

        fun combineAndGenerate(files: List<File>, targetPath: String?): Boolean {
            try {
                val mergePdf = PDFMergerUtility()
                for (f in files) if (f.exists() && f.isFile) mergePdf.addSource(f)
                mergePdf.destinationFileName = targetPath
                mergePdf.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly())
            } catch (e: Exception) {
                e.printStackTrace()
                return false
            }
            return true
        }


        fun generateOnePage(content: String, savedPath: String) {
            try {
                val properties = ConverterProperties()
                val fontProvider: FontProvider = DefaultFontProvider()
                for (font in FONTS) {
                    val fp: FontProgram = FontProgramFactory.createFont(font)
                    fontProvider.addFont(fp)
                }
                properties.fontProvider = fontProvider
                val outputStream: OutputStream = FileOutputStream(savedPath)
                HtmlConverter.convertToPdf(content, outputStream, properties)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}
