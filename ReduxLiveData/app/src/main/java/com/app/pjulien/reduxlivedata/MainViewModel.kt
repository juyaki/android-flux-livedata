package com.app.pjulien.reduxlivedata

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val store: Store<MainState> = Store(MainState(), MainReducer())
}