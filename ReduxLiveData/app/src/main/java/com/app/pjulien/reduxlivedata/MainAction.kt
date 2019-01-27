package com.app.pjulien.reduxlivedata

sealed class MainAction : Action

object IncreaseCounter : MainAction()

object DecreaseCounter : MainAction()