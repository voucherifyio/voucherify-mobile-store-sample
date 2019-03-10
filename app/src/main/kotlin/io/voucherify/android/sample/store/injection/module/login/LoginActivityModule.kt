package io.voucherify.android.sample.store.injection.module.login

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.voucherify.android.sample.store.injection.scope.ActivityScope
import io.voucherify.android.sample.store.ui.login.LoginActivity

@Module
abstract class LoginActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            LoginModule::class]
    )
    abstract fun loginActivity(): LoginActivity
}