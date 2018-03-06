package io.c6

import io.c6.Button.Type.*

private abstract class Button(open val text: String, val type: Type) {

  fun click() { println("${type.name} button ($text) clicked!") }

  enum class Type { SMALL, MEDIUM, LARGE }

  private data class SmallButton(override val text: String) : Button(text, SMALL) {
    companion object : AbstractFactory() {
      override fun createButton(text: String): Button = SmallButton(text)
    }
  }

  private data class MediumButton(override val text: String) : Button(text, MEDIUM) {
    companion object : AbstractFactory() {
      override fun createButton(text: String): Button = MediumButton(text)
    }
  }

  private data class LargeButton(override val text: String) : Button(text, LARGE) {
    companion object : AbstractFactory() {
      override fun createButton(text: String): Button = LargeButton(text)
    }
  }

  abstract class AbstractFactory {

    abstract fun createButton(text: String): Button

    companion object {
      fun getFactory(type: Type) = when (type) {
        SMALL -> SmallButton
        MEDIUM -> MediumButton
        LARGE -> LargeButton
      }
    }
  }

}

fun main(args: Array<String>) {
  val mediumButtonFactory = Button.AbstractFactory.getFactory(MEDIUM)
  val mb1 = mediumButtonFactory.createButton("Hello")
  mb1.click()
  val mb2 = mediumButtonFactory.createButton("Hi there!")
  mb2.click()
  println(listOf(mb1, mb2))
  println()

  val smallButtonFactory = Button.AbstractFactory.getFactory(SMALL)
  val sb1 = smallButtonFactory.createButton("One")
  sb1.click()
  val sb2 = smallButtonFactory.createButton("Two")
  sb2.click()
  println(listOf(sb1, sb2))
  println()

  val largeButtonFactory = Button.AbstractFactory.getFactory(LARGE)
  val lb1 = largeButtonFactory.createButton("ABC")
  lb1.click()
  val lb2 = largeButtonFactory.createButton("DEF")
  lb2.click()
  println(listOf(lb1, lb2))
  println()
}
