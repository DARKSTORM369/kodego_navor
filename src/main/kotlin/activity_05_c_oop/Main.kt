package activity_05_c_oop

import activity_04_oop.Product

/*
Covered Topic(s) : OOP

1. Create a parent class for all the products in the grocery.
2. Create a cart to store the groceries.
3. Create a Main class where you will add the Cart.
4. In the main class add the following functions
    a - add to cart > add an item in the cart
    b - remove from cart > remove item in the cart
    c - check out cart > compute the total cost of the cart.

    https://www.ziplist.com/grocery-list-template/categories
    https://www.listplanit.com/list-of-categories-for-an-organized-grocery-list/
    TODO: Activity 04 - C
 */

open class Product(){
    var name: String = ""
        private set
    var price: Double = 0.0

    constructor(name: String, price: Double) : this() {
        this.name = name
        this.price = price
    }
}

class Cart(var customer: Customer){
    var uniqueID: String = ""
    var items: HashMap<Product, Float> = HashMap() //TODO: Explore Set
}

data class Customer(var address: String, var mobileNumber: String, var firstName: String, var lastName: String)

class Shop(customer: Customer){
    val cart:Cart = Cart(customer)

    fun addToCart(product: Product, quantity: Float){
        //items.put(product, quantity)
        if(cart.items.containsKey(product)){
            cart.items!![product] = cart.items!![product]!! + quantity
            println("${product.name} quantity increased to ${cart.items[product]}")
        }else {
            cart.items[product] = quantity
            println("${product.name} added to Cart")
        }
    }

    fun removeFromCart(product: Product, quantity: Float){
        if(cart.items[product]!! <= quantity){
            cart.items.remove(product)
            println("${product.name} removed from Cart")
        }else{
            cart.items[product] = cart.items[product]!! - quantity
            println("${product.name} quantity reduced to ${cart.items[product]}")
        }
    }

    fun checkOut(){
        var total: Double = 0.0
        for (item in cart.items){
            total += item.key.price * item.value
        }
        println("A total of amount of $total has been computed for ${cart.items.count()} items in the Cart.")
    }
}