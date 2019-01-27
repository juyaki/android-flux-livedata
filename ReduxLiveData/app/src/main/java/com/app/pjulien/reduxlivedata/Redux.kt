package com.app.pjulien.reduxlivedata

import androidx.lifecycle.MutableLiveData

interface Action

interface State

interface Reducer<S : State> {
    fun reduce(currentState: S, action: Action): S
}

interface Middleware<S : State> {
    fun performBeforeReducingState(currentState: S, action: Action)
    fun performAfterReducingState(newState: S, action: Action)
}

interface StoreType<S : State> {
    val state: MutableLiveData<S>
    fun dispatch(action: Action)
    fun addMiddleware(middleware: Middleware<S>): Boolean
    fun removeMiddleware(middleware: Middleware<S>): Boolean
}

class Store<S : State>(
        initialState: S,
        private val reducer: Reducer<S>
) : StoreType<S> {

    override val state: MutableLiveData<S> = MutableLiveData<S>().apply { value = initialState }

    private val middlewares: MutableList<Middleware<S>> = mutableListOf()

    override fun dispatch(action: Action) {
        val currentState = state.value ?: return
        middlewares.onEach { it.performBeforeReducingState(currentState, action) }
        reducer.reduce(currentState, action).also { newState ->
            state.value = newState
            middlewares.onEach { it.performAfterReducingState(newState, action) }
        }
    }

    override fun addMiddleware(middleware: Middleware<S>) = middlewares.add(middleware)

    override fun removeMiddleware(middleware: Middleware<S>) = middlewares.remove(middleware)
}