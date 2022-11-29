package activity_06_b_exceptions

import java.util.*

/*
Create a function that will accept an item in the library and person who will borrow the item, (Use classes in Activity 05 - B).
Throw the following exceptions :
    if the user still has 5 or more items from the library - Cannot borrow due to too many items still borrowed
    if the user has unpaid dues - Cannot borrow Exception due to unpaid dues
    if the item being borrowed has been reserved - Cannot borrow due to reserved
    it the item is for internal use - Cannot borrow due to item only used in library
    if the item is for fixing - Cannot borrow due to item needs to be fixed

You will need to add the remaining classes and add the remaining methods and attributes in order to implement the functionalities.
 */

open class Publication {
    var title: String = ""
    var publisher: String = ""
    var datePublished: Date = Date()
    var materialType: MaterialType = MaterialType.UNKNOWN
    var status: BookState = BookState.UNKNOWN
    constructor()
    constructor(title: String, publisher: String, datePublished: Date, materialType: MaterialType, status: BookState): this(){
        this.title = title
        this.publisher = publisher
        this.datePublished = datePublished
        this.materialType = materialType
        this.status = status
    }
    constructor(title: String, publisher: String, datePublished: Date, status: BookState): this(){
        this.title = title
        this.publisher = publisher
        this.datePublished = datePublished
        this.materialType = materialType
        this.status = status
    }
}

class Magazine(title: String, publisher: String, datePublished: Date, materialType: MaterialType, status: BookState):
    Publication(title, publisher, datePublished, materialType, status){

}

class Newspaper(title: String, publisher: String, datePublished: Date, materialType: MaterialType, status: BookState):
    Publication(title, publisher, datePublished, materialType, status){

}

class Comics(title: String, publisher: String, datePublished: Date, status: BookState):
    Publication(title, publisher, datePublished, status){

}

enum class MaterialType{
    AUDIO,
    VIDEO,
    RECORDING,
    DOCUMENTARY,
    MOVIE,
    POWERPOINT,
    UNKNOWN
}

data class Borrower(val firstName: String, val lastName: String){
    var borrowedBooks: Int = 0
    var unpaidDues: Double = 0.0
    constructor() : this("","")
    constructor(firstName: String, lastName: String, borrowedBooks: Int, unpaidDues: Double): this(firstName, lastName){
        this.borrowedBooks = borrowedBooks
        this.unpaidDues = unpaidDues
    }
}

class Person(val firstName: String, val lastName: String, val role: Role){
}

enum class Role{
    AUTHOR,
    ILLUSTRATOR,
    UNKNOWN
}

enum class BookState{
    AVAILABLE,
    RESERVED,
    INTERNAL_USE_ONLY,
    FOR_REPAIR,
    UNKNOWN
}

class Borrow() {
    fun borrowBook(borrower: Borrower, publication: Publication) {
        if (borrower.borrowedBooks >= 5) {
            throw BorrowBookException.PersonBorrowException.BorrowedTooMany()
        } else if (borrower.unpaidDues > 0) {
            throw BorrowBookException.PersonBorrowException.HasUnpaidDues()
        }

        when (publication.status) {
            BookState.RESERVED -> throw BorrowBookException.BookException.BookReserved()
            BookState.INTERNAL_USE_ONLY -> throw BorrowBookException.BookException.BookForInternalUse()
            BookState.FOR_REPAIR -> throw BorrowBookException.BookException.BookForRepair()
            else -> {}
        }
    }
}