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
TODO: Follow Instructions -> Review
 */


open class Course{
    var fieldOfStudy: String = ""
    var degree: String = ""

    constructor()
    constructor(fieldOfStudy: String){
        this.fieldOfStudy = fieldOfStudy
    }
    constructor(degree: String, fieldOfStudy: String){
        this.fieldOfStudy = fieldOfStudy
        this.degree = degree
    }
}

class ShortCourse(fieldOfStudy: String): Course(fieldOfStudy)

class CollegeCourse(degree: String, fieldOfStudy: String): Course(degree, fieldOfStudy)

enum class StudentStatus{
    LEAVE_OF_ABSENCE,
    ONGOING,
    GRADUATED,
    WILL_BEGIN,
    UNKNOWN,
    SHIFTED
}

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
    constructor(firstName: String, lastName: String){
        this.firstName = firstName
        this.lastName = lastName
    }
}

open class Student(firstName: String, lastName: String): Person(firstName, lastName){
    var yearStarted: Int? = null
    var yearEnded: Int? = null
    var id: Long = 0
    var status: StudentStatus = StudentStatus.UNKNOWN
    val courses: ArrayList<Course> = ArrayList()

    fun startCourse(yearStarted: Int){
        this.yearStarted = yearStarted
    }

    fun endCourse(yearEnded: Int){
        this.yearEnded = yearEnded
    }

    constructor() : this("", "") //Default Constructor
    constructor(firstName: String, lastName: String, yearStarted: Int) : this(firstName, lastName) {
        this.yearStarted = yearStarted
    }
}

class CertificateStudent(firstName: String, lastName: String): Student(firstName, lastName){
    fun addCourse(course: ShortCourse){
        courses.add(course)
    }
}

enum class Colleges{
    ENGINEERING,
    TEACHER_EDUCATION,
    ARTS_AND_SCIENCES,
    UNKNOWN
}

class UnderGraduateStudent(firstName: String, lastName: String): Student(firstName, lastName){
    val colleges: ArrayList<Colleges> = ArrayList()

    fun addCourse(course: CollegeCourse){
        courses.add(course)
    }

}

class MasterStudent(firstName: String, lastName: String): Student(firstName, lastName){

    fun addCourse(course: CollegeCourse){
        courses.add(course)
    }

}

class GraduateStudent(firstName: String, lastName: String): Student(firstName, lastName){

    fun addCourse(course: CollegeCourse){
        courses.add(course)
    }

}

fun main() {

}