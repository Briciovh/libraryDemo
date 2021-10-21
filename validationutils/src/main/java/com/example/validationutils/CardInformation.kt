package com.example.validationutils

import java.lang.StringBuilder

class CardInformation
/**
 * Instantiates a new Card information.
 *
 * @param cardNumber the card number
 */(
    /**
     * Sets card number.
     *
     * @param cardNumber the card number
     */
    var cardNumber: String
) {
    /**
     * Gets card issuer.
     *
     * @return the card issuer
     */
    /**
     * Sets card issuer.
     *
     * @param cardIssuer the card issuer
     */
    var cardIssuer: String? = null
    /**
     * Is valid boolean.
     *
     * @return the boolean
     */
    /**
     * Sets valid.
     *
     * @param valid the valid
     */
    var isValid = false
    /**
     * Gets error.
     *
     * @return the error
     */
    /**
     * Sets error.
     *
     * @param error the error
     */
    var error: String? = null

    /**
     * Gets card number.
     *
     * @return the card number
     */

    override fun toString(): String {
        val stringBuilder = StringBuilder()
        stringBuilder.append("Card Issuer = ").append(cardIssuer).append("\n")
        stringBuilder.append("Card Number = ").append(cardNumber).append("\n")
        stringBuilder.append("Is Valid = ").append(isValid).append("\n")
        if (!isValid) {
            stringBuilder.append("Error Info = ").append(error).append("\n")
        }
        return stringBuilder.toString()
    }
}
