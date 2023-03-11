package activity_01_i

import java.util.*

/*
    Using Activity 01 - B, Implement a process where someone can borrow a book.
    User: Librarian
    Goal: Keep track book borrowed, who borrowed and how long it can be borrowed.

    Scope :
        Data Structures
 */

fun main() {
    // TODO: Get back to this later after further lessons -> For Review
    // TODO: Process -> Probably wasteful since there are way more efficient methods deeper in Kotlin
    //Book Information
    var isbn: Long
    var category: String
    var subCategory: String?
    var bookTitle: String
    var bookAuthor: String
    var publisher: String
    var publishDate: Date
    var quantity: Int
    var bookEdition: String?
    var bookVolume: String?
    var bookPages: Int
    var remarks: String?

    //Borrower Information
    var borrowerID: Long
    var borrowerFirstName: String
    var borrowerLastName: String

    //Borrowed Book Information
    var isbnID: Long
    var borrowersID: Long
    var borrowedDate: Date
    var borrowedDueDate: Date
    var returnedDate: Date?
}