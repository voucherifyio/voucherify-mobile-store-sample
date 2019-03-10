package io.voucherify.android.sample.store.data.repository

import io.reactivex.Single
import io.voucherify.android.sample.store.data.local.model.LocalUser

interface LoginRepository {

    fun login(loginOrEmail: String, password: String): Single<LocalUser>
}