package activity_02_c

import java.sql.Timestamp
import java.util.Date

/*
    You are tasked to automate an inventory system for a grocery.
    Identify the items that can be bought in a grocery store.
    After listing the different items, identify the characteristics of the items.
    You are also tasked to group the items in categories to help manage the grocery.  Use the proper data types.

    Implement Activity 01 - C using data structure.
 */

fun main() {
    // Item List
    var itemList: ArrayList<Any>

    //Sales
    var timestamp: Date
    var skuRef: Long
    var orderCategory: String
    var orderSubCategory: String?
    var itemOrdered: String
    var quantityPlaced: Int
    var totalAmount: Float
}

data class Item(
    val sku: Long,
    var category: String,
    var subCategory: String?,
    var itemName: String,
    var quantity: Int,
    var price: Float,
    var remarks: String?
)

data class Sale(
    var timestamp: Date,
    var sku: Long,
    var category: String,
    var subCategory: String?,
    var itemName: String,
    var quantity: Int,
    var totalAmount: Float
)