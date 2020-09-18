package top.sincerehwh.hwhjavakit.file

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException

/**
 * @Author: louis
 * @Date: 2020/9/18 10:56 上午
 * @Version: 1.0
 * @Description:
 */
open class FileManager {

    companion object {

        fun fileString(fileName: String): String? {
            val file = File(fileName)
            val buffer = StringBuffer()
            val fileReader = FileReader(file)
            val reader = BufferedReader(fileReader)

            return try {
                while (true) {
                    val line = reader.readLine() ?: break
                    buffer.append(line)
                }
                reader.close()
                buffer.toString()
            } catch (e: IOException) {
                e.printStackTrace()
                reader.close()
                null
            }
        }

    }

}