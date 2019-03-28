package io.voucherify.android.sample.store.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.voucherify.android.sample.store.data.service.onboarding.OnboardingService
import io.voucherify.android.sample.store.data.service.user.UserService
import io.voucherify.android.sample.store.data.service.user.perspective.CustomerPerspectiveService
import io.voucherify.android.sample.store.ui.base.BaseViewModel

class SplashViewModel(private val userService: UserService,
                      private val onboardingService: OnboardingService,
                      private val userPerspectiveService: CustomerPerspectiveService) : BaseViewModel() {

    enum class ViewAction {
        OPEN_ONBOARDING,
        OPEN_LOGIN,
        OPEN_ADMIN_DASHBOARD,
        OPEN_CUSTOMER_DASHBOARD
    }

    private var viewAction: MutableLiveData<ViewAction> = MutableLiveData()

    fun loginUserIfPossible() {
        when {
            onboardingService.hasActiveOnboarding() -> viewAction.value = ViewAction.OPEN_ONBOARDING
            userService.isUserLogged() -> {
                viewAction.value = if (userPerspectiveService.activeCustomer() != null) {
                    ViewAction.OPEN_CUSTOMER_DASHBOARD
                } else {
                    ViewAction.OPEN_ADMIN_DASHBOARD
                }
            }
            else -> viewAction.value = ViewAction.OPEN_LOGIN
        }
    }

    fun outputViewAction(): LiveData<ViewAction> {
        return viewAction
    }
}