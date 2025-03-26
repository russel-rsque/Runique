@file:OptIn(InternalSerializationApi::class)

package com.rosique.auth.data

import com.rosique.auth.domain.AuthRepository
import com.rosique.core.data.networking.post
import com.rosique.core.domain.AuthInfo
import com.rosique.core.domain.SessionStorage
import com.rosique.core.domain.util.DataError
import com.rosique.core.domain.util.EmptyResult
import com.rosique.core.domain.util.Result
import com.rosique.core.domain.util.asEmptyDataResult
import io.ktor.client.HttpClient
import kotlinx.serialization.InternalSerializationApi

class AuthRepositoryImpl(
    private val httpClient: HttpClient,
    private val sessionStorage: SessionStorage
): AuthRepository {

    override suspend fun login(email: String, password: String): EmptyResult<DataError.Network> {
        val result = httpClient.post<LoginRequest, LoginResponse>(
            route = "/login",
            body = LoginRequest(
                email = email,
                password = password
            )
        )
        if (result is Result.Success) {
            sessionStorage.set(
                AuthInfo(
                    accessToken = result.data.accessToken,
                    refreshToken = result.data.refreshToken,
                    userId = result.data.userId
                )
            )
        }

        return result.asEmptyDataResult()
    }

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