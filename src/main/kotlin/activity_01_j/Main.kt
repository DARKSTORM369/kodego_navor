package activity_01_j

/*
    Using Activity 01 - C
    Implement a process where items are added to the grocery cart.
    User : Cashier
    Goal : List of Items bought, how many items were bought and total cost.

    Scope :
        Data Structures
   TODO:
        ArrayList / HashMap or the like

    https://itsourcecode.com/free-projects/database-design-projects/database-design-for-grocery-management-system/
 */
data class Item(
    var sku: Long = 0,
    var itemCategory: String,
    var itemName: String,
    var itemAvailability: String,
    var itemQuantity: Double
)

fun main() {
    // TODO: Get back to this later after further lessons -> For Review
    // TODO: Process
    //Grocery Item
    val sku: Long = 0
    var itemCategory: String
    var itemSubCategory: String
    var itemName: String
    var itemAvailability: String
    var itemQuantity: Double

    //Product Ordered
    val productID: Long = 0
    var skusID: Long = sku
    var productQuantity: Double

    //Customer
    val customerID: Long = 0
    var customerName: String

    //Cart
    val cartID: Long = 0
    val customersID: Long = 0
    val productsIDs: Long = productID


}