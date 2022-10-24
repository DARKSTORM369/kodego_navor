package activity_01_f

import mu.KotlinLogging

/*
    Create an application that will accept 2 string inputs.
    Your application will print all unique characters in both Strings.

    Scope :
        String
        Loops
 */

private val logger = KotlinLogging.logger {  }
fun main() {
    print("Please Enter String 1: ")
    var str1: String = readLine().toString()

    print("Please Enter String 2: ")
    var str2: String = readLine().toString()

    var uniqueChars1: String = ""
    var uniqueChars2: String = ""

    var uniqueCount = 0

    for(char in str1){
        if(!str2.contains(char, true) && !uniqueChars1.contains(char, true) && !uniqueChars2.contains(char, true)){
            uniqueChars1 += char
            uniqueCount++
        }
    }

    for(char in str2){
        if(!str1.contains(char, true) && !uniqueChars1.contains(char, true) && !uniqueChars2.contains(char, true)){
            uniqueChars2 += char
            uniqueCount++
        }
    }

    if(uniqueCount > 0){
        logger.info { "Found $uniqueCount Unique Characters from both Strings" }
        logger.info { "String 1: ${uniqueChars1.uppercase()}" }
        logger.info { "String 2: ${uniqueChars2.uppercase()}" }
    }else{
        logger.error { "No Unique Characters has been found" }
    }
}