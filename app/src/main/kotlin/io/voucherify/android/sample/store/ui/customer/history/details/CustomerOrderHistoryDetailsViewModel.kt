package io.voucherify.android.sample.store.ui.customer.history.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.voucherify.android.sample.store.data.local.model.LocalOrder
import io.voucherify.android.sample.store.ui.base.BaseViewModel

class CustomerOrderHistoryDetailsViewModel : BaseViewModel() {

    private val orderHistoryDetailsLiveData: MutableLiveData<LocalOrder> = MutableLiveData()

    fun setData(order: LocalOrder) {
        orderHistoryDetailsLiveData.value = order
    }

    fun outputOrderHistoryDetailsData(): LiveData<LocalOrder> {
        return orderHistoryDetailsLiveData
    }

}
