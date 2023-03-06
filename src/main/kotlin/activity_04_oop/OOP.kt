package activity_04_oop

import javax.print.attribute.standard.JobOriginatingUserName

/*
TODO: Need further instructions
You are tasked to create an application for a fast food company.

The application will do the following :
1. Take orders of the customers
    - Create a cart that will contain the items bought by a customer
        - Each cart has a unique id
        - Each cart belongs to a customer
        - a customer has an address, mobile number, first name, and last name.
2. Show the status of the orders if they are sent to the kitchen, being prepared, for pickup, for delivery, delivered, cancelled, paid, unknown.
    - Use enumeration
    - Create a function "Update order" which will update the cart of a specific customer
3. Show the items being sold. The fast food company sells fresh fruits, shakes, juices, sandwiches, and salads.
    - Create 5 items for each category of items being sold.
    - Use OOP concepts to create the classes for the food category.
    - You must use Inheritance, Polymorphism, Encapsulation, Abstraction
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

class Fruits(name: String, price: Double = 0.0): Product(name, price){
    var quantity: Float = 0.0F
    var quantityUnit: String = "per Piece"
}

class Shakes(name: String, price: Double = 0.0): Product(name, price){
    var size: Any = ""
    var ingredients: ArrayList<String> = ArrayList()
    var addons: ArrayList<Any> = ArrayList()
}

class Juices(name: String, price: Double = 0.0): Product(name, price){
    var ingredients: ArrayList<String> = ArrayList()
    var size: Any = ""
}

class Sandwiches(name: String, price: Double = 0.0): Product(name, price){
    var ingredients: ArrayList<String> = ArrayList()
    var addons: ArrayList<Any> = ArrayList()
    var breadType: Any = ""
}

class Salads(name: String, price: Double = 0.0): Product(name, price){
    var ingredients: ArrayList<String> = ArrayList()
    var dressing: Any = ""
    var addons: ArrayList<Any> = ArrayList()
    var size: Any = ""
}

enum class OrderStatus{
    SENT_TO_KITCHEN,
    BEING_PREPARATION,
    FOR_PICKUP,
    FOR_DELIVERY,
    DELIVERED,
    PICKED_UP,
    CANCELLED,
    UNKNOWN
}

class Cart(var customer: Customer){
    var uniqueID: String = ""
    var items: HashMap<Product, Float> = HashMap()
    var status: OrderStatus = OrderStatus.UNKNOWN

    fun updateOrder(status: OrderStatus){
        this.status = status
    }

    //TODO: Use Polymorphism on addItems
    fun addItems(product: Product, quantity: Float){
        //items.put(product, quantity)
        items[product] = quantity
    }
}

class Menu(){
    val fruits = ArrayList<Fruits>()
    val shakes = ArrayList<Shakes>()
    val juices = ArrayList<Juices>()
    val sandwiches = ArrayList<Sandwiches>()
    val salads = ArrayList<Salads>()

    init {
        //https://www.da.gov.ph/price-monitoring/ November 16, 2022
        fruits.addAll(arrayListOf(
            Fruits("Calamansi", 100.00),
            Fruits("Banana (Latundan)", 60.00),
            Fruits("Banana (Lakatan)", 70.00),
            Fruits("Papaya", 60.00),
            Fruits("Mango (Carabao)", 180.00)
        ))
        fruits[0].quantity = 1.0F
        fruits[0].quantityUnit = "per kg"
        fruits[1].quantity = 1.0F
        fruits[1].quantityUnit = "per kg"
        fruits[2].quantity = 1.0F
        fruits[2].quantityUnit = "per kg"
        fruits[3].quantity = 1.0F
        fruits[3].quantityUnit = "per kg"
        fruits[4].quantity = 1.0F
        fruits[4].quantityUnit = "per kg"

        //https://www.foodnetwork.com/grilling/grilling-central-burgers-and-hot-dogs/articles/50-milkshakes
        shakes.addAll(arrayListOf(
            Shakes("Vanilla", 0.0),
            Shakes("Toasted Mashmallow", 0.0),
            Shakes("S'mores", 0.0),
            Shakes("Fig and Port", 0.0),
            Shakes("Strawberry", 0.0),
        ))

        //https://sipsmarter.org/juice-varieties/
        juices.addAll( arrayListOf(
            Juices("Apple Juice", 0.0),
            Juices("Beet Juice", 0.0),
            Juices("Blueberry Juice", 0.0),
            Juices("Cranberry Juice", 0.0),
            Juices("Carrot Juice", 0.0),
        ))

        //https://restaurantclicks.com/types-of-sandwiches/
        sandwiches.addAll( arrayListOf(
            Sandwiches("Chicken Sandwich", 0.0),
            Sandwiches("Egg Sandwich", 0.0),
            Sandwiches("Seafood Sandwich", 0.0),
            Sandwiches("Roast Beef Sandwich", 0.0),
            Sandwiches("Grilled Cheese Sandwich", 0.0),
        ))

        //https://www.loveandlemons.com/salad-recipes/
        salads.addAll( arrayListOf(
            Salads("Summer Asian Slaw", 0.0),
            Salads("Broccoli Salad", 0.0),
            Salads("Shredded Brussels Sprout Salad", 0.0),
            Salads("Pasta Salad", 0.0),
            Salads("Rainbow Orzo Salad", 0.0),
        ))
    }

    fun showItems(){
        println("Menu Items:")
        println("Fruits:")
        for (fruit in fruits){
            with(fruit){
                println("Fruit: $name, Price: $price")
            }
        }
        println("Shakes:")
        for (shake in shakes){
            with(shake){
                println("Fruit: $name, Price: $price")
            }
        }
        println("Juices:")
        for (juice in juices){
            with(juice){
                println("Fruit: $name, Price: $price")
            }
        }
        println("Sandwiches:")
        for (sandwich in sandwiches){
            with(sandwich){
                println("Fruit: $name, Price: $price")
            }
        }
        println("Salads:")
        for (salad in salads){
            with(salad){
                println("Fruit: $name, Price: $price")
            }
        }
    }
}

data class Customer(var address: String, var mobileNumber: String, var firstName: String, var lastName: String)

fun main() {
    val menu = Menu()

    //Customer
    val john = Customer("", "", "John", "Doe")
    val johnCart = Cart(john)
    menu.showItems()
    johnCart.addItems(menu.fruits[0], 1F)
    johnCart.addItems(menu.shakes[0], 1F)
    johnCart.addItems(menu.juices[0], 1F)
    johnCart.addItems(menu.sandwiches[0], 1F)
    johnCart.addItems(menu.salads[0], 1F)

    johnCart.updateOrder(OrderStatus.BEING_PREPARATION)
}