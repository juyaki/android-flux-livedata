package com.app.pjulien.reduxlivedata

import androidx.lifecycle.MutableLiveData

interface Action

interface State

interface Reducer<S : State, A : Action> {
    fun reduce(currentState: S, action: A): S
}

interface Middleware<S : State> {
    fun performBeforeReducingState(currentState: S, action: Action)
    fun performAfterReducingState(newState: S, action: Action)
}

interface StoreType<S : State, A : Action> {
    val state: MutableLiveData<S>
    fun dispatch(action: A)
    fun addMiddleware(middleware: Middleware<S>): Boolean
    fun removeMiddleware(middleware: Middleware<S>): Boolean
}

class Store<S : State, A : Action>(
        initialState: S,
        private val reducer: Reducer<S, A>
) : StoreType<S, A> {

    override val state: MutableLiveData<S> = MutableLiveData<S>().apply { value = initialState }

    private val middlewares: MutableList<Middleware<S>> = mutableListOf()

    override fun dispatch(action: A) {
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