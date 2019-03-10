package io.voucherify.android.sample.store.data.service.login

import io.reactivex.Single
import io.voucherify.android.sample.store.data.local.UserLocalPreferencesStorable
import io.voucherify.android.sample.store.data.local.model.LocalUser
import io.voucherify.android.sample.store.data.repository.LoginRepository

class VoucherifyLoginService(private val loginRepository: LoginRepository,
                             private val userLocalPreferences: UserLocalPreferencesStorable) : LoginService {

    override fun login(loginOrEmail: String, password: String): Single<LocalUser> {
        return loginRepository
            .login(loginOrEmail = loginOrEmail, password = password)
            .doOnSuccess {
                userLocalPreferences.save(it)
            }
    }
}