package io.c6

internal object StatePattern03 {

  class PushButton {

    private var state: State = State.OFF

    fun push() {
      state.push(this)
      // Additional logic to be run when button pushed
    }

    private enum class State {

      ON, OFF;

      fun push(button: PushButton) {
        val next = transition(this)
        println("Turning ${next.name}")
        button.state = next
      }

      companion object {
        private fun transition(curr: State) = when (curr) {
          // This is very close to defining state transitions in a State Machine
          ON -> OFF
          OFF -> ON
        }
      }
    }
  }
}
