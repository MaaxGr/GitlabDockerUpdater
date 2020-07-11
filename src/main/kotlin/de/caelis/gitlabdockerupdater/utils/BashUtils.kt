package de.caelis.gitlabdockerupdater.utils

import java.io.BufferedReader
import java.io.InputStreamReader


object BashUtils {

    fun executeCommand(cmd: String, outputStream: (String) -> Unit = {}): String {
        val commands = listOf("bash", "-c", cmd)

        val pb: ProcessBuilder = ProcessBuilder(commands)
            .redirectErrorStream(true)

        val process = pb.start()
        val result = StringBuilder(80)
        BufferedReader(InputStreamReader(process.inputStream)).use { input ->
            while (true) {
                val line = input.readLine() ?: break
                outputStream(line)
                result.append(line).append(System.lineSeparator())
            }
        }
        return result.toString()
    }

}
