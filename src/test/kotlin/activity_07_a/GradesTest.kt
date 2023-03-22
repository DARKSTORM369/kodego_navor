package activity_07_a

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.random.Random

internal class GradesTest {
    private val gradeChecker = GradeChecker()

    @Test
    fun checkGradesChecker(){
        val gradesOutOfBounds: ArrayList<Int> = ArrayList()
        for(index in 0 until 11){
            gradesOutOfBounds.add(Random.nextInt(1, 101))
        }

        val incompleteGrades: ArrayList<Int> = ArrayList()
        incompleteGrades.add(0)
        for(index in 0 until 9){
            incompleteGrades.add(Random.nextInt(0, 200))
        }

        val invalidGrades: ArrayList<Int> = ArrayList()
        invalidGrades.add(Int.MIN_VALUE)
        for(index in 0 until 9){
            invalidGrades.add(Random.nextInt(-100, 200))
        }

        assertThrows<GradesException>{
            gradeChecker.checkGrades(gradesOutOfBounds)
            gradeChecker.checkGrades(incompleteGrades)
            gradeChecker.checkGrades(invalidGrades)
        }
        assertThrows<GradesException.GradesOutOfBounds> {
            gradeChecker.checkGrades(gradesOutOfBounds)
        }
        assertThrows<GradesException.IncompleteGrades> {
            gradeChecker.checkGrades(incompleteGrades)
        }
        assertThrows<GradesException.InvalidGrades> {
            gradeChecker.checkGrades(invalidGrades)
        }
    }
}