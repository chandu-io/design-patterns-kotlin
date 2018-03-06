package io.c6

internal object AbstractFactoryPattern02 {

  interface Button {

    val text: String
    val type: Type

    fun click() { println("${type.name} button ($text) clicked!") }

    enum class Type { SMALL, MEDIUM, LARGE }

    private data class SmallButton(override val text: String, override val type: Type) : Button {
      companion object : AbstractFactory() {
        override fun createButton(text: String): Button = SmallButton(text, Type.SMALL)
      }
    }

    private data class MediumButton(override val text: String, override val type: Type) : Button {
      companion object : AbstractFactory() {
        override fun createButton(text: String): Button = MediumButton(text, Type.MEDIUM)
      }
    }

    private data class LargeButton(override val text: String, override val type: Type) : Button {
      companion object : AbstractFactory() {
        override fun createButton(text: String): Button = LargeButton(text, Type.LARGE)
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
