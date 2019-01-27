package com.app.pjulien.reduxlivedata

class MainReducer : Reducer<MainState> {

    override fun reduce(currentState: MainState, action: Action): MainState = when (action) {
        is IncreaseCounter -> currentState.copy(
            counter = currentState.counter + 1
        )
        is DecreaseCounter -> currentState.copy(
            counter = currentState.counter - 1
        )
        else -> currentState
    }
}