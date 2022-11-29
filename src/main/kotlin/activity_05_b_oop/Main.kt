package activity_05_b_oop

import java.util.Date

/*
Covered Topic(s) : OOP

1. A book, a magazine, a newspaper and comics inherits from a Publication class. Identify the attributes and the methods for the publication.
2. There are several Audio / Video materials, Recordings, Documentary, Movies and PowerPoint materials.
    What will you use to present the different types of Audio / Video presentation, a class or an enum? Why?
    Implement your answer in code.
3. Authors and Illustrators seem to have similar data? What will you use to present the two a class or an enum or will you keep them as is? Why?
    Implement your answer in code.
 */

open class Publication {
    var title: String = ""
    var publisher: String = ""
    var datePublished: Date = Date()
    var materialType: MaterialType = MaterialType.UNKNOWN
    constructor()
    constructor(title: String, publisher: String, datePublished: Date, materialType: MaterialType): this(){
        this.title = title
        this.publisher = publisher
        this.datePublished = datePublished
        this.materialType = materialType
    }
    constructor(title: String, publisher: String, datePublished: Date): this(){
        this.title = title
        this.publisher = publisher
        this.datePublished = datePublished
        this.materialType = materialType
    }
}

class Magazine(title: String, publisher: String, datePublished: Date, materialType: MaterialType): Publication(title, publisher, datePublished, materialType){

}

class Newspaper(title: String, publisher: String, datePublished: Date, materialType: MaterialType): Publication(title, publisher, datePublished, materialType){

}

class Comics(title: String, publisher: String, datePublished: Date): Publication(title, publisher, datePublished){

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

data class Person(val firstName: String, val lastName: String, val role: Role)

enum class Role{
    AUTHOR,
    ILLUSTRATOR,
    UNKNOWN
}