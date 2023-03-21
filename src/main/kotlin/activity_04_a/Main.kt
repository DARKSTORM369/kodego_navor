package activity_04_a

import mu.KotlinLogging
import java.util.Date

/*
Covered Topic(s) : Classes

Instructions :

1. Use class to represent the student rather string.Make sure the student has a firstName, lastName, nickName, id and year enrolled
2. Update the searchStudentWildSearch to search for the wild string in the lastname, middle name, and firstname.
    Return the Arraylist of students that match the searched string, if there are no entries return an empty ArrayList.
3. Add a function searchStudentWildSearch that will accept a string in either of the following values, lastname, middlename, nickname.
    This will search the specific wild string depending on where it was mentioned to be searched for. Return the Arraylist
    of students that match the searched string, if there are no entries return an empty ArrayList.
TODO: Revise
 */
val logger = KotlinLogging.logger {  }
fun main() {
    val students: ArrayList<Student> = arrayListOf(
        Student("James", "Esteban", "Navor", "Jek", 2_15_5857, 2022),
        Student("John", "Male","Doe", "John", 2_14_4485, 2023),
        Student("Jane", "Female","Doe", "Jane", 1_15_4851, 2019),
    )
    val studentsFound = searchStudentWildSearch(students)
    if(studentsFound.isNotEmpty()){
        println("Found ${studentsFound.size} Students: ")
        for(student in studentsFound){
            with(student){
                logger.info { "$firstName $lastName" }
            }
        }
    }else{
        logger.error { "No students found!" }
    }
}

class Main {
}

data class Student(val firstName: String, val middleName: String, val lastName: String, val nickName: String, val id: Long, var yearEnrolled: Int)

fun searchStudentWildSearch(students: ArrayList<Student>): ArrayList<Student>{
    print("Wild Search Name: ")
    var search = readLine().toString()
    var studentsFound: ArrayList<Student> = ArrayList()

    if(search.isNotEmpty()) {
        for (student in students) {
            if (
                student.firstName.contains(search, true) or
                student.middleName.contains(search, true) or
                student.lastName.contains(search, true) or
                student.nickName.contains(search, true)
            ) {
                studentsFound.add(student)
            }
        }
    }
    return studentsFound
}

fun searchStudentWildSearchByCategory(students: ArrayList<Student>): ArrayList<Student>{
    var studentsFound: ArrayList<Student> = ArrayList()

    println("Choices: 'firstname', 'lastname', 'nickname'")
    print("Search for: ")
    var category: String = readLine().toString()

    print("Wild Search Name: ")
    var search = readLine().toString()

    when(category){
        "firstname" -> {
            for (student in students) {
                if (student.firstName.contains(search, true)) {
                    studentsFound.add(student)
                }
            }
        }
        "lastname" -> {
            for (student in students) {
                if (student.lastName.contains(search, true)) {
                    studentsFound.add(student)
                }
            }
        }
        "nickname" -> {
            for (student in students) {
                if (student.nickName.contains(search, true)) {
                    studentsFound.add(student)
                }
            }
        }
        else -> {
            logger.error { "Invalid Category" }
        }
    }

    return studentsFound
}