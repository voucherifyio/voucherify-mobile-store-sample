package io.voucherify.android.sample.store.data.service.user

import io.voucherify.android.sample.store.data.local.UserLocalPreferencesStorable
import io.voucherify.android.sample.store.data.local.model.LocalUser

class VoucherifyUserService(private val userLocalPreferences: UserLocalPreferencesStorable) : UserService {

    override fun getCurrentUser(): LocalUser {
        return userLocalPreferences.load() ?: LocalUser()
    }

    override fun setCurrentUser(localUser: LocalUser) {
        userLocalPreferences.save(localUser)
    }

    override fun removeCurrentUser() {
        userLocalPreferences.save(LocalUser())
    }

    override fun isUserLogged(): Boolean {
        return getCurrentUser().id.isNotBlank()
    }
}