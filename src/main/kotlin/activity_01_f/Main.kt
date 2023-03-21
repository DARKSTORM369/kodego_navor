package activity_01_f

import mu.KotlinLogging

/**
    Scope : String, Loops

    Create an application that will accept 2 string inputs.
    Your application will print all unique characters in both Strings.
    Union of Unique characters in both Strings

    Example :
        String 1 : Bird
        String 2 : Cat
        Unique : BirdCat

    Example :
        String 1 : Bird
        String 2 : BigBird
        Unique : gBird

    Example :
        String 1 : Eat
        String 2 : Tea
        Unique : Tea

    TODO: Improve Logic
 */

private val logger = KotlinLogging.logger {  }
fun main() {
    print("Please Enter String 1: ")
    var str1: String = readLine().toString()

    print("Please Enter String 2: ")
    var str2: String = readLine().toString()

    var uniqueWord = ""
    for (char in str1 + str2){
        if(!uniqueWord.contains(char, true)){
            uniqueWord += char
        }
    }
    logger.info { "Unique: $uniqueWord" }
}