package io.voucherify.android.sample.store.ui.dashboard.admin.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.voucherify.android.sample.store.data.local.model.LocalUser
import io.voucherify.android.sample.store.data.service.user.UserService
import io.voucherify.android.sample.store.ui.base.BaseViewModel

class SettingsAdminViewModel(private val userService: UserService) : BaseViewModel() {

    private val currentUserLiveData = MutableLiveData<LocalUser>()

    fun logout() {
        userService.removeCurrentUser()

        currentUserLiveData.postValue(userService.getCurrentUser())
    }

    fun outputLocalUserChanged(): LiveData<LocalUser> {
        return currentUserLiveData
    }

}