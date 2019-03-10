package io.voucherify.android.sample.store.injection.module

import dagger.Module
import io.voucherify.android.sample.store.injection.module.dashboard.DashboardActivityModule
import io.voucherify.android.sample.store.injection.module.login.LoginActivityModule
import io.voucherify.android.sample.store.injection.module.splash.SplashActivityModule

@Module(
    includes = [
        SplashActivityModule::class,
        LoginActivityModule::class,
        DashboardActivityModule::class
    ]
)
abstract class ContributeActivityModule