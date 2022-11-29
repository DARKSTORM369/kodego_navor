package activity_06_b_exceptions

sealed class BorrowBookException(message: String): Exception(message){
    sealed class PersonBorrowException(message: String): BorrowBookException(message){
        class BorrowedTooMany(message: String = "Cannot borrow due to too many items still borrowed"): PersonBorrowException(message)
        class HasUnpaidDues(message: String = "Cannot borrow Exception due to unpaid dues"): PersonBorrowException(message)
    }
    sealed class BookException(message: String): BorrowBookException(message){
        class BookReserved(message: String = "Cannot borrow due to reserved"): BookException(message)
        class BookForInternalUse(message: String = "Cannot borrow due to item only used in library"): BookException(message)
        class BookForRepair(message: String = "Cannot borrow due to item needs to be fixed"): BookException(message)
    }
}