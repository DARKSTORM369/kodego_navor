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
    var uniqueChars1: String = ""
    var uniqueChars2: String = ""

    var uniqueCount = 0

    for(char1 in str1){
        var isUnique = true
        for(char2 in str2){
            if(char2.equals(char1, true)){
                isUnique = false
            }else{
                for(unique in uniqueChars){
                    if(unique.equals(char1,true)){
                        isUnique = false
                    }
                }
            }
        }
        if(isUnique){
            logger.info { "Found a Unique Character: ${char1.uppercase()}" }
            uniqueChars += char1
            uniqueChars1 += char1
            uniqueCount++
        }
    }

    for(char1 in str2){
        var isUnique = true
        for(char2 in str1){
            if(char1.equals(char2, true)){
                isUnique = false
            }else{
                for(unique in uniqueChars){
                    if(unique.equals(char2,true)){
                        isUnique = false
                    }
                }
            }
        }
        if(isUnique){
            logger.info { "Found a Unique Character: ${char1.uppercase()}" }
            uniqueChars += char1
            uniqueChars2 += char1
            uniqueCount++
        }
    }

    if(uniqueCount > 0){
        logger.info { "$uniqueCount Unique Characters Found: $uniqueChars" }
        logger.info { "String 1: ${uniqueChars1.uppercase()}" }
        logger.info { "String 2: ${uniqueChars2.uppercase()}" }
    }else{
        logger.error { "No Unique Characters has been found" }
    }
}