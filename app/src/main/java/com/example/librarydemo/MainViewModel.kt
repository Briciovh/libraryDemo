package com.example.librarydemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.librarydemo.model.ValidationResponseHolder
import com.example.validationutils.Validator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val validator: Validator) : ViewModel() {

    private val mEmailValidation = MutableLiveData<ValidationResponseHolder>()
    val emailValidation: LiveData<ValidationResponseHolder>
        get() = mEmailValidation

    private val mPasswordValidation = MutableLiveData<ValidationResponseHolder>()
    val passwordValidation: LiveData<ValidationResponseHolder>
        get() = mPasswordValidation

    private val mCreditCardValidation = MutableLiveData<ValidationResponseHolder>()
    val creditCardValidation: LiveData<ValidationResponseHolder>
        get() = mCreditCardValidation

    fun validate(email: String, password: String, creditCard: String) {
        validateEmail(email)
        validatePassword(password)
        validateCreditCard(creditCard)

    }

    private fun validateEmail(email: String) {
        if (validator.isEmpty(email)) {
            mEmailValidation.value = ValidationResponseHolder(false, "Field is empty!")
        } else if (!validator.isEmail(email)) {
            mEmailValidation.value = ValidationResponseHolder(false, "Invalid Email")
        } else {
            mEmailValidation.value = ValidationResponseHolder(true, "Valid email")
        }
    }

    private fun validatePassword(password: String) {
        if (validator.isEmpty(password)) {
            mPasswordValidation.value = ValidationResponseHolder(false, "Field is empty!")
        } else if (!validator.isValidMD5(password)) {
            mPasswordValidation.value = ValidationResponseHolder(false, "Invalid password")
        } else {
            mPasswordValidation.value = ValidationResponseHolder(true, "Valid password")
        }
    }

    private fun validateCreditCard(creditCard: String) {
        if (validator.isEmpty(creditCard)) {
            mCreditCardValidation.value = ValidationResponseHolder(false, "Field is empty!")
        } else if (!validator.validateCreditCard(creditCard)) {
            mCreditCardValidation.value = ValidationResponseHolder(false, "Invalid credit card")
        } else {
            mCreditCardValidation.value = ValidationResponseHolder(true, "Valid credit card")
        }
    }
}