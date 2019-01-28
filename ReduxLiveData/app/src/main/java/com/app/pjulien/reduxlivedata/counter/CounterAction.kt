package com.app.pjulien.reduxlivedata.counter

import com.app.pjulien.reduxlivedata.Action

sealed class CounterAction : Action

object IncreaseCounter : CounterAction()

object DecreaseCounter : CounterAction()