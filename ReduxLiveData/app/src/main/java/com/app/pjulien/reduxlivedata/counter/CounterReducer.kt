package com.app.pjulien.reduxlivedata.counter

import com.app.pjulien.reduxlivedata.Reducer

class CounterReducer : Reducer<CounterState, CounterAction> {

    override fun reduce(
            currentState: CounterState,
            action: CounterAction
    ): CounterState = when (action) {
        is IncreaseCounter -> currentState.copy(
                counter = currentState.counter + 1
        )
        is DecreaseCounter -> currentState.copy(
                counter = currentState.counter - 1
        )
    }
}