package de.caelis.gitlabdockerupdater.constants

object ConsoleColor {

    const val ANSI_RESET = "\u001B[0m"
    const val ANSI_BLACK = "\u001B[30m"
    const val ANSI_RED = "\u001B[31m"
    const val ANSI_GREEN = "\u001B[32m"
    const val ANSI_YELLOW = "\u001B[33m"
    const val ANSI_BLUE = "\u001B[34m"
    const val ANSI_PURPLE = "\u001B[35m"
    const val ANSI_CYAN = "\u001B[36m"
    const val ANSI_WHITE = "\u001B[37m"

    // Bold
    const val BLACK_BOLD = "\u001b[1;30m" // BLACK
    const val RED_BOLD = "\u001b[1;31m" // RED
    const val GREEN_BOLD = "\u001b[1;32m" // GREEN
    const val YELLOW_BOLD = "\u001b[1;33m" // YELLOW
    const val BLUE_BOLD = "\u001b[1;34m" // BLUE
    const val PURPLE_BOLD = "\u001b[1;35m" // PURPLE
    const val CYAN_BOLD = "\u001b[1;36m" // CYAN
    const val WHITE_BOLD = "\u001b[1;37m" // WHITE

    fun yellowBold(string: String): String {
        return "$YELLOW_BOLD$string$ANSI_RESET"
    }

}