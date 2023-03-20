package activity_01_h

import mu.KotlinLogging

/*
    Create an application that will accept 2 Integers.
    It will identify the lower value and bigger value of the two inputs.
    Then, your application will print all the prime numbers starting from the lower number up to the largest number.

    Scope :
        String
        Loops

    Input:
        1, 4 -> 1, 2, 3
        10 -> 1, 2, 3, 5, 7
    TODO: Unit Testing
        Put Break
 */
private val logger = KotlinLogging.logger {  }
fun main() {
    var int1 = 0
    var int2 = 0
    var min: Int
    var max: Int
    var input: String
    var valid = false
    var prime = ""

    // 1st Integer
    do {
        print("Input 1st Integer: ")
        input = readLine().toString()
        if (input.toIntOrNull() == null) {
            logger.error { "Entered an invalid value. Please enter an Integer." }
        } else {
            int1 = input.toInt()
            valid = true
        }
    } while (!valid)

    // 2nd Integer
    valid = false
    do {
        print("Input 2nd Integer: ")
        input = readLine().toString()
        if (input.toIntOrNull() == null) {
            logger.error { "Entered an invalid value. Please enter an Integer." }
        } else {
            int2 = input.toInt()
            valid = true
        }
    } while (!valid)

    if(int1 < int2){
        min = int1
        max = int2
    }else if(int1 > int2){
        min = int2
        max = int1
    }else{
        logger.error { "No minimum or maximum value. Cannot proceed with the program" }
        return
    }

    logger.info { "Lowest Value is $min" }
    logger.info { "Highest Value is $max" }

    while(min <= max){
        var div = 1
        var divisors = 0
        var remainder = 0
        while (div <= min){ //TODO: If Divisors > 2, Next
            remainder = min % div
            if(remainder == 0){
                divisors++
            }
            div++
            //
        }
        if(divisors < 3){
            if(prime.isNotEmpty()) { prime += ", " }

            prime += "$min"
        }
        min++
    }
    if(prime.isNotEmpty()){
        logger.info { "Prime Numbers: $prime" }
    }else{
        logger.error { "No Prime Numbers Found!" }
    }
}