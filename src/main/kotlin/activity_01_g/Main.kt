package activity_01_g

import mu.KotlinLogging

/*
    Create an application that will accept 1 string.
    Your application will print “Palindrome” if the string is a palindrome.

    Scope :
        String
        Loops

    Ex :
        GIRAFARIG - Palindrome
        101 - Palindrome
        RACECAR - Palindrome
        GATE - Not Palindrome
 */
private val logger = KotlinLogging.logger {  }
fun main() {
    print("Input String: ")
    var text: String = readLine().toString().trim()
    if(text.isNotEmpty()) {
        var palindrome = true
        var startIndex = 0
        var endIndex = text.length - 1

        while (startIndex <= endIndex) {
            if (!text[startIndex].equals(text[endIndex], true)) {
                palindrome = false
                break
            }
            startIndex++
            endIndex--
        }
        if (palindrome) {
            logger.info { "$text is a Palindrome" }
        } else {
            logger.error { "$text is not a Palindrome" }
        }
    }else{
        logger.error { "You didn't entered an invalid input" }
    }
}