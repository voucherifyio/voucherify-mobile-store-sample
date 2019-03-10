package io.voucherify.android.sample.store.data.repository

import io.reactivex.Single
import io.voucherify.android.sample.store.data.local.model.LocalUser
import io.voucherify.android.sample.store.data.remote.api.VoucherifyAuthApi
import io.voucherify.android.sample.store.data.remote.api.request.LoginRequest

class VoucherifyLoginRepository(private val loginApi: VoucherifyAuthApi): LoginRepository {

    override fun login(loginOrEmail: String, password: String): Single<LocalUser> {
        val request = LoginRequest(
            loginOrEmail = loginOrEmail,
            password = password
        )

        return loginApi
            .login(loginRequest = request)
            .map {
                LocalUser(
                    id = it.user.id,
                    login = it.user.login,
                    email = it.user.email,
                    firstName = it.user.firstName,
                    lastName = it.user.lastName,
                    isOwner = it.user.isOwner
                )
            }
    }
}