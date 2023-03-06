package employment_application_form

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val form = ApplicationForm()

    form.position = "Programmer"
    ApplicationForm.increaseApplication()
    println("Position: ${form.position}")
    println("Applicatnts: ${ApplicationForm.applicantCount}")
}

class ApplicationForm{
    var position: String = ""
        get() = "Getting $field"
        set(value) {
            field = "Setting $value"
            println(field)
        }
    var dateAvailableForWork = Date()
    var desiredSalary = 0.0

    lateinit var personalInfo: PersonalInformation
    var educationalBackground: ArrayList<Education> = ArrayList()
    var employment: ArrayList<Employment> = ArrayList()
    var references: ArrayList<References> = ArrayList()

    init { // First Code Block Executed in a Class
        println("Initialized")
    }

    companion object{ // Shared among other instances of the same class / Doesn't work individually
        var applicantCount = 0
        fun increaseApplication(){
            println("Companion Object Called")
            applicantCount++
        }
    }

    constructor() {
        personalInfo = PersonalInformation()
    }

    fun addPersonalInfo(
        lastName: String?,
        firstName: String?,
        middleName: String?,
        age: Int?,
        birthDate: Date?,
        address: String?,
        city: String?,
        state: String?,
        zipCode: Int?,
        socialSecurityNumber: String?,
        usCitizen: Boolean,
        convicted: Boolean,
        drugScreenTest: Boolean,
    ){

        /*
        with(personalInfo){
            this.lastName = lastName
            this.firstName = firstName
            this.middleName = middleName
            this.age = age
            this.birthDate = birthDate
            this.address = address
            this.city = city
            this.state = state
            this.zipCode = zipCode
            this.socialSecurityNumber = socialSecurityNumber
            this.usCitizen = usCitizen
            this.convicted = convicted
            this.drugScreenTest = drugScreenTest
        }

        personalInfo.let {
            it.lastName = lastName
            it.firstName = firstName
            it.middleName = middleName
            it.age = age
            it.birthDate = birthDate
            it.address = address
            it.city = city
            it.state = state
            it.zipCode = zipCode
            it.socialSecurityNumber = socialSecurityNumber
            it.usCitizen = usCitizen
            it.convicted = convicted
            it.drugScreenTest = drugScreenTest
        }
        */
        // Use this to assign values
        personalInfo.apply {
            this.lastName = lastName
            this.firstName = firstName
            this.middleName = middleName
            this.age = age
            this.birthDate = birthDate
            this.address = address
            this.city = city
            this.state = state
            this.zipCode = zipCode
            this.socialSecurityNumber = socialSecurityNumber
            this.usCitizen = usCitizen
            this.convicted = convicted
            this.drugScreenTest = drugScreenTest
        }
        /*
        personalInfo.run {
            this.lastName = lastName
            this.firstName = firstName
            this.middleName = middleName
            this.age = age
            this.birthDate = birthDate
            this.address = address
            this.city = city
            this.state = state
            this.zipCode = zipCode
            this.socialSecurityNumber = socialSecurityNumber
            this.usCitizen = usCitizen
            this.convicted = convicted
            this.drugScreenTest = drugScreenTest
        }

        personalInfo.also {
            it.lastName = lastName
            it.firstName = firstName
            it.middleName = middleName
            it.age = age
            it.birthDate = birthDate
            it.address = address
            it.city = city
            it.state = state
            it.zipCode = zipCode
            it.socialSecurityNumber = socialSecurityNumber
            it.usCitizen = usCitizen
            it.convicted = convicted
            it.drugScreenTest = drugScreenTest
        }
        */
    }

    fun addPersonalInfoContact(type: String, details: String){
        personalInfo.addContacts(Contact(type, details))
    }

    fun addEducation(
        schoolName: String,
        schoolLocation: String,
        yearsAttended: Int,
        degreeReceived: String?,
        major: String?
    ){
        val education = Education()

        education.apply {
            this.schoolName = schoolName
            this.schoolLocation = schoolLocation
            this.yearsAttended = yearsAttended
            this.degreeReceived = degreeReceived
            this.major = major
            educationalBackground.add(this)
        }
    }

    fun addEmployment(){

    }

    fun addReference(){

    }
}

class PersonalInformation() {
    //Personal Information
    var lastName: String? = null
    var firstName: String? = null
    var middleName: String? = null
    var age: Int? = null
    var birthDate: Date? = null
    //Address
    var address: String? = null
    var city: String? = null
    var state: String? = null
    var zipCode: Int? = null
    //Contact Information
    /*
    var telAreaCode: String? = null
    var telNumber: Int? = null
    var celAreaCode: String? = null
    var celNumber: Int? = null
    var email: String? = null
    */
    var socialSecurityNumber: String? = null
    var usCitizen: Boolean = false
    var convicted: Boolean = false
    var drugScreenTest: Boolean = false

    var contacts: ArrayList<Contact> = ArrayList()

    fun addContacts(contact: Contact){
        contacts.add(contact)
    }
}

class Education() {
    var schoolName: String = ""
    var schoolLocation: String = ""
    var yearsAttended: Int = 0
    var degreeReceived: String? = null
    var major: String? = null
}

class Employment() {
    var employer: String = ""
    var employmentStart: Date = Date()
    var employmentEnd: Date = Date()
    var telArea: String? = null
    var telNumber: Int? = null
    var payRateMin: Double = 0.0
    var payRateMax: Double = 0.0
    var address: String = ""
    var city: String = ""
    var zip: Int? = null
    var role: String = ""
    var dutiesPerformed:ArrayList<String>  = ArrayList()
    var reasonForLeaving: String = ""
    var supervisors: ArrayList<Supervisor> = ArrayList()
    var contactSupervisor: Boolean = false

    inner class Supervisor(
        var supervisorFirstName:String = "",
        var supervisorMiddleName:String = "",
        var supervisorLastName:String = "",
        var supervisorTitle:String = ""
    ){
        constructor(): this("", "", "", "")
    }
}


class References(
    var firstName: String = "",
    var middleName: String = "",
    var lastName: String = "",
    var title: String,
    var company: String,
    var contacts: Contact?
){
    constructor(): this("", "", "", "", "", null)
}

class Contact(var type: String, var details: String)