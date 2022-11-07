package activity_03_a

import mu.KotlinLogging

/*
Covered Topic(s) : Functions

Instructions :
Note: Names are single word with no spaces example, "Marco", "Eugene", "Sarah", "Isaiah", "Anthony", "Henry".

1. Create an ArrayList of names with 20 entries.
2. Create a function "isStudentInRecord" that will accept a name and return true if the name is found, otherwise false.
3. Create a function "addStudent" that will accept a name and add it to the ArrayList.
4. Create a function "removeStudent"  that will accept a name and remove it from the ArrayList.
5. Create a function "countStudent" that will return the size of the ArrayList.
6. Create a function "searchStudentWildSearch" that will accept a String and search if that string is found within the
    ArrayList, it will return an ArrayList of names that matched if there are.
7. Create a function  "searchStudentName" that will accept a String and search if there is an exact match of the String
    input, it will return an ArrayList of names that matched if there are.
8. Create a function "searchStudent" that will accept a String and call "searchStudentWildSearch" if the String input is
    less than or equal to three, and it will call "searchStudentName" if the String input is greater than three.
9.  Create a function "showStudents" that will print all the entries in the ArrayList.
 */

val logger = KotlinLogging.logger {  }
fun main() {
    var students: ArrayList<String> = arrayListOf(
        "James", "Nico", "Mac", "Jason", "John", "Rey", "Joni", "Juan", "Kristin", "Leezandra",
        "Marie", "Mary", "Matthew", "Noe", "Patricia", "Victor", "Romie", "Ronnel", "Ryan", "Wilson"
    )

    if(isStudentInRecord(students)){
        logger.info { "Student Search Successful" }
    }else{
        logger.error { "Student Search Failed" }
    }

    showStudents(students)
    students = addStudent(students)
    showStudents(students)
    students = removeStudent(students)

    logger.info { "There are ${countStudents(students)} Students in the List." }

    var wildSearch: ArrayList<String> = searchStudentWildSearch(students)
    if(wildSearch.size > 0) {
        logger.info { "Student Wild Search Successful" }
        showStudents(wildSearch)
    }else{
        logger.error { "Student Wild Search Failed" }
    }

    var exactSearch = searchStudentName(students)
    if(exactSearch.size > 0) {
        logger.info { "Student Name Search Successful" }
        showStudents(exactSearch)
    }else{
        logger.error { "Student Name Search Failed" }
    }

    var searchStudent = searchStudent(students)
    if(searchStudent.size > 0) {
        logger.info { "Student Search Successful" }
        showStudents(searchStudent)
    }else{
        logger.error { "Student Search Failed" }
    }
}

fun isStudentInRecord(students: ArrayList<String>): Boolean{
    print("Search Name in Record: ")
    var search = readLine().toString()
    var found = false

    for(student in students){
        if (student.equals(search, true)){
            found = true
        }
    }

    /*
    if (students.contains(search)){
        found = true
    }
    */
    return found
}

fun addStudent(students: ArrayList<String>): ArrayList<String>{
    var addStudent = true
    do{
        print("Add Student: ")
        var newStudent = readLine().toString()
        if (newStudent.isNotEmpty()) {
            students.add(newStudent)
            logger.info { "$newStudent has been added to the List of Students" }
        }else{
            logger.error { "Please Input a Valid Name!" }
        }

        print("Add more student? Y / N: ")
        var addMore = readLine().toString()
        if(!addMore.equals("Y", true)){
            addStudent = false
            logger.info { "List of Students has been updated" }
        }
    }while (addStudent)

    return students
}

fun removeStudent(students: ArrayList<String>): ArrayList<String>{ // Case Sensitive
    var removeStudent = true
    do{
        print("Remove Student: ")
        var studentName = readLine().toString()
        if (studentName.isNotEmpty()) {
            students.remove(studentName)
            logger.info { "$studentName has been removed from the List of Students" }
        }else{
            logger.error { "Please Input a Valid Name!" }
        }

        print("Delete more student? Y / N: ")
        var deleteMore = readLine().toString()
        if(!deleteMore.equals("Y", true)){
            removeStudent = false
            logger.info { "List of Students has been updated" }
        }
    }while (removeStudent)

    return students
}

fun countStudents(students: ArrayList<String>): Int = students.size

fun searchStudentWildSearch(students: ArrayList<String>): ArrayList<String>{
    print("Wild Search Name: ")
    var search = readLine().toString()
    var studentsFound: ArrayList<String> = ArrayList()

    if(search.isNotEmpty()) {
        for (student in students) {
            if (student.contains(search, true)) {
                studentsFound.add(student)
            }
        }
    }
    return studentsFound
}
fun searchStudentWildSearch(students: ArrayList<String>, search: String): ArrayList<String>{
    var studentsFound: ArrayList<String> = ArrayList()
    if (search.isNotEmpty()) {
        for (student in students) {
            if (student.contains(search, true)) {
                studentsFound.add(student)
            }
        }
    }
    return studentsFound
}

fun searchStudentName(students: ArrayList<String>): ArrayList<String>{
    print("Exact Search Student Name: ")
    var search = readLine().toString()
    var studentsFound: ArrayList<String> = ArrayList()

    for (student in students) {
        if (student == search){
            studentsFound.add(student)
        }
    }
    return studentsFound
}

fun searchStudentName(students: ArrayList<String>, search: String): ArrayList<String>{
    var studentsFound: ArrayList<String> = ArrayList()
    for (student in students) {
        if (student == search){
            studentsFound.add(student)
        }
    }
    return studentsFound
}
fun searchStudent(students: ArrayList<String>): ArrayList<String>{
    print("Search Student: ")
    var search = readLine().toString()
    var studentsFound: ArrayList<String> = ArrayList()
    studentsFound = if(search.length > 3){
        searchStudentName(students, search)
    }else{
        searchStudentWildSearch(students, search)
    }

    return studentsFound
}

fun showStudents(students: ArrayList<String>){
    if(students.size > 0) {
        logger.info { "${students.size} students are found in the list:" }
        for (index in students.indices) {
            println("Student ${index + 1}: ${students[index]}")
        }
    }else{
        logger.error { "Student list is empty!" }
    }
}