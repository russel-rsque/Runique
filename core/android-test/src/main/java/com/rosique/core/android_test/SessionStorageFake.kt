package com.rosique.core.android_test

import com.rosique.core.domain.AuthInfo
import com.rosique.core.domain.SessionStorage

class SessionStorageFake: SessionStorage {

    private var authInfo: AuthInfo? = null

    override suspend fun get(): AuthInfo? {
        return authInfo
    }

    override suspend fun set(info: AuthInfo?) {
        authInfo = info
    }
}