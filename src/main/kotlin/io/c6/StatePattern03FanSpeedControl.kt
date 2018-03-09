package io.c6

internal object StatePattern03FanSpeedControl {

  class FanSpeedControl {

    private var state: State = State.OFF

    fun inc() {
      state.inc(this)
    }

    fun dec() {
      state.dec(this)
    }

    private enum class State {

      OFF, ONE, TWO, THREE, FOUR, FIVE;

      fun inc(button: FanSpeedControl) {
        val next = incTransition(this)
        println("Increasing to ${next.name}")
        button.state = next
      }

      fun dec(button: FanSpeedControl) {
        val next = decTransition(this)
        println("Decreasing to ${next.name}")
        button.state = next
      }

      companion object {
        private fun incTransition(curr: State) = when (curr) {
          OFF -> ONE
          ONE -> TWO
          TWO -> THREE
          THREE -> FOUR
          FOUR -> FIVE
          FIVE -> FIVE
        }

        private fun decTransition(curr: State) = when (curr) {
          FIVE -> FOUR
          FOUR -> THREE
          THREE -> TWO
          TWO -> ONE
          ONE -> OFF
          OFF -> OFF
        }
      }
    }
  }
}
