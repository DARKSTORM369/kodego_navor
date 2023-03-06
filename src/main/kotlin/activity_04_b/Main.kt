package activity_04_b

import java.util.Date

/*
Covered Topic(s) : Classes

Instructions :

1. Use class to represent the Book rather string.
    A book has a title, authors, year published, edition, ISBN, publisher.
    A book may have a list of chapters.
    A book has a number of pages.
2. Add a class for magazines.
    A magazine has an editor, a title, a month published, a year published
3. Add a class for newspaper.
    A newspaper has a name, day published, month published, year published and headline.
4. Add a class Authors.
    Authors have firstName, lastName, middleName, date of birth.
5. Add a class Comics.
    A comic has a title, month published, year published, illustrators, publisher.
    Create a class illustrator.
    Illustrator have firstName, lastName, middleName, date of birth.
6. Add a class Article.
    An article has a title, content, author.
    A Newspaper and magazine have articles.
7. Create a search function to search for the title of a magazine, newspaper, comics.
8. Create a function that will list the name of the magazine, newspaper, comics or book, author has written in.
9. Create a class for Audio / Video recording.
    The class should show whether the recording has a video or audio or both.
    It has a length, date recorded, title, publisher.
10. Create a Publisher class.
    A publisher has a name, address and date established.
 */

fun main() {
    //https://gist.github.com/jaidevd/23aef12e9bf56c618c41
    val books: ArrayList<Book> = arrayListOf(
        // TODO: List
    )
    //https://kk.org/cooltools/best-magazine-articles-ever/
    //https://github.com/echocat/nodejs-kata-1/tree/master/data
    val magazines: ArrayList<Magazine> = arrayListOf(
        // TODO: List
//        Magazine(Editor("James Dave", "Esteban", "Navor", Date()), "Unknown", "January", 2012)
    )
    val newspapers: ArrayList<Newspaper> = arrayListOf(
        // TODO: List
    )
    val comics: ArrayList<Comics> = arrayListOf(
        // TODO: List
    )
//    listPublishedByAuthor(Author("James Dave", "Esteban", "Navor", Date()), books, magazines, newspapers, comics)
//    search("Unk", books, magazines, comics)
}

fun search(title: String, books: ArrayList<Book>, magazines: ArrayList<Magazine>, comics: ArrayList<Comics>){
    var foundBooks = 0
    var foundMagazines = 0
    var foundComics = 0

    for(book in books){
        if(book.title.contains(title, false)){
            foundBooks++
        }
    }

    for(magazine in magazines){
        if(magazine.title.contains(title, false)){
            foundMagazines++
        }
    }

    for(comic in comics){
        if(comic.title.contains(title, false)){
            foundComics++
        }
    }

    println("Found $foundBooks matches in Books.")
    println("Found $foundMagazines matches in Magazines.")
    println("Found $foundComics matches in Comics.")
}

fun listPublishedByAuthor(author: Person, books: ArrayList<Book>, magazines: ArrayList<Magazine>, newspapers: ArrayList<Newspaper>, comics: ArrayList<Comics>){
    // TODO: Match Author to other Subclass of Person
    val booksAuthored: ArrayList<Book> = ArrayList()
    val magazinesAuthored: ArrayList<Magazine> = ArrayList()
    val comicsIllustrated: ArrayList<Comics> = ArrayList()
    val articlesWritten: ArrayList<Article> = ArrayList()
    for(book in books){
        for (bookAuthor in book.authors) {
            if (bookAuthor.firstName == author.firstName && bookAuthor.middleName == author.middleName && bookAuthor.lastName == author.lastName) {
                booksAuthored.add(book)
            }
        }
    }

    for(magazine in magazines){
        if(magazine.editor.firstName == author.firstName && magazine.editor.middleName == author.middleName && magazine.editor.lastName == author.lastName){
            magazinesAuthored.add(magazine)
        }
    }

    for(comic in comics){
        for(comicIllustrator in comic.illustrators) {
            if (comicIllustrator.firstName == author.firstName && comicIllustrator.middleName == author.middleName && comicIllustrator.lastName == author.lastName) {
                comicsIllustrated.add(comic)
            }
        }
    }

    for(newspaper in newspapers){
        for(article in newspaper.articles){
            if(article.author.firstName == author.firstName && article.author.middleName == author.middleName && article.author.lastName == author.lastName){
                articlesWritten.add(article)
            }
        }
    }
    if(booksAuthored.isNotEmpty()){
        println("${author.firstName} ${author.lastName} has authored in the following books: ")
        for (book in booksAuthored){
            println("${book.title}")
        }
    }else{
        println("${author.firstName} ${author.lastName} didn't author in any of the books listed.")
    }
    if(magazinesAuthored.isNotEmpty()){
        println("${author.firstName} ${author.lastName} has authored in the following magazines: ")
        for (magazine in magazinesAuthored){
            println("${magazine.title}")
        }
    }else{
        println("${author.firstName} ${author.lastName} didn't author in any of the magazines listed.")
    }
    if(comicsIllustrated.isNotEmpty()){
        println("${author.firstName} ${author.lastName} has illustrated in the following comics: ")
        for (comic in comicsIllustrated){
            println("${comic.title}")
        }
    }else{
        println("${author.firstName} ${author.lastName} didn't illustrate in any of the comics listed.")
    }
    if(articlesWritten.isNotEmpty()){
        println("${author.firstName} ${author.lastName} has written the following articles: ")
        for (article in articlesWritten){
            println("${article.title}")
        }
    }else{
        println("${author.firstName} ${author.lastName} didn't write in any of the newspapers listed.")
    }
}


class Book{
    var title: String = ""
    var authors: ArrayList<Author> = ArrayList()
    var yearPublished: Int = 0
    var edition: String? = null
    var isbn: Long = 0
    var publisher: String = ""
    var chapters: HashMap<String, Int> = HashMap()
    var pages: Int = 0
}

open class Person(val firstName: String, val middleName: String = "", val lastName: String, val dateOfBirth: Date)
class Author(firstName: String, middleName: String, lastName: String, dateOfBirth: Date): Person(firstName, middleName, lastName, dateOfBirth)
class Illustrator(firstName: String, middleName: String, lastName: String, dateOfBirth: Date): Person(firstName, middleName, lastName, dateOfBirth)
class Editor(firstName: String, middleName: String, lastName: String, dateOfBirth: Date): Person(firstName, middleName, lastName, dateOfBirth)

data class Publisher(val name: String, val address: String, val dateEstablished: Date)

data class Magazine(val editor: Editor, val title: String, val monthPublished: String, val yearPublished: Int){
    val articles: ArrayList<Article> = ArrayList()
}

data class Newspaper(val name: String, val dayPublished: Int, val monthPublished: String, val yearPublished: Int, val headline: String){
    val articles: ArrayList<Article> = ArrayList()
}

data class Comics(val title: String, val monthPublished: String, val yearPublished: Int, val illustrators: ArrayList<Illustrator>, val publisher: Publisher)

data class Article(val title: String, val content: String, val author: Author)

data class VideoOrAudioRecording(val title: String, val length: String, val dateRecorded: Date, val recordingType: RecordingType, val publisher: Publisher)

enum class RecordingType{
    AUDIO,
    VIDEO,
    AUDIO_AND_VIDEO
}