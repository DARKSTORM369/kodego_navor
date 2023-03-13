package activity_05_a_oop

import java.util.Date

/*
Scope : Use inheritance on Students

Create a person class with firstname, middlename, lastname, address and birthday.
Create a Student class that inherits the Person class. A student has a year he/she entered the school. A student has an ID.
Create a CertificateStudent, UnderGraduateStudent, MasterStudent, and GraduateStudent.

A student has different statuses
    Status : Leave of Absence, Ongoing, Graduated, Will Begin, Unknown, Shifted,

The Certificate Student has a list of short courses he or she has gotten.
    Example:
        Student 1, Computer Technician, Network Technician, Electrical Technician
        Student 2, Public Speaking, Debate, Advertising Article

The Undergraduate Student has a list of college(s) he or she belongs to, there is a year he or she joined the college,
there is a list degrees he or she is taking, there is a start and year of the degree, there is also different statuses.

Example :
Undergraduate Student 1,  College of Engineering, Bachelor of Interior Design, 2020(start), 2022(end)
Note : end will only contain a value if he or she is done with the course

The Master Student has a list of college(s) he or she belongs to, there is a year he or she joined the college,
and has name of the master degree he or she is getting.
TODO: Follow Instructions.
 */

open class Person {
    var firstName: String = ""
        private set
    var middleName: String = ""
        private set
    var lastName: String = ""
        private set
    var address: String = ""
    var birthday: Date = Date()

    constructor()
    constructor(firstName: String, middleName: String, lastName: String){
        this.firstName = firstName
        this.middleName = middleName
        this.lastName = lastName
    }
}

open class Student(firstName: String, middleName: String, lastName: String): Person(firstName, middleName, lastName){
    open var yearStarted: Int? = null
    open var yearEnded: Int? = null
    var id: Long = 0

    open fun endCourse(yearEnded: Int){
        this.yearEnded = yearEnded
    }

    constructor() : this("", "", "") //Default Constructor
    constructor(firstName: String, middleName: String, lastName: String, yearStarted: Int) : this(firstName, middleName, lastName) {
        this.yearStarted = yearStarted
    }
}

class CertificateStudent(firstName: String, middleName: String, lastName: String): Student(firstName, middleName, lastName){
    var courses: ArrayList<String> = ArrayList()

    fun addCourse(course: String){
        courses.add(course)
    }
}

class UnderGraduateStudent(firstName: String, middleName: String, lastName: String): Student(firstName, middleName, lastName){
    var courses: ArrayList<CourseTaken> = ArrayList()

    fun addCourse(course: CourseTaken){
        courses.add(course)
    }

}

class MasterStudent(firstName: String, middleName: String, lastName: String): Student(firstName, middleName, lastName){
    var courses: ArrayList<CourseTaken> = ArrayList()

    fun addCourse(course: CourseTaken){
        courses.add(course)
    }

}

class GraduateStudent(firstName: String, middleName: String, lastName: String): Student(firstName, middleName, lastName){
    var courses: ArrayList<CourseTaken> = ArrayList()

    fun addCourse(course: CourseTaken){
        courses.add(course)
    }

}

data class CourseTaken(val university: String,val course: String, val yearStarted: Int, val yearEnded: Int, var courseStatus: CourseStatus = CourseStatus.UNKNOWN)

enum class CourseStatus{
    LEAVE_OF_ABSENCE,
    ONGOING,
    GRADUATED,
    WILL_BEGIN,
    UNKNOWN,
    SHIFTED
}

fun main() {

}