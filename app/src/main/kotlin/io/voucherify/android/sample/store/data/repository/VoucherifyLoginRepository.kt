package io.voucherify.android.sample.store.data.repository

import io.reactivex.Single
import io.voucherify.android.sample.store.data.remote.api.VoucherifyAuthApi
import io.voucherify.android.sample.store.data.remote.api.request.LoginRequest
import io.voucherify.android.sample.store.data.remote.api.response.LoginResponse

class VoucherifyLoginRepository(private val loginApi: VoucherifyAuthApi): LoginRepository {

    override fun login(loginOrEmail: String, password: String): Single<LoginResponse> {
        val request = LoginRequest(
            loginOrEmail = loginOrEmail,
            password = password
        )

        return loginApi
            .login(loginRequest = request)
    }
}