package com.rosique.auth.domain

interface PatternValidator {

    fun matches(value: String): Boolean
}