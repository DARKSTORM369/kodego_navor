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
    var text: String = readLine().toString()
    var reverse = ""
    var index = text.length-1

    while (index >= 0){
        reverse += text[index]
        index--
    }
    if(text.equals(reverse, true)){
        logger.info { "$text is a Palindrome" }
    }else{
        logger.error { "$text is not a Palindrome" }
    }
}