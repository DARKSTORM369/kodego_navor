package exercise_1

class Main {
    fun main() {
        var position: String? = null
        var salary: Double? = null
        var availability: String? = null

        //Personal Information
        var lName: String? = null
        var fName: String? = null
        var mName: String? = null
        var age: Int? = null
        var bDate: String? = null
        //Address
        var addr: String? = null
        var city: String? = null
        var cState: String? = null
        var zip: Int? = null
        //Contact Information
        var tela: String? = null
        var teln: Int? = null
        var cela: String? = null
        var celn: Int? = null
        var email: String? = null
        var sss: Long? = null
        var us_cit: Boolean? = null
        var convict: Boolean? = null

        //Education
        var sch1: String? = null
        var loc1: String? = null
        var yrs1: String? = null
        var deg1: String? = null
        var maj1: String? = null
        var sch2: String? = null
        var loc2: String? = null
        var yrs2: String? = null
        var deg2: String? = null
        var maj2: String? = null
        var sch3: String? = null
        var loc3: String? = null
        var yrs3: String? = null
        var deg3: String? = null
        var maj3: String? = null
        var trns: String? = null

        age = 60
        checkAge(age)
    }

    fun checkAge(age: Int?){
        // Form Controls
        var ageChild = 0 .. 12
        var ageTeen = 13 .. 19
        var ageAdult = 20 .. 59
        var ageSenior = 60 .. 100

        if(age != null){
            when (age){
                in ageChild -> println("Applicant is a Child")
                in ageTeen -> println("Applicant is a Teenager")
                in ageAdult-> println("Applicant is an Adult")
                in ageSenior -> println("Applicant is a Senior Citizen")
                else -> println("Age cannot be determined")
            }
            /*
            if(age < 18){
                println("Applicant is not of Legal Age")
            }else if(age >= 18 && age < 60){
                println("Applicant is of Legal Age")
            }else if(age >= 60){
                println("Applicant is a Senior Citizen")
            }*/
        }else{
            println("Age was not given")
        }
    }
}