package activity_01_d

import mu.KotlinLogging

/*
    Create an application that will accept 5 monetary amounts.

    After the input is done, the user will be asked “Divide the value by how many?”. It will only accept an Integer as input.
    The total of the 5  input will be divided by the answer in the second question input.

    Note: Error checking must be done.

    *** I still used print for readability of inputs
 */
private val logger = KotlinLogging.logger {  }
fun main() {
    var input: String?
    var value1: Double = 0.0
    var value2: Double = 0.0
    var value3: Double = 0.0
    var value4: Double = 0.0
    var value5: Double = 0.0
    var divisor: Int = 0
    var sum: Double = 0.0
    var quotient: Double
    var valid = false

    // Value Entry
    do {
        print("Enter Value 1: ")
        input = readLine().toString()
        if (input.toDoubleOrNull() == null) {
            logger.error { "Entered an invalid value. Please enter a monetary amount." }
        } else {
            value1 =input.toDouble()
            valid = true
        }
    } while (!valid)

    valid = false
    do {
        print("Enter Value 2: ")
        input = readLine().toString()
        if (input.toDoubleOrNull() == null) {
            logger.error { "Entered an invalid value. Please enter a monetary amount." }
        } else {
            value2 =input.toDouble()
            valid = true
        }
    } while (!valid)

    valid = false
    do {
        print("Enter Value 3: ")
        input = readLine().toString()
        if (input.toDoubleOrNull() == null) {
            logger.error { "Entered an invalid value. Please enter a monetary amount." }
        } else {
            value3 =input.toDouble()
            valid = true
        }
    } while (!valid)

    valid = false
    do {
        print("Enter Value 4: ")
        input = readLine().toString()
        if (input.toDoubleOrNull() == null) {
            logger.error { "Entered an invalid value. Please enter a monetary amount." }
        } else {
            value4 =input.toDouble()
            valid = true
        }
    } while (!valid)

    valid = false
    do {
        print("Enter Value 5: ")
        input = readLine().toString()
        if (input.toDoubleOrNull() == null) {
            logger.error { "Entered an invalid value. Please enter a monetary amount." }
        } else {
            value5 =input.toDouble()
            valid = true
        }
    } while (!valid)


    sum = value1 + value2 + value3 + value4 + value5
    logger.info("Total Sum of the Values = $sum")

    valid = false
    do {
        print("Divide the value by how many? ")
        input = readLine().toString()
        if (input.toIntOrNull() == null) {
            logger.error { "Entered an invalid value. Please enter a valid divisor." }
        } else {
            divisor =input.toInt()
            valid = true
        }
    } while (!valid)

    quotient = sum / divisor.toDouble()
    logger.info{"Quotient = $quotient"}
}