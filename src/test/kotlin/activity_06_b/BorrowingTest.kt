package activity_06_b
import activity_06_b_exceptions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.time.LocalDate
import java.util.*

internal class BorrowingTest {
    private val borrowCheck: Borrow = Borrow()

    @Test
    fun checkBorrowBook(){
        assertThrows<BorrowBookException> {
            borrowCheck.borrowBook(
                Borrower("James Dave", "Navor", 5, 0.0),
                Comics("Astonishing X-Men", "Marvel Comics", Date(), BookState.UNKNOWN)
            )
        }
        assertThrows<BorrowBookException.PersonBorrowException> {
            borrowCheck.borrowBook(
                Borrower("James Dave", "Navor", 5, 0.0),
                Comics("Astonishing X-Men", "Marvel Comics", Date(), BookState.UNKNOWN)
            )
        }
        assertThrows<BorrowBookException.PersonBorrowException.BorrowedTooMany> {
            borrowCheck.borrowBook(
                Borrower("James Dave", "Navor", 5, 0.0),
                Comics("Astonishing X-Men", "Marvel Comics", Date(), BookState.UNKNOWN)
            )
        }
        assertThrows<BorrowBookException.PersonBorrowException.HasUnpaidDues> {
            borrowCheck.borrowBook(
                Borrower("James Dave", "Navor", 0, 1.0),
                Comics("Astonishing X-Men", "Marvel Comics", Date(), BookState.UNKNOWN)
            )
        }
        assertThrows<BorrowBookException.BookException> {
            borrowCheck.borrowBook(
                Borrower("James Dave", "Navor", 0, 0.0),
                Comics("Astonishing X-Men", "Marvel Comics", Date(), BookState.RESERVED)
            )
        }
        assertThrows<BorrowBookException.BookException.BookReserved> {
            borrowCheck.borrowBook(
                Borrower("James Dave", "Navor", 0, 0.0),
                Comics("Astonishing X-Men", "Marvel Comics", Date(), BookState.RESERVED)
            )
        }
        assertThrows<BorrowBookException.BookException.BookForInternalUse> {
            borrowCheck.borrowBook(
                Borrower("James Dave", "Navor", 0, 0.0),
                Comics("Astonishing X-Men", "Marvel Comics", Date(), BookState.INTERNAL_USE_ONLY)
            )
        }
        assertThrows<BorrowBookException.BookException.BookForRepair> {
            borrowCheck.borrowBook(
                Borrower("James Dave", "Navor", 0, 0.0),
                Comics("Astonishing X-Men", "Marvel Comics", Date(), BookState.FOR_REPAIR)
            )
        }
        assertThrows<BorrowBookException.PersonBorrowException.BorrowedTooMany> {
            borrowCheck.borrowBook(
                Borrower("James Dave", "Navor", 5, 0.0),
                Comics("Astonishing X-Men", "Marvel Comics", Date(), BookState.RESERVED)
            )
        }
    }
}