package io.c6

private typealias ButtonType1 = AbstractFactoryPattern01.Button.Type
private typealias AbstractFactory1 = AbstractFactoryPattern01.Button.AbstractFactory

private typealias ButtonType2 = AbstractFactoryPattern02.Button.Type
private typealias AbstractFactory2 = AbstractFactoryPattern02.Button.AbstractFactory

private object AbstractFactoryPatternTest {

  @JvmStatic
  fun main(args: Array<String>) {
    -Example01
    println("=== === === === === === === === === === \n")
    -Example02
  }

  object Example01 {

    operator fun unaryMinus() {
      val smallButtonFactory = AbstractFactory1.getFactory(ButtonType1.SMALL)
      val sb1 = smallButtonFactory.createButton("One")
      val sb2 = smallButtonFactory.createButton("Two")

      val mediumButtonFactory = AbstractFactory1.getFactory(ButtonType1.MEDIUM)
      val mb1 = mediumButtonFactory.createButton("Hello")
      val mb2 = mediumButtonFactory.createButton("Hi there!")

      val largeButtonFactory = AbstractFactory1.getFactory(ButtonType1.LARGE)
      val lb1 = largeButtonFactory.createButton("ABC")
      val lb2 = largeButtonFactory.createButton("DEF")

      test(sb1, sb2, mb1, mb2, lb1, lb2)
    }

    private fun test(vararg buttons: AbstractFactoryPattern01.Button) {
      buttons.toList().forEach {
        println("$it, ${it.text}, ${it.type}")
        it.click()
        println()
      }
    }
  }

  object Example02 {

    operator fun unaryMinus() {
      val smallButtonFactory = AbstractFactory2.getFactory(ButtonType2.SMALL)
      val sb1 = smallButtonFactory.createButton("One")
      val sb2 = smallButtonFactory.createButton("Two")

      val mediumButtonFactory = AbstractFactory2.getFactory(ButtonType2.MEDIUM)
      val mb1 = mediumButtonFactory.createButton("Hello")
      val mb2 = mediumButtonFactory.createButton("Hi there!")

      val largeButtonFactory = AbstractFactory2.getFactory(ButtonType2.LARGE)
      val lb1 = largeButtonFactory.createButton("ABC")
      val lb2 = largeButtonFactory.createButton("DEF")

      test(sb1, sb2, mb1, mb2, lb1, lb2)
    }

    private fun test(vararg buttons: AbstractFactoryPattern02.Button) {
      buttons.toList().forEach {
        println("$it, ${it.text}, ${it.type}")
        it.click()
        println()
      }
    }
  }

}
