@file:OptIn(InternalSerializationApi::class)

package com.rosique.auth.data

import com.rosique.auth.domain.AuthRepository
import com.rosique.core.data.networking.post
import com.rosique.core.domain.util.DataError
import com.rosique.core.domain.util.EmptyResult
import io.ktor.client.HttpClient
import kotlinx.serialization.InternalSerializationApi

class AuthRepositoryImpl(
    private val httpClient: HttpClient
): AuthRepository {

    override suspend fun register(
        email: String,
        password: String
    ): EmptyResult<DataError.Network> {
        return httpClient.post<RegisterRequest, Unit>(
            route = "/register",
            body = RegisterRequest(
                email = email,
                password = password
            )
        )
    }
}