package io.voucherify.android.sample.store.data.service.login

import io.reactivex.Single
import io.voucherify.android.sample.store.data.local.model.LocalUser

interface LoginService {

    fun login(loginOrEmail: String, password: String): Single<LocalUser>
}