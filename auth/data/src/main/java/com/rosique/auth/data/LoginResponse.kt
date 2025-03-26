package com.rosique.auth.data

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.Serializable

@InternalSerializationApi @Serializable
data class LoginResponse(
    val accessToken: String,
    val refreshToken: String,
    val accessTokenExpirationTimestamp: Long,
    val userId: String
)
