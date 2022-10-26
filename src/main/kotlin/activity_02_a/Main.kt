package activity_02_a

import java.time.LocalDateTime
import java.time.Month
import java.util.Date

/*
    You are tasked to create a directory of the students taking this course.
    The data will be used to send updates regarding the classes.
    There is also a need to know the progress of the students during the progress of this course.

    List down all data that can be used to implement this. Use the proper data types.

    Implement Activity 01 -  A using data structure.
 */

fun main() {
    // Student Information
    var courseName: String
    var batchNumber: String
    var firstName: String
    var lastName: String
    var gender: String
    var birthDate: Date
    var age: Int

    // Attendance Records
    var classDates: ArrayList<String>
    var attendance: ArrayList<String>

    // Activity Records
    var employmentApplicationFormsSubmitted: ArrayList<Boolean>
    var employmentApplicationFormSubmittedDates: ArrayList<Date?>
    var employmentApplicationFormDueDates: ArrayList<Date?>
    var employmentApplicationFormScores: ArrayList<Int?>
    var employmentApplicationFormRemarks: ArrayList<String?>

    //Alternative
    var activities: ArrayList<Any> // Used Activity Class to store datasets

}

data class Activity(
    val activityName: String,
    val activityTitle: String,
    var submitted: Boolean = false,
    var dateSubmitted: Date?,
    var dueDate: Date?,
    var score: Int?,
    var remarks: String?
)