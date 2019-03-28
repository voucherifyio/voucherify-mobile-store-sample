package io.voucherify.android.sample.store.injection.module.onboarding

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.voucherify.android.sample.store.injection.scope.ActivityScope
import io.voucherify.android.sample.store.ui.onboarding.OnboardingActivity

@Module
abstract class OnboardingActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            OnboardingModule::class]
    )
    abstract fun onboardingActivity(): OnboardingActivity
}