package exercise_1

class Main {
    fun main() {
        var position: String? = null
        var salary: Double? = null
        var availability: String? = null

        //Personal Information
        var lastName: String? = null
        var firstName: String? = null
        var middleName: String? = null
        var age: Int? = null
        var birthDate: String? = null
        //Address
        var addr: String? = null
        var city: String? = null
        var cityState: String? = null
        var zipCode: Int? = null
        //Contact Information
        var telAreaCode: String? = null
        var telNumber: Int? = null
        var celAreaCode: String? = null
        var celNumber: Int? = null
        var email: String? = null
        var socialSecurityNumber: Long? = null
        var usCitizen: Boolean? = null
        var convicted: Boolean? = null

        //Education
        var school1: String? = null
        var schoolLocation1: String? = null
        var yrsAttended1: String? = null
        var degreeReceived1: String? = null
        var majored1: String? = null
        var school2: String? = null
        var schoolLocation2: String? = null
        var yrsAttended2: String? = null
        var degreeReceived2: String? = null
        var majored2: String? = null
        var school3: String? = null
        var schoolLocation3: String? = null
        var yrsAttended3: String? = null
        var degreeReceived3: String? = null
        var majored3: String? = null
        var etcTrainingsCertsLics: String? = null

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