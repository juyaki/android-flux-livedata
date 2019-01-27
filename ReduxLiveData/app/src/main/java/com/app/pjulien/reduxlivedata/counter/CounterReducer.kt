package com.app.pjulien.reduxlivedata.counter

import com.app.pjulien.reduxlivedata.Action
import com.app.pjulien.reduxlivedata.Reducer

class CounterReducer : Reducer<CounterState> {

    override fun reduce(currentState: CounterState, action: Action): CounterState = when (action) {
        is IncreaseCounter -> currentState.copy(
            counter = currentState.counter + 1
        )
        is DecreaseCounter -> currentState.copy(
            counter = currentState.counter - 1
        )
        else -> currentState
    }
}