package activity_03_c

import mu.KotlinLogging

/*
Covered Topic(s) : Functions

Instructions :

1. Create an ArrayList of grocery products with 20 entries.
2. Create a HashMap called Cart.
    Hint:  Hashmap<String, Int>
3. Create a function "addToCart" that will accept a String and an Int, then it will add the input in the Hashmap. If the Entry already exists, create a new entry in the HashMap.
    Hint : you may add a "_01", "_02"
    Example Coke_01, Coke_02
4. Create a function "checkOut". This will compute how many items have been checked out.
5. Create a function "removeFromCart"  that will accept a String and remove the input from the Hashmap. If there are multiple entries, remove all from the HashMap.

https://github.com/drriley/grocery/blob/master/lib/items.csv
*/
val logger = KotlinLogging.logger {  }

var groceryProducts: ArrayList<String> = arrayListOf(
    "Cheddar cheese",
    "Milk",
    "Vanilla Yogurt",
    "Chocolate Ice Cream",
    "Sandwich Bread",
    "Vinegar",
    "Horseradish",
    "Bananas",
    "Peppermint",
    "Whole Wheat",
    "Cinnamon Toast Crunch",
    "Olive Oil",
    "Chicken Breast",
    "Tomato Soup",
    "Honey Almond Flax Cereal",
    "Three Cheese Tortellini",
    "Turkey Breast",
    "Raisin Bran Cereal",
    "Bologna",
    "Smoked Ham",
    "Apple Juice",
    "Pinto Beans",
    "Beets",
    "Sweet Peas",
    "Green Bell Peppers",
    "Dark Chocolate Bar",
    "Oats ‘N Honey Crunchy Granola Bars",
    "Rice Pilaf: Roasted Almond Flavor",
    "Whole Wheat Penne Pasta",
    "Macaroni & Cheese",
    "Peanut Butter",
    "Green Beans",
    "Broccoli Florets",
)
var cart = HashMap<String, Int>()

fun main() {
    /** Add to Cart */
    var addToCart = true
    do {
        showProducts(groceryProducts)
        print("Add Item ID: ")
        var itemID = readLine().toString()
        print("Item Quantity: ")
        var quantity = readLine().toString()

        if (itemID.toIntOrNull() != null && itemID.toInt() >= 0 && groceryProducts.size > itemID.toInt() && quantity.toIntOrNull() != null) {
            addToCart(groceryProducts[itemID.toInt()], quantity.toInt())
        }else{
            logger.error { "Please enter valid item and quantity" }
        }
        logger.info { "Cart:" }
        showCart(cart)
        print("Add more Item? Y / N: ")
        var addMore = readLine().toString()
        if(!addMore.equals("Y", true)){
            addToCart = false
            logger.info { "Finished Adding Items" }
        }
    } while (addToCart)

    /** Remove from Cart */
    var removeFromCart = true
    do {
        logger.info { "Cart:" }
        showCart(cart)

        print("Remove Item ID: ")
        var itemID = readLine().toString()
        val cartItems = cart.keys.toList()
        if (itemID.toIntOrNull() != null && itemID.toInt() >= 0 && cartItems.size > itemID.toInt()) {
            removeFromCart(cartItems[itemID.toInt()])
        }else{
            logger.error { "Please enter an item from the Cart" }
        }
        print("Remove more Item? Y / N: ")
        var removeMore = readLine().toString()
        if(!removeMore.equals("Y", true)){
            removeFromCart = false
            logger.info { "Finished Removing Items" }
        }
    }while (removeFromCart)

    /** Checkout */
    checkOut()
}

fun showProducts(products: ArrayList<String>){
    for (index in products.indices){
        logger.info { "[$index] -> ${products[index]}" }
    }
}

fun addToCart(item: String, quantity: Int): HashMap<String, Int>{
    if(inProducts(item)) {
        var append = ""
        if (cart.containsKey(item)) {
            var duplicateCount = 0
            for (product in cart.keys) {
                if (product.contains(item)) {
                    duplicateCount++
                }
            }
            append =
                if (duplicateCount < 10) {
                    "_0$duplicateCount"
                } else {
                    "_$duplicateCount"
                }
        }
        cart[item + append] = quantity
        println("$item has been added to Cart")
    }else{
        println("Invalid Item")
    }
    return cart
}

fun removeFromCart(item: String){
    if(inCart(cart, item)) {
        var cartItems = cart.keys.toList()
        for (product in cartItems) {
            if (item.contains(product)) { //TODO
                println("Removed $product from cart.")
                cart.remove(product)
            }
        }
    }else{
        println("Invalid Item")
    }
}

fun showCart(cart: HashMap<String, Int>){
    var index = 0
    for (item in cart){
        logger.info { "[$index] -> ${item.key}, ${item.value}" }
        index++
    }
}

fun checkOut(){
    var productCount = cart.count()
    var quantity = cart.values.sum()
    println("A total of $productCount items with a total quantity of $quantity have been checked out.")
}

fun inProducts(item: String): Boolean = groceryProducts.contains(item)

fun inCart(cart: HashMap<String, Int>, item: String): Boolean = cart.keys.contains(item)