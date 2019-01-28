package com.app.pjulien.reduxlivedata.counter

import androidx.lifecycle.ViewModel
import com.app.pjulien.reduxlivedata.Store

class CounterViewModel : ViewModel() {
    val store: Store<CounterState, CounterAction> = Store(CounterState(), CounterReducer())
}