package io.voucherify.android.sample.store.injection.module.splash

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.voucherify.android.sample.store.injection.scope.ActivityScope
import io.voucherify.android.sample.store.ui.splash.SplashActivity

@Module
abstract class SplashActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            SplashModule::class]
    )
    abstract fun splashActivity(): SplashActivity
}