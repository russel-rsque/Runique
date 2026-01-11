package com.rosique.core.connectivity.domain.messaging

import com.rosique.core.domain.util.Error

enum class MessagingError: Error {
    CONNECTION_INTERRUPTED,
    DISCONNECTED,
    UNKNOWN
}