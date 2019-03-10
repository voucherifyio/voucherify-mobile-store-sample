package io.voucherify.android.sample.store.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.voucherify.android.sample.store.data.service.user.UserService
import io.voucherify.android.sample.store.ui.base.BaseViewModel

class SplashViewModel(private val userService: UserService) : BaseViewModel() {

    private var isUserLogged: MutableLiveData<Boolean> = MutableLiveData()

    fun loginUserIfPossible() {
        isUserLogged.value = userService.isUserLogged()
    }

    fun outputUserLogged(): LiveData<Boolean> {
        return isUserLogged
    }
}