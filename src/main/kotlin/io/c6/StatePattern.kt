package io.c6

internal object StatePattern {

  class PushButton {

    private var state: State = State.OFF

    fun push() {
      state.push(this)
      // Additional logic to be run when button pushed
    }

    private interface State {

      fun push(button: PushButton)

      object ON : State {
        override fun push(button: PushButton) {
          println("Turning OFF")
          button.state = OFF
        }
      }

      object OFF : State {
        override fun push(button: PushButton) {
          println("Turning ON")
          button.state = ON
        }
      }
    }
  }
}
