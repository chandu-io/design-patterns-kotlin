package io.c6

private object StatePatternTest {

  @JvmStatic
  fun main(args: Array<String>) {
    -Example01
    println("\n=== === === === === === === === === ===\n")
    -Example02
    println("\n=== === === === === === === === === ===\n")
    -Example03
    println("\n=== === === === === === === === === ===\n")
    -Example03FanSpeedControl
  }

  object Example01 {
    operator fun unaryMinus() {
      val btn = StatePattern01.PushButton()
      (1..10).forEach { btn.push() }
    }
  }

  object Example02 {
    operator fun unaryMinus() {
      val btn = StatePattern02.PushButton()
      (1..10).forEach { btn.push() }
    }
  }

  object Example03 {
    operator fun unaryMinus() {
      val btn = StatePattern03.PushButton()
      (1..10).forEach { btn.push() }
    }
  }

  object Example03FanSpeedControl {
    operator fun unaryMinus() {
      val ctrl = StatePattern03FanSpeedControl.FanSpeedControl()
      (1..6).forEach { ctrl.inc() }
      (1..6).forEach { ctrl.dec() }
    }
  }

}
