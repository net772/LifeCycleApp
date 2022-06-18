package com.example.lifecycleapp

import androidx.lifecycle.ViewModel

class FragmentAViewModel : ViewModel() {
    var a = 1

    fun setA() {
        a++
    }
}