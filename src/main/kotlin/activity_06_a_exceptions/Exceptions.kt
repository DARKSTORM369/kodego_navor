package activity_06_a_exceptions

import mu.KotlinLogging

/*
Using Activity 05 A (???)

Create a function that will check the student's grade.
The function will accept an array with 10 entries only. It will throw the following exceptions
    if the array size is greater than 10 throw invalid input
    if the array contains 0 throw incomplete grades
 */
private val logger = KotlinLogging.logger{}
sealed class GradesException(message: String): Exception(message){
    class EmptyGrades(message: String = "Empty List of Grades"): GradesException(message)
    class GradesOutOfBounds(message: String = "Invalid Number of Grades"): GradesException(message)
    class IncompleteGrades(message: String = "Incomplete Grades"): GradesException(message)
}
class GradeChecker {
    fun checkGrades(grades: ArrayList<Int>){
        if (grades.size == 0){
            throw GradesException.EmptyGrades()
        }else if (grades.size > 10){
            throw GradesException.GradesOutOfBounds()
        }else if (grades.contains(0)){
            throw GradesException.IncompleteGrades()
        }else{
            logger.info { "Grades OK" }
        }
    }
}