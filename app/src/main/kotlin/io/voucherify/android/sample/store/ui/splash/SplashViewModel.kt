package io.voucherify.android.sample.store.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.voucherify.android.sample.store.data.service.onboarding.OnboardingService
import io.voucherify.android.sample.store.data.service.user.UserService
import io.voucherify.android.sample.store.ui.base.BaseViewModel

class SplashViewModel(private val userService: UserService,
                      private val onboardingService: OnboardingService) : BaseViewModel() {

    enum class ViewAction {
        openOnboarding,
        openLogin,
        openDashboard
    }

    private var viewAction: MutableLiveData<ViewAction> = MutableLiveData()

    fun loginUserIfPossible() {
        when {
            onboardingService.hasActiveOnboarding() -> viewAction.value = ViewAction.openOnboarding
            userService.isUserLogged() -> viewAction.value = ViewAction.openDashboard
            else -> viewAction.value = ViewAction.openLogin
        }
    }

    fun outputViewAction(): LiveData<ViewAction> {
        return viewAction
    }
}