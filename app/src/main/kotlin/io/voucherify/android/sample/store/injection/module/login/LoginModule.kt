package io.voucherify.android.sample.store.injection.module.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import io.voucherify.android.sample.store.data.service.login.LoginService
import io.voucherify.android.sample.store.injection.scope.ActivityScope
import io.voucherify.android.sample.store.ui.login.LoginActivity
import io.voucherify.android.sample.store.ui.login.LoginViewModel

@Module
class LoginModule {

    private class LoginViewModelFactory(private val loginService: LoginService) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return LoginViewModel(loginService = loginService) as T
        }
    }

    @Provides
    @ActivityScope
    fun provideLoginViewModel(activity: LoginActivity, loginService: LoginService): LoginViewModel
            = ViewModelProviders.of(activity,
        LoginViewModelFactory(loginService = loginService)
    ).get(LoginViewModel::class.java)

}