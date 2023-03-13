package activity_01_c

import java.util.Date

/*
    You are tasked to automate an inventory system for a grocery.
    Identify the items that can be bought in a grocery store.
    After listing the different items, identify the characteristics of the items.
    You are also tasked to group the items in categories to help manage the grocery.  Use the proper data types.

    TODO: https://www.inettutor.com/diagrams/point-of-sale-system-pos-er-diagram/
 */

fun main() {
    //Product Category
    var categoryID: Long = 0
    var categoryName: String

    //Product Unit
    var unitID: Long = 0
    var unit: String

    //Product **Perishable Goods
    var sku: Long = 0
    var productCategoryID: Long = categoryID
//    var productSubCategory: String?
    var productName: String
    var quantityAvailable: Double
    var productUnitID: Long = unitID
    var pricePerUnit: Double

    //Customer
    var customerID: Long = 0
    var firstName: String
    var lastName: String

    //Cart
    var cartID: Long = 0
    var customerRefID: Long = customerID


    //Item in Cart
    var itemID: Long = 0
    var cartRefID: Long = cartID
    var skuRef: Long = sku
    var itemPrice: Double
    var productQuantityPlaced: Double
    var itemUnitID: Long = unitID
    var subTotal: Double

    //Sales
    var timestamp: Date
    var cartReferenceID: Long = cartID
    var total: Double
}