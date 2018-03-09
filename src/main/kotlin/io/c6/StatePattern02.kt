package io.c6

internal object StatePattern02 {

  class PushButton {

    private var state: State = State.OFF

    fun push() {
      state.push(this)
      // Additional logic to be run when button pushed
    }

    private enum class State {

      ON {
        override fun push(button: PushButton) {
          println("Turning OFF")
          button.state = OFF
        }
      },

      OFF {
        override fun push(button: PushButton) {
          println("Turning ON")
          button.state = ON
        }
      };

      abstract fun push(button: PushButton)
    }
  }
}
