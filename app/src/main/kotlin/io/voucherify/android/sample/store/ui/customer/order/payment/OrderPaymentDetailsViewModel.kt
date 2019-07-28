package io.voucherify.android.sample.store.ui.customer.order.payment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.voucherify.android.sample.store.data.local.model.LocalCustomer
import io.voucherify.android.sample.store.data.service.user.perspective.CustomerPerspectiveService
import io.voucherify.android.sample.store.ui.base.BaseViewModel

class OrderPaymentDetailsViewModel(private val customerPerspectiveService: CustomerPerspectiveService) :
    BaseViewModel() {

    private var customerLiveData: MutableLiveData<LocalCustomer> = MutableLiveData()

    fun outputCustomerData(): LiveData<LocalCustomer> {

        customerPerspectiveService.activeCustomer()?.let {
            customerLiveData.value = it
        }

        return customerLiveData
    }
}