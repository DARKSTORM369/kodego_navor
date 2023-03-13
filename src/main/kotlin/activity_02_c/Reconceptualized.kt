package activity_02_c

import java.util.*
import kotlin.collections.ArrayList

/**
    You are tasked to automate an inventory system for a grocery.
    Identify the items that can be bought in a grocery store.
    After listing the different items, identify the characteristics of the items.
    You are also tasked to group the items in categories to help manage the grocery.  Use the proper data types.

    Implement Activity 01 - C using data structure.
 */

data class ProductCategory(
    var categoryID: Long = 0,
    var categoryName: String
)

data class ProductUnit(
    var unitID: Long = 0,
    var unit: String
)

data class Product(
    var sku: Long = 0,
    var productCategoryID: Long,
    var productName: String,
    var quantityAvailable: Double,
    var productUnitID: Long,
    var pricePerUnit: Double
)

data class Customer(
    var customerID: Long = 0,
    var firstName: String,
    var lastName: String
)

data class Item(
    var itemID: Long = 0,
    var cartRefID: Long,
    var skuRef: Long,
    var itemPrice: Double,
    var productQuantityPlaced: Double,
    var itemUnitID: Long,
    var subTotal: Double
)

class Cart(
    var cartID: Long = 0,
    var customerRefID: Long
){
    val items: ArrayList<Item> = ArrayList()
}

class Sales(
    var timestamp: Date,
    var cartReferenceID: Long,
    var total: Double
){

}

fun main() {

}