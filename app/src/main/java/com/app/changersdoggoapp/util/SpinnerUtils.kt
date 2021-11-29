package com.app.changersdoggoapp.util

import android.view.View
import android.widget.AdapterView
import androidx.appcompat.widget.AppCompatSpinner

fun AppCompatSpinner.onItemSelectedListener(onSelected: (Int) -> Unit) {
    onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            onSelected(position)
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {

        }
    }
}