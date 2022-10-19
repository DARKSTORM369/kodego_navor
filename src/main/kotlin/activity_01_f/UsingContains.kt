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

    var uniqueChars: String = ""

    var index = 0
    var hasUnique = false
    var uniqueCount = 0
    while (index < str1.length){
        if(!str2.contains(str1[index], true) && !uniqueChars.contains(str1[index], true)){
            logger.info { "Found a Unique Character: ${str1[index].uppercase()}" }
            uniqueChars += str1[index]
            hasUnique = true
            uniqueCount++
        }
        index++
    }
    index = 0
    while(index < str2.length){
        if(!str1.contains(str2[index], true) && !uniqueChars.contains(str2[index], true)){
            logger.info { "Found a Unique Character: ${str2[index].uppercase()}" }
            uniqueChars += str2[index]
            hasUnique = true
            uniqueCount++
        }
        index++
    }
    if(!hasUnique){
        logger.error { "No Unique Characters has been found" }
    }else{
        logger.info { "$uniqueCount Unique Characters Found: $uniqueChars" }
    }
}