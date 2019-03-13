package io.voucherify.android.sample.store.data.service.logout

import io.reactivex.Completable
import io.voucherify.android.sample.store.data.local.AccountLocalPreferencesStorable
import io.voucherify.android.sample.store.data.local.UserLocalPreferencesStorable
import io.voucherify.android.sample.store.data.local.model.LocalAccount
import io.voucherify.android.sample.store.data.local.model.LocalUser

class VoucherifyLogoutService(
    private val userLocalPreferences: UserLocalPreferencesStorable,
    private val accountLocalPreferences: AccountLocalPreferencesStorable
) : LogoutService {

    override fun logout(): Completable {
        return Completable.fromAction {
            accountLocalPreferences.save(LocalAccount())
            userLocalPreferences.save(LocalUser())
        }
    }
}