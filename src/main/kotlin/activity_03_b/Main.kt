package activity_03_b

import activity_03_a.*

/*
Covered Topic(s) : Functions

Instructions :

1. Create an ArrayList of bookname with 20 entries.
2. Create a function "isBookInRecord" that will accept a String and return true if the book is found, otherwise false.
3. Create a function "addBook" that will accept a String and add it to the ArrayList.
4. Create a function "removeBook"  that will accept a name and remove it from the ArrayList if it exactly matches the book name.
5. Create a function "countBooks" that will return the size of the ArrayList.
6. Create a function "searchBookWildSearch" that will accept a String and search if that string is found with in the ArrayList,
    it will return an ArrayList of books that matched if there are.
7. Create a function  "searchBookName" that will accept a String and search if there is an exact match of the String input,
    it will return an ArrayList of books that matched if there are.
8.  Create a function "showBooks" that will print all the entries in the ArrayList.
 */

var books: ArrayList<String> = arrayListOf(
    "Society, Culture, and Politics",
    "Ekonomiks: Katuturan, Gamit, at Kahalagahan",
    "Media Information Literacy Today",
    "Pilgrimage to Sacred Spaces",
    "Media and Information in a Changing World",
    "Integrated English for Effective Communication",
    "Developing Reading and Writing Skills",
    "HUMSS Fusion",
    "Making Life Worth Living",
    "Claiming Spaces",
    "Disciplines and Ideas in the Social Sciences",
    "Pinagyamang Pluma",
    "Earth Science",
    "Disaster Readiness and Risk Reduction",
    "Earth and Life Science",
    "Exploring Life Through Science",
    "Creative Nonfiction",
    "Soaring 21st Century Mathematics",
    "Math in Today's World",
    "Next Century Mathematics"
)

fun main() {
    /** Show Books */
    showBooks(books)
    /** Find Book in Record */
    var findBook = true
    do {
        print("Find Book in Record: ")
        var findBookTitle = readLine().toString()
        if (isBookInRecord(findBookTitle)) {
            logger.info { "Book is in the Record" }
        } else {
            logger.error { "Book is not in the Record" }
        }
        print("Find more books? Y / N: ")
        var findMore = readLine().toString()
        if (!findMore.equals("Y", true)) {
            findBook = false
            logger.info { "Finished Finding Books" }
        }
    } while (findBook)

    /** Add Books */
    var addBook = true
    do {
        print("Add in Record: ")
        var bookTitle = readLine().toString()
        addBook(bookTitle)
        print("Add more books? Y / N: ")
        var addMore = readLine().toString()
        if (!addMore.equals("Y", true)) {
            addBook = false
            logger.info { "List of Books have been updated" }
        }
    } while (addBook)

    showBooks(books)

    /** Remove Books */
    var removeBook = true
    do{
        print("Remove Book: ")
        var bookTitle = readLine().toString()
        removeBook(bookTitle)
        print("Delete more books? Y / N: ")
        var deleteMore = readLine().toString()
        if(!deleteMore.equals("Y", true)){
            removeBook = false
            logger.info { "List of Books has been updated" }
        }
    }while (removeBook)

    logger.info { "There are ${countBooks(books)} Books in the List." }

    /** Book Wild Search */
    var wildSearch = true
    do {
        print("Wild Search Book: ")
        var wildSearchBookTitle = readLine().toString()
        var wildSearchList: ArrayList<String> = searchBookWildSearch(wildSearchBookTitle)
        if (wildSearchList.size > 0) {
            logger.info { "Found ${countBooks(wildSearchList)} Book(s) in the List" }
            showBooks(wildSearchList)
        } else {
            logger.error { "Book Wild Search Failed" }
        }
        print("Search more books? Y / N: ")
        var searchMore = readLine().toString()
        if (!searchMore.equals("Y", true)) {
            wildSearch = false
            logger.info { "Finished Searching for Books" }
        }
    }while (wildSearch)

    /** Book Exact Search */
    var exactSearch = true
    do {
        print("Exact Search Book Name: ")
        var title = readLine().toString()
        val exactSearchList = searchBookName(title)
        if (exactSearchList.size > 0) {
            logger.info { "Book Name Search Successful" }
            showBooks(exactSearchList)
        } else {
            logger.error { "Book Name Search Failed" }
        }
        print("Search more books? Y / N: ")
        var searchMore = readLine().toString()
        if (!searchMore.equals("Y", true)) {
            exactSearch = false
            logger.info { "Finished Searching for Books" }
        }
    }while (exactSearch)
}

fun isBookInRecord(title: String): Boolean{
    var bookFound = false
    if (books.contains(title)){
        bookFound = true
    }
    return bookFound
}


fun addBook(title: String){
    if (title.isNotEmpty()) {
        books.add(title)
        logger.info { "$title has been added to the List of Books" }
    }else{
        logger.error { "Please Input a Valid Book!" }
    }
}

fun removeBook(title: String){ // Case Sensitive
    if (title.isNotEmpty() && books.contains(title)) {
        books.remove(title)
        logger.info { "$title has been removed from the List of Students" }
    }else{
        logger.error { "Book not found in the list!" }
    }
}

fun countBooks(books: ArrayList<String>): Int = books.size

fun searchBookWildSearch(title: String): ArrayList<String>{
    val studentsFound: ArrayList<String> = ArrayList()

    if(title.isNotEmpty()) {
        for (book in books) {
            if (book.contains(title, true)) {
                studentsFound.add(book)
            }
        }
    }
    return studentsFound
}

fun searchBookName(title: String): ArrayList<String>{
    var booksFound: ArrayList<String> = ArrayList()

    for (book in books) {
        if (book == title){
            booksFound.add(book)
        }
    }
    return booksFound
}

fun showBooks(books: ArrayList<String>){
    if(books.size > 0) {
        logger.info { "${books.size} books are found in the list:" }
        for (index in books.indices) {
            println("Book ${index + 1}: ${books[index]}")
        }
    }else{
        logger.error { "Book list is empty!" }
    }
}