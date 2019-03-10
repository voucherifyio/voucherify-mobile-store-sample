package io.voucherify.android.sample.store.data.service.user

import io.voucherify.android.sample.store.data.local.model.LocalUser

interface UserService {

    fun getCurrentUser(): LocalUser

    fun setCurrentUser(localUser: LocalUser)

    fun removeCurrentUser()

    fun isUserLogged(): Boolean
}