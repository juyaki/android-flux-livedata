package com.app.pjulien.reduxlivedata.counter

import com.app.pjulien.reduxlivedata.State

data class CounterState(
        val counter: Int = 0
) : State