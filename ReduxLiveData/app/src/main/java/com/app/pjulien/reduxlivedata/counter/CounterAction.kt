package com.app.pjulien.reduxlivedata.counter

import com.app.pjulien.reduxlivedata.Action

sealed class MainAction : Action

object IncreaseCounter : MainAction()

object DecreaseCounter : MainAction()