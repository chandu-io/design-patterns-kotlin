package io.c6

internal object AbstractFactoryPattern01 {

  abstract class Button(open val text: String, open val type: Type) {

    fun click() { println("${type.name} button ($text) clicked!") }

    enum class Type { SMALL, MEDIUM, LARGE }

    private data class SmallButton(override val text: String) : Button(text, Type.SMALL) {
      companion object : AbstractFactory() {
        override fun createButton(text: String): Button = SmallButton(text)
      }
    }

    private data class MediumButton(override val text: String) : Button(text, Type.MEDIUM) {
      companion object : AbstractFactory() {
        override fun createButton(text: String): Button = MediumButton(text)
      }
    }

    private data class LargeButton(override val text: String) : Button(text, Type.LARGE) {
      companion object : AbstractFactory() {
        override fun createButton(text: String): Button = LargeButton(text)
      }
    }

    abstract class AbstractFactory {

      abstract fun createButton(text: String): Button

      companion object {
        fun getFactory(type: Type) = when (type) {
          Type.SMALL -> SmallButton
          Type.MEDIUM -> MediumButton
          Type.LARGE -> LargeButton
        }
      }
    }

  }

}
