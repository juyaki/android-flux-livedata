package com.app.pjulien.reduxlivedata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViews()
    }

    private fun bindViews() {
        increaseButton.setOnClickListener {
            viewModel.store.dispatch(IncreaseCounter)
        }
        decreaseButton.setOnClickListener {
            viewModel.store.dispatch(DecreaseCounter)
        }
        viewModel.store.state.observe(this, Observer { state ->
            counterTextView.text = state.counter.toString()
            decreaseButton.isEnabled = state.counter > 0
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.store.state.removeObservers(this)
    }
}
