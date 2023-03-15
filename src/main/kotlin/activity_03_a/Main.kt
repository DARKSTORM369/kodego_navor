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
val students: ArrayList<String> = arrayListOf(
    "James", "Nico", "Mac", "Jason", "John", "Rey", "Joni", "Juan", "Kristin", "Leezandra",
    "Marie", "Mary", "Matthew", "Noe", "Patricia", "Victor", "Romie", "Ronnel", "Ryan", "Wilson"
)
fun main() {
    /** Show Students */
    showStudents(students)

    /** Search Student in Record */
    var searchStudentInRecord = true
    do {
        print("Search Name in Record: ")
        var search = readLine().toString()
        if (isStudentInRecord(search)) {
            logger.info { "Student is in the Record" }
        } else {
            logger.error { "Student is not in the Record" }
        }
        print("Search more student? Y / N: ")
        var searchMore = readLine().toString()
        if(!searchMore.equals("Y", true)){
            searchStudentInRecord = false
            logger.info { "Finished Searching Students" }
        }
    }while (searchStudentInRecord)

    /** Add Students */
    var addStudent = true
    do{
        print("Add Student: ")
        var newStudent = readLine().toString()
        addStudent(newStudent)
        print("Add more student? Y / N: ")
        var addMore = readLine().toString()
        if(!addMore.equals("Y", true)){
            addStudent = false
            logger.info { "Finished Adding Students" }
        }
    }while (addStudent)
    showStudents(students)

    /** Remove Student */
    var removeStudent = true
    do{
        print("Remove Student: ")
        var studentName = readLine().toString()
        removeStudent(studentName)

        print("Delete more student? Y / N: ")
        var removeMore = readLine().toString()
        if(!removeMore.equals("Y", true)){
            removeStudent = false
            logger.info { "List of Students has been updated" }
        }
    }while (removeStudent)

    logger.info { "There are ${countStudents(students)} Students in the List." }

    /** Student Wild Search */
    var wildSearch = true
    do {
        print("Wild Search Name: ")
        var wildSearchStudent = readLine().toString()
        var wildSearchList: ArrayList<String> = searchStudentWildSearch(wildSearchStudent)
        if (wildSearchList.size > 0) {
            logger.info { "Student Wild Search Successful" }
            showStudents(wildSearchList)
        } else {
            logger.error { "Student Wild Search Failed" }
        }
        print("Search more student? Y / N: ")
        var searchMore = readLine().toString()
        if(!searchMore.equals("Y", true)){
            wildSearch = false
            logger.info { "Finished Searching Students" }
        }
    }while (wildSearch)

    /** Student Exact Search */
    var exactSearch = true
    do {
        print("Exact Search Name: ")
        var exactSearchStudent = readLine().toString()
        val exactSearchList = searchStudentName(exactSearchStudent)
        if (exactSearchList.size > 0) {
            logger.info { "Found ${countStudents(exactSearchList)} Student(s) on the List" }
            showStudents(exactSearchList)
        } else {
            logger.error { "Student Name Search Failed" }
        }
        print("Search more student? Y / N: ")
        var searchMore = readLine().toString()
        if(!searchMore.equals("Y", true)){
            exactSearch = false
            logger.info { "Finished Searching Students" }
        }
    }while (exactSearch)

    /** Search Student */
    var searchStudent = true
    do {
        print("Search Student Name: ")
        var searchStudentName = readLine().toString()
        var searchStudentList = searchStudent(searchStudentName)
        if(searchStudentList.size > 0) {
            logger.info { "Found ${countStudents(searchStudentList)} Student(s) on the List" }
            showStudents(searchStudentList)
        }else{
            logger.error { "Student Search Failed" }
        }
        print("Search more student? Y / N: ")
        var searchMore = readLine().toString()
        if(!searchMore.equals("Y", true)){
            searchStudent = false
            logger.info { "Finished Searching Students" }
        }
    }while (searchStudent)
}

fun isStudentInRecord(name: String): Boolean{
    var found = false

    for(student in students){
        if (student.equals(name, true)){
            found = true
        }
    }

    /*
    return students.contains(name)
    */
    return found
}

fun addStudent(student: String){
    if (student.isNotEmpty()) {
        students.add(student)
        logger.info { "$student has been added to the List of Students" }
    }else{
        logger.error { "Please Input a Valid Student!" }
    }
}

fun removeStudent(student: String){ // Case Sensitive
    if (student.isNotEmpty() && students.contains(student)) {
        students.remove(student)
        logger.info { "$student has been removed from the List of Students" }
    }else{
        logger.error { "Student not found on the list!" }
    }
}

fun countStudents(students: ArrayList<String>): Int = students.size

fun searchStudentWildSearch(name: String): ArrayList<String>{
    var studentsFound: ArrayList<String> = ArrayList()

    if(name.isNotEmpty()) {
        for (student in students) {
            if (student.contains(name, true)) {
                studentsFound.add(student)
            }
        }
    }else{
        logger.error { "Please Input a Valid Name!" }
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

fun searchStudentName(name: String): ArrayList<String>{
    val studentsFound: ArrayList<String> = ArrayList()
    for (student in students) {
        if (student == name){
            studentsFound.add(student)
        }
    }
    return studentsFound
}

fun searchStudentName(students: ArrayList<String>, name: String): ArrayList<String>{
    var studentsFound: ArrayList<String> = ArrayList()
    for (student in students) {
        if (student == name){
            studentsFound.add(student)
        }
    }
    return studentsFound
}
fun searchStudent(name: String): ArrayList<String>{
    val studentsFound: ArrayList<String> =
        if(name.length > 3){
            searchStudentName(name)
        }else{
            searchStudentWildSearch(name)
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