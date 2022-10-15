package exercise_1

import mu.KotlinLogging
import java.time.LocalDateTime
import java.time.Month
import java.util.Date

private val logger = KotlinLogging.logger {  }
fun main() {
    var position: String? = null
    var salary: Float? = null
    var availability: String? = null

    //Personal Information
    var lastName: String? = null
    var firstName: String? = null
    var middleName: String? = null
    var age: Int? = null
    var birthDate: Date? = null
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

    var ageMinor = 0 .. 17
    var ageLegal = 18 .. 100

    if(age != null){
        when (age){
            in ageChild -> logger.info{"Applicant is a Child"}
            in ageTeen -> logger.info{"Applicant is a Teenager"}
            in ageAdult-> logger.info{"Applicant is an Adult"}
            in ageSenior -> logger.info{"Applicant is a Senior Citizen"}
            else -> logger.info{"Age cannot be determined"}
        }
        when (age){
            in ageMinor -> logger.info{"Applicant is still a Minor"}
            in ageLegal -> logger.info{"Applicant is of Legal Age"}
        }
    }else{
        logger.info{"Age was not given"}
    }
}