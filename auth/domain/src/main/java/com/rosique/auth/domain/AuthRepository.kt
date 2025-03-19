package com.rosique.auth.domain

import com.rosique.core.domain.util.DataError
import com.rosique.core.domain.util.EmptyResult

interface AuthRepository {
    suspend fun register(email: String, password: String): EmptyResult<DataError.Network>
}