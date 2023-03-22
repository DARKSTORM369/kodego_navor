package activity_07_a

import mu.KotlinLogging

/** TODO:
 *  Create a unit test to check if the function created in Activity 06 - A Exception will produce the expected behaviors.
    Add the following functionalities for Grade Checking

    It will get the average of the array

    if average is
        ≥ 94 grade is 4.0
        ≥ 89 grade is 3.5
        ≥ 83 grade is 3.0
        ≥ 78 grade is 2.5
        ≥ 72 grade is 2.0
        ≥ 66 grade is 1.5
        ≥ 60 grade is 1.0
        < 60 grade is 0.0

    Note :
    the array should only contain values 0.0 .. 100
    the array can only contain 10 entries

    create unit tests to validate the behavior of function for checking grade
 */
val logger = KotlinLogging.logger {  }
sealed class GradesException(message: String): Exception(message){
    class EmptyGrades(message: String = "Empty List of Grades"): GradesException(message)
    class GradesOutOfBounds(message: String = "Invalid Number of Grades"): GradesException(message)
    class IncompleteGrades(message: String = "Incomplete Grades"): GradesException(message)
    class InvalidGrades(message: String = "Invalid Grade Values"): GradesException(message)
}
class GradeChecker {
    fun checkGrades(grades: ArrayList<Int>){
        if (grades.size == 0){
            throw GradesException.EmptyGrades()
        }else if (grades.size > 10){
            throw GradesException.GradesOutOfBounds()
        }else if(grades.contains(0)){
            throw GradesException.IncompleteGrades()
        }else if(grades.min() < 0 || grades.max() > 100){
            throw GradesException.InvalidGrades()
        }else{
            when(grades.average()){
                in 94.0..100.0 -> logger.info { "Grade is 4.0" }
                in 89.0..93.0 -> logger.info { "Grade is 3.5" }
                in 83.0..88.0 -> logger.info { "Grade is 3.0" }
                in 78.0..82.0 -> logger.info { "Grade is 2.5" }
                in 72.0..77.0 -> logger.info { "Grade is 2.0" }
                in 66.0..71.0 -> logger.info { "Grade is 1.5" }
                in 60.0..65.0 -> logger.info { "Grade is 1.0" }
                else -> logger.info { "Grade is 0.0" }
            }
        }
    }
}