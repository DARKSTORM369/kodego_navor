package activity_01_d
/*
    Create an application that will accept 5 monetary amounts.

    After the input is done, the user will be asked “Divide the value by how many?”. It will only accept an Integer as input.
    The total of the 5  input will be divided by the answer in the second question input.

    Note: Error checking must be done.
 */
fun main() {
    var value1: Double? = null
    var value2: Double? = null
    var value3: Double? = null
    var value4: Double? = null
    var value5: Double? = null
    var divisor: Int? = null
    var sum: Int = 0
    var quotient: Double? = null

    // Value Entry
    print("Enter Value 1: ")
    value1 = readLine()?.let {
        if (it.toDoubleOrNull() == null) {
            println("Entered an invalid value. Value is considered as 0.0")
            return@let 0.0
        }else{
            it.toDouble()
        }
    } ?: 0.0

    print("Enter Value 2: ")
    value2 = readLine()?.let {
        if (it.toDoubleOrNull() == null) {
            println("Entered an invalid value. Value is considered as 0.0")
            return@let 0.0
        }else{
            it.toDouble()
        }
    } ?: 0.0

    print("Enter Value 3: ")
    value3 = readLine()?.let {
        if (it.toDoubleOrNull() == null) {
            println("Entered an invalid value. Value is considered as 0.0")
            return@let 0.0
        }else{
            it.toDouble()
        }
    } ?: 0.0

    print("Enter Value 4: ")
    value4 = readLine()?.let {
        if (it.toDoubleOrNull() == null) {
            println("Entered an invalid value. Value is considered as 0.0")
            return@let 0.0
        }else{
            it.toDouble()
        }
    } ?: 0.0

    print("Enter Value 5: ")
    value5 = readLine()?.let {
        if (it.toDoubleOrNull() == null) {
            println("Entered an invalid value. Value is considered as 0.0")
            return@let 0.0
        }else{
            it.toDouble()
        }
    } ?: 0.0

    sum = value1 + value2 + value3 + value4 + value5
    println("Total Sum of the Values = $sum")

    print("Divide the value by how many? ")
    divisor = readLine()?.let {
        if (it.toIntOrNull() == null) {
            println("Entered an invalid value. Value is considered as 0")
            return@let 0
        }else{
            it.toInt()
        }
    } ?: 0

    quotient = sum / divisor.toDouble()
    print("Quotient = $quotient")
}