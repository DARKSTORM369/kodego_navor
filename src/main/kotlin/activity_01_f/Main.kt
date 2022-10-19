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

    var index1 = 0
    var hasUnique = false
    var uniqueCount = 0
    while (index1 < str1.length){
        var index2 = 0
        var isUnique = true
        while(index2 < str2.length){
            if(str2[index2].equals(str1[index1], true)){
                isUnique = false
            }
            index2++
        }
        if(isUnique){
            logger.info { "Found a Unique Character: ${str1[index1].uppercase()}" }
            hasUnique = true
            uniqueCount++
        }
        index1++
    }
    if(!hasUnique){
        logger.error { "No Unique Characters has been found" }
    }else{
        logger.info { "$uniqueCount Unique Characters Found" }
    }
}