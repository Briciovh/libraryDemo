package com.example.librarydemo

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.validationutils.Validator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val validator: Validator): ViewModel() {

    fun validate(){
        Log.i("Validation", "Validation")
    }
}