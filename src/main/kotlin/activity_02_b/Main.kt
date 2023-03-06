package activity_02_b

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
    val books: ArrayList<Book>

    //Borrower Information
    val borrowers: ArrayList<Borrower>

    //Borrowed Book Information
    val borrowedBooks: ArrayList<BorrowedBook>
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
)

data class BorrowedBook(
    val id: Long,
    val borrowerID: Long,
    val isbn: Long,
    var dateBorrowed: Date,
    var dateDue: Date,
    var dateReturned: Date?
)