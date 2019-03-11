package io.voucherify.android.sample.store.injection.module

import dagger.Module
import dagger.Provides
import io.voucherify.android.sample.store.data.local.UserLocalPreferencesStorable
import io.voucherify.android.sample.store.data.repository.LoginRepository
import io.voucherify.android.sample.store.data.service.login.LoginService
import io.voucherify.android.sample.store.data.service.login.VoucherifyLoginService
import io.voucherify.android.sample.store.data.service.logout.LogoutService
import io.voucherify.android.sample.store.data.service.logout.VoucherifyLogoutService
import io.voucherify.android.sample.store.data.service.user.UserService
import io.voucherify.android.sample.store.data.service.user.VoucherifyUserService
import javax.inject.Singleton

@Module
object ServiceModule {

    @Provides
    @Singleton
    fun provideUserService(userLocalPreferences: UserLocalPreferencesStorable): UserService =
        VoucherifyUserService(userLocalPreferences = userLocalPreferences)

    @Provides
    @Singleton
    fun provideLoginService(
        loginRepository: LoginRepository,
        userLocalPreferences: UserLocalPreferencesStorable
    ): LoginService =
        VoucherifyLoginService(
            loginRepository = loginRepository,
            userLocalPreferences = userLocalPreferences
        )

    @Provides
    @Singleton
    fun provideLogoutService(
        userLocalPreferences: UserLocalPreferencesStorable
    ): LogoutService =
        VoucherifyLogoutService(
            userLocalPreferences = userLocalPreferences
        )
}