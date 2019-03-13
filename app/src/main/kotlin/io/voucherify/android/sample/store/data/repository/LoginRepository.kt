package io.voucherify.android.sample.store.data.repository

import io.reactivex.Single
import io.voucherify.android.sample.store.data.remote.api.response.LoginResponse

interface LoginRepository {

    fun login(loginOrEmail: String, password: String): Single<LoginResponse>
}