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

fun main() {
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

    if(isBookInRecord(books)){
        logger.info { "Book Search Successful" }
    }else{
        logger.error { "Book Search Failed" }
    }

    showStudents(books)
    books = addBook(books)
    showStudents(books)
    books = removeBook(books)

    logger.info { "There are ${countBooks(books)} Books in the List." }

    var wildSearch: ArrayList<String> = searchBookWildSearch(books)
    if(wildSearch.size > 0) {
        logger.info { "Book Wild Search Successful" }
        showBooks(wildSearch)
    }else{
        logger.error { "Book Wild Search Failed" }
    }

    var exactSearch = searchBookName(books)
    if(exactSearch.size > 0) {
        logger.info { "Book Name Search Successful" }
        showStudents(exactSearch)
    }else{
        logger.error { "Book Name Search Failed" }
    }
}

fun isBookInRecord(books: ArrayList<String>): Boolean{
    var bookFound = false
    print("Find Book in Record: ")
    var search = readLine().toString()
    if (books.contains(search)){
        bookFound = true
    }
    return bookFound
}


fun addBook(books: ArrayList<String>): ArrayList<String>{
    var addBook = true
    do{
        print("Add Book: ")
        var newBook = readLine().toString()
        if (newBook.isNotEmpty()) {
            books.add(newBook)
            logger.info { "$newBook has been added to the List of Books" }
        }else{
            logger.error { "Please Input a Valid Book!" }
        }

        print("Add more books? Y / N: ")
        var addMore = readLine().toString()
        if(!addMore.equals("Y", true)){
            addBook = false
            logger.info { "List of Books has been updated" }
        }
    }while (addBook)

    return books
}

fun removeBook(books: ArrayList<String>): ArrayList<String>{ // Case Sensitive
    var removeBook = true
    do{
        print("Remove Book: ")
        var bookName = readLine().toString()
        if (bookName.isNotEmpty() && books.contains(bookName)) {
            books.remove(bookName)
            logger.info { "$bookName has been removed from the List of Students" }
        }else{
            logger.error { "Book not found in the list!" }
        }

        print("Delete more books? Y / N: ")
        var deleteMore = readLine().toString()
        if(!deleteMore.equals("Y", true)){
            removeBook = false
            logger.info { "List of Books has been updated" }
        }
    }while (removeBook)

    return books
}

fun countBooks(books: ArrayList<String>): Int = books.size

fun searchBookWildSearch(books: ArrayList<String>): ArrayList<String>{
    print("Wild Search Book: ")
    var search = readLine().toString()
    var studentsFound: ArrayList<String> = ArrayList()

    if(search.isNotEmpty()) {
        for (book in books) {
            if (book.contains(search, true)) {
                studentsFound.add(book)
            }
        }
    }
    return studentsFound
}

fun searchBookName(books: ArrayList<String>): ArrayList<String>{
    print("Exact Search Book Name: ")
    var search = readLine().toString()
    var booksFound: ArrayList<String> = ArrayList()

    for (book in books) {
        if (book == search){
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