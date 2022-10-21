package activity_02_d

import mu.KotlinLogging

/*
    Create an application that will accept 5 monetary amounts.

    After the input is done, the user will be asked “Divide the value by how many?”. It will only accept an Integer as input.
    The total of the 5  input will be divided by the answer in the second question input.

    Note: Error checking must be done.

    *** I still used print for readability of inputs

    # Update
    Implemented Data Structures
    activity_01_d
 */

private val logger = KotlinLogging.logger {  }
fun main() {
    var amounts: Array<Double> = Array(5){0.0}
    var input: String?
    var index = 0
    var divisor: Int? = null
    var sum: Double = 0.0
    var quotient: Double? = null

    // Value Entry
    do {
        print("Enter Value ${index+1}: ")
        input = readLine().toString()
        if (input.toDoubleOrNull() == null) {
            logger.error { "Entered an invalid value. Please enter a monetary amount." }
        } else {
            amounts[index++] = input.toDouble()
        }
    } while (index < amounts.size)

    sum = amounts.sum()
    logger.info("Total Sum of the Values = $sum")

    do {
        print("Divide the value by how many? ")
        input = readLine().toString()
        if (input.toIntOrNull() == null) {
            logger.error { "Entered an invalid value. Please enter a valid divisor." }
        } else {
            divisor = input.toInt()
        }
    } while (divisor == null)

    quotient = sum / divisor.toDouble()
    logger.info{"Quotient = $quotient"}
}