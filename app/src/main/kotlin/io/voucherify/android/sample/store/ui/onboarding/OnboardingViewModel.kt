package io.voucherify.android.sample.store.ui.onboarding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.voucherify.android.sample.store.data.service.onboarding.OnboardingService
import io.voucherify.android.sample.store.ui.base.BaseViewModel

class OnboardingViewModel(private val onboardingService: OnboardingService) : BaseViewModel() {

    private var isOnboardingActive: MutableLiveData<Boolean> = MutableLiveData()

    fun setOnboardingAsShown() {
        onboardingService.updateActiveOnboarding(false)
        isOnboardingActive.value = onboardingService.hasActiveOnboarding()
    }

    fun outputOnboardingActiveUpdate(): LiveData<Boolean> {
        return isOnboardingActive
    }
}