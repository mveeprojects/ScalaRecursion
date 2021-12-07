package aa_coin_flip_tail_recursion

import scala.annotation.tailrec
import scala.io.StdIn.readLine
import scala.util.Random

case class GameState(
    numFlips: Int,
    numCorrectGuesses: Int
)

object Main extends App {

  import Utilities._

  val initialGameState = GameState(0, 0)
  val random           = new Random
  mainLoop(initialGameState, random)

  @tailrec
  def mainLoop(gameState: GameState, random: Random): Unit = {

    showPrompt()
    val userInput = getUserInput

    userInput match {
      case "H" | "T" =>
        val coinTossResult = tossCoin(random)
        val newNumFlips    = gameState.numFlips + 1
        if (userInput == coinTossResult) {
          val newGameState = gameState.copy(numFlips = newNumFlips, numCorrectGuesses = gameState.numCorrectGuesses + 1)
          printGameState(printableFlipResult(coinTossResult), newGameState)
          mainLoop(newGameState, random)
        } else {
          val newGameState = gameState.copy(numFlips = newNumFlips)
          printGameState(printableFlipResult(coinTossResult), newGameState)
          mainLoop(newGameState, random)
        }
      case _ =>
        printGameOver()
        printGameState(gameState)
    }
  }
}

object Utilities {

  def tossCoin(r: Random): String =
    r.nextInt(2) match {
      case 0 => "H"
      case 1 => "T"
    }

  def showPrompt(): Unit = print("\n(h)eads, (t)ails, or (q)uit: ")

  def getUserInput: String = readLine.trim.toUpperCase

  def printableFlipResult(flip: String): String = flip match {
    case "H" => "Heads"
    case "T" => "Tails"
  }

  def printGameState(printableResult: String, gameState: GameState): Unit = {
    print(s"Flip was $printableResult. ")
    printGameState(gameState)
  }

  def printGameState(gameState: GameState): Unit =
    println(s"#Flips: ${gameState.numFlips}, #Correct: ${gameState.numCorrectGuesses}")

  def printGameOver(): Unit = println("\n=== GAME OVER ===")
}
