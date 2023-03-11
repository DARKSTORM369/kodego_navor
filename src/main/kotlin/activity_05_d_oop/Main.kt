package activity_05_d_oop

import java.text.FieldPosition
import kotlin.random.Random

/*
Coverage : OOP Inheritance, Encapsulation, Polymorphism, Abstraction
    You are tasked to create a game.
    The game is snake and ladders.
    Identify and create the class that will be needed to implement Snakes and ladders.

Hint:
    You will need an array to represent the board.
    You will need snakes, ladders and players.
    Use all OOP concepts.

Reference: https://www.ymimports.com/pages/how-to-play-snakes-and-ladders

TODO: Code feels wrongly made. Must improve.
 */
class Player(val name: String, val color: PieceColor){
    var position: Int = 0
    var previousPosition: Int = 0
    fun move(): Int{
        previousPosition = position
        var steps = rollDice()
        if(position+steps > 100){
            var bounceBack = position+steps - 100
            position = 100 - bounceBack
            println("$name bounced back from $previousPosition to $position")
            return position
        }else{
            position += steps
            println("$name moved from $previousPosition to $position")
            return position
        }
    }
    fun climbUp(ladder: Ladder){
        previousPosition = position
        println("$name found a ladder!")
        position = ladder.topPosition
        println("$name climbed from ${ladder.basePosition} to ${ladder.topPosition}")
        position
    }
    fun slideDown(snake: Snake){
        previousPosition = position
        println("$name gets eaten by a snake.")
        position = snake.tail
        println("$name sled down from ${snake.mouth} to ${snake.tail}")
        position
    }
    private fun rollDice(): Int { //TODO: Shouldn't be inside Player
        var diceRoll = Random.nextInt(1, 7)
        println("$name rolled $diceRoll")
        return diceRoll
    }
}

enum class PieceColor{
    RED,
    YELLOW,
    BLUE,
    GREEN
}

data class Snake(val mouth: Int, val tail: Int)

data class Ladder(val basePosition: Int, val topPosition: Int)

fun main() {
    var james = Player("James", PieceColor.BLUE)
    val players: ArrayList<Player> = arrayListOf(
        james,
//        Player("Blue", PieceColor.BLUE),
        Player("Green", PieceColor.GREEN),
        Player("Red", PieceColor.RED),
        Player("Yellow", PieceColor.YELLOW)
    )


    val board: Array<ArrayList<Any>> = Array(101){i -> arrayListOf(i)}
    val ladders: ArrayList<Ladder> = arrayListOf(
        Ladder(1, 38),
        Ladder(4, 14),
        Ladder(8, 30),
        Ladder(21, 42),
        Ladder(28, 76),
        Ladder(50, 67),
        Ladder(71, 92),
        Ladder(80, 99)
    )
    val snakes: ArrayList<Snake> = arrayListOf(
        Snake(32, 10),
        Snake(36, 6),
        Snake(48, 26),
        Snake(63, 18),
        Snake(88, 24),
        Snake(95, 56),
        Snake(97, 78)
    )
    for(ladder in ladders){
        board[ladder.basePosition].add(ladder)
        board[ladder.topPosition].add(ladder)
    }
    for(snake in snakes){
        board[snake.mouth].add(snake)
        board[snake.tail].add(snake)
    }

    for(player in players){
        board[player.position].add(player)
    }
    var turn = 0
//    board[100].all { it !is Player }
//    players.all { it.position != 100 }
    while (board[100].all { it !is Player }){
        var player: Player = players[turn]
        println("${player.name}'s Turn")
        board[player.position].remove(player)
        var position = player.move()
        var variable: Any? = null
        for(item in board[position]){
            if(item is Ladder){
                variable = item
            }else if(item is Snake){
                variable = item
            }
        }
        when(variable){
            is Ladder -> {
                if(position == variable.basePosition){
                    player.climbUp(variable)
                }else{
                    println("${player.name} looks down at the bottom of the ladder.")
                }
            }
            is Snake -> {
                if(position == variable.mouth){
                    player.slideDown(variable)
                }else{
                    println("${player.name} gazes at the tail of the snake.")
                }
            }
        }
        board[position].add(player)

        if(turn < 3){
            turn++
        }else{
            turn = 0
        }
        if(board[100].any{it is Player}){
            println("${player.name} has won the game!")
        }
    }
}