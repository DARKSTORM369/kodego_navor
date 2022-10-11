package activity_01_d
/*
    Create an application that will accept 5 monetary amounts.

    After the input is done, the user will be asked “Divide the value by how many?”. It will only accept an Integer as input.
    The total of the 5  input will be divided by the answer in the second question input.

    Note: Error checking must be done.
 */
fun main() {
    var value1: Int? = null
    var value2: Int? = null
    var value3: Int? = null
    var value4: Int? = null
    var value5: Int? = null
    var divisor: Int? = null
    var sum: Int = 0
    var quotient: Double? = null

    // Value Entry
    print("Enter Value 1: ")
    value1 = readLine()?.let {
        if (it == "" || it in "A" .. "~") {
            println("Entered an invalid value. Value is considered as 0")
            return@let 0
        }else{
            it.toInt()
        }
    } ?: 0

    print("Enter Value 2: ")
    value2 = readLine()?.let {
        if (it == "" || it in "A" .. "~") {
            println("Entered an invalid value. Value is considered as 0")
            return@let 0
        }else{
            it.toInt()
        }
    } ?: 0

    print("Enter Value 3: ")
    value3 = readLine()?.let {
        if (it == "" || it in "A" .. "~") {
            println("Entered an invalid value. Value is considered as 0")
            return@let 0
        }else{
            it.toInt()
        }
    } ?: 0

    print("Enter Value 4: ")
    value4 = readLine()?.let {
        if (it == "" || it in "A" .. "~") {
            println("Entered an invalid value. Value is considered as 0")
            return@let 0
        }else{
            it.toInt()
        }
    } ?: 0

    print("Enter Value 5: ")
    value5 = readLine()?.let {
        if (it == "" || it in "A" .. "~") {
            println("Entered an invalid value. Value is considered as 0")
            return@let 0
        }else{
            it.toInt()
        }
    } ?: 0

    sum = value1 + value2 + value3 + value4 + value5
    println("Total Sum of the Values = $sum")

    print("Divide the value by how many? ")
    divisor = readLine()?.let {
        if (it == "" || it in "A" .. "~") {
            println("Entered an invalid value. Value is considered as 0")
            return@let 0
        }else{
            it.toInt()
        }
    } ?: 0

    quotient = sum.toDouble() / divisor.toDouble()
    print("Quotient = $quotient")
}