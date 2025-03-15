package com.rosique.auth.data

import android.util.Patterns
import com.rosique.auth.domain.PatternValidator

object EmailPatterValidator: PatternValidator {

    override fun matches(value: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(value).matches()
    }
}