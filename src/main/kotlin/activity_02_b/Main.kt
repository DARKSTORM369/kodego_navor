package activity_02_b

import java.time.LocalDateTime
import java.time.Month
import java.util.Date
/*
    You are tasked to automate a school’s library.
    Identify the items that can be borrowed in a Library.
    After listing the different items, identify the characteristics of the items.
    Use the proper data types.

    Implement Activity 01 -  B using data structure.
 */

fun main() {
    //Books Information
    var books: ArrayList<Any>

    //Borrower Information
    var borrowers: ArrayList<Any>
}

data class Book(
    val isbn: Long,
    var category: String,
    var subCategory: String?,
    var bookTitle: String,
    var bookAuthor: String,
    var publisher: String,
    var publishDate: Date,
    var quantity: Int,
    var bookEdition: String?,
    var bookVolume: String?,
    var bookPages: Int,
    var remarks: String?
)

data class Borrower(
    val borrowerID: Long,
    var firstName: String,
    var lastName: String,
    var bookISBN: Long,
    var dateBorrowed: Date,
    var dateReturned: Date?
)