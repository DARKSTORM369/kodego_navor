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

    var index1 = 0
    var hasUnique = false
    var uniqueCount = 0
    while (index1 < str1.length){
        var index2 = 0
        var isUnique = true
        while(index2 < str2.length){
            if(str2[index2].equals(str1[index1], true)){
                isUnique = false
            }else{
                var index3 = 0
                while (index3 < uniqueChars.length){
                    if(uniqueChars[index3].equals(str1[index1],true)){
                        isUnique = false
                    }
                    index3++
                }
            }
            index2++
        }
        if(isUnique){
            logger.info { "Found a Unique Character: ${str1[index1].uppercase()}" }
            uniqueChars += str1[index1]
            hasUnique = true
            uniqueCount++
        }
        index1++
    }

    index1 = 0
    while (index1 < str2.length){
        var index2 = 0
        var isUnique = true
        while(index2 < str1.length){
            if(str2[index1].equals(str1[index2], true)){
                isUnique = false
            }else{
                var index3 = 0
                while (index3 < uniqueChars.length){
                    if(uniqueChars[index3].equals(str1[index2],true)){
                        isUnique = false
                    }
                    index3++
                }
            }
            index2++
        }
        if(isUnique){
            logger.info { "Found a Unique Character: ${str2[index1].uppercase()}" }
            uniqueChars += str2[index1]
            hasUnique = true
            uniqueCount++
        }
        index1++
    }
    if(!hasUnique){
        logger.error { "No Unique Characters has been found" }
    }else{
        logger.info { "Found $uniqueCount Unique Characters from both Strings: $uniqueChars" }
    }
}