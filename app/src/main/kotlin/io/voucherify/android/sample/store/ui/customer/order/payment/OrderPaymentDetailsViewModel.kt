package io.voucherify.android.sample.store.ui.customer.order.payment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.voucherify.android.sample.store.data.local.model.LocalUser
import io.voucherify.android.sample.store.data.service.user.UserService
import io.voucherify.android.sample.store.ui.base.BaseViewModel

class OrderPaymentDetailsViewModel(private val userService: UserService) : BaseViewModel() {

    private var localUserLiveData: MutableLiveData<LocalUser> = MutableLiveData()

    fun outputLocalUser(): LiveData<LocalUser> {

        localUserLiveData.value = userService.getCurrentUser()

        return localUserLiveData
    }
}