package io.voucherify.android.sample.store.injection.module.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import io.voucherify.android.sample.store.data.service.onboarding.OnboardingService
import io.voucherify.android.sample.store.injection.scope.ActivityScope
import io.voucherify.android.sample.store.ui.onboarding.OnboardingActivity
import io.voucherify.android.sample.store.ui.onboarding.OnboardingViewModel

@Module
class OnboardingModule {

    private class OnboardingViewModelFactory(private val onboardingService: OnboardingService) :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return OnboardingViewModel(onboardingService = onboardingService) as T
        }
    }

    @Provides
    @ActivityScope
    fun provideOnboardingViewModel(activity: OnboardingActivity, onboardingService: OnboardingService): OnboardingViewModel =
        ViewModelProviders.of(
            activity,
            OnboardingViewModelFactory(onboardingService = onboardingService)
        ).get(OnboardingViewModel::class.java)

}