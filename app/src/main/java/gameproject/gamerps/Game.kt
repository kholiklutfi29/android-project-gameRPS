package gameproject.gamerps

import kotlin.random.Random

object Game {

    private val rules = mapOf(
        "ROCK-PAPER" to false,
        "ROCK-SCISSORS" to true,
        "SCISSORS-ROCK" to false,
        "SCISSORS-PAPER" to true,
        "PAPER-ROCK" to true,
        "PAPER-SCISSORS" to false
    )

    private val option = listOf("ROCK","SCISSORS","PAPER")

    private val optionDrawable = mapOf(
        "ROCK" to R.drawable.rock,
        "PAPER" to R.drawable.paper,
        "SCISSORS" to R.drawable.scissors
    )

    fun computerPick() = option[Random.nextInt(0,3)]  // ex, imp

    fun pickDrawable(option: String) = optionDrawable[option]!!

    fun isDraw(from: String, to: String) = from == to

    fun isWin(from: String, to: String): Boolean = rules["$from-$to"]!!


}