package com.app.pjulien.reduxlivedata.counter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.app.pjulien.reduxlivedata.R
import kotlinx.android.synthetic.main.activity_main.*


class CounterActivity : AppCompatActivity() {

    private val viewModel: CounterViewModel by lazy {
        ViewModelProviders.of(this).get(CounterViewModel::class.java)
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
}
