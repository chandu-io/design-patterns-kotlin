package io.c6

import io.c6.StatePattern.PushButton

private object StatePatternTest {

  @JvmStatic
  fun main(args: Array<String>) {
    -Example01
  }

  object Example01 {
    operator fun unaryMinus() {
      val btn = PushButton()
      (1..10).forEach { btn.push() }
    }
  }

}
