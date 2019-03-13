package io.voucherify.android.sample.store.data.service.login

import io.reactivex.Single
import io.voucherify.android.sample.store.data.local.AccountLocalPreferencesStorable
import io.voucherify.android.sample.store.data.local.UserLocalPreferencesStorable
import io.voucherify.android.sample.store.data.local.model.LocalAccount
import io.voucherify.android.sample.store.data.local.model.LocalUser
import io.voucherify.android.sample.store.data.repository.LoginRepository

class VoucherifyLoginService(
    private val loginRepository: LoginRepository,
    private val userLocalPreferences: UserLocalPreferencesStorable,
    private val accountLocalPreferences: AccountLocalPreferencesStorable
) : LoginService {

    override fun login(loginOrEmail: String, password: String): Single<LocalUser> {
        return loginRepository
            .login(loginOrEmail = loginOrEmail, password = password)
            .doOnSuccess {
                accountLocalPreferences.save(LocalAccount(id = it.id))
            }
            .map { response ->
                LocalUser(
                    id = response.user.id,
                    login = response.user.login,
                    email = response.user.email,
                    firstName = response.user.firstName,
                    lastName = response.user.lastName,
                    isOwner = response.user.isOwner
                )
            }
            .doOnSuccess {
                userLocalPreferences.save(it)
            }
    }
}