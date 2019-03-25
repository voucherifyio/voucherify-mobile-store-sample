package io.voucherify.android.sample.store.ui.customer.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.voucherify.android.sample.store.data.local.model.LocalCustomer
import io.voucherify.android.sample.store.data.service.user.perspective.CustomerPerspectiveService
import io.voucherify.android.sample.store.ui.base.BaseViewModel

class SettingsCustomerViewModel(
    private val customerPerspectiveService: CustomerPerspectiveService
) : BaseViewModel() {

    private val currentCustomerLiveData = MutableLiveData<LocalCustomer?>()

    fun switchToAdmin() {
        customerPerspectiveService.switchTo(customer = null)

        currentCustomerLiveData.value = customerPerspectiveService.activeCustomer()
    }

    fun outputLocalCustomerChanged(): LiveData<LocalCustomer?> {
        return currentCustomerLiveData
    }

}