package io.voucherify.android.sample.store.injection.module.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import io.voucherify.android.sample.store.data.service.onboarding.OnboardingService
import io.voucherify.android.sample.store.data.service.user.UserService
import io.voucherify.android.sample.store.data.service.user.perspective.CustomerPerspectiveService
import io.voucherify.android.sample.store.injection.scope.ActivityScope
import io.voucherify.android.sample.store.ui.splash.SplashActivity
import io.voucherify.android.sample.store.ui.splash.SplashViewModel

@Module
class SplashModule {

    private class SplashViewModelFactory(
        private val userService: UserService,
        private val onboardingService: OnboardingService,
        private val userPerspectiveService: CustomerPerspectiveService
    ) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return SplashViewModel(
                userService = userService,
                onboardingService = onboardingService,
                userPerspectiveService = userPerspectiveService
            ) as T
        }
    }

    @Provides
    @ActivityScope
    fun provideSplashViewModel(
        activity: SplashActivity,
        userService: UserService,
        onboardingService: OnboardingService,
        userPerspectiveService: CustomerPerspectiveService
    ): SplashViewModel = ViewModelProviders.of(
        activity,
        SplashViewModelFactory(
            userService = userService,
            onboardingService = onboardingService,
            userPerspectiveService = userPerspectiveService
        )
    ).get(SplashViewModel::class.java)

}