package io.voucherify.android.sample.store.ui.dashboard.admin.settings.pickers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.voucherify.android.sample.store.data.local.model.LocalCustomer
import io.voucherify.android.sample.store.data.remote.api.DataResult
import io.voucherify.android.sample.store.data.remote.api.response.CustomerResponse
import io.voucherify.android.sample.store.data.service.user.perspective.CustomerPerspectiveService
import io.voucherify.android.sample.store.ui.base.BaseViewModel

class UserSwitchViewModel(private val customerPerspectiveService: CustomerPerspectiveService) : BaseViewModel() {

    private val customersLiveData: MutableLiveData<DataResult<List<CustomerResponse>>> = MutableLiveData()

    fun switchTo(customer: CustomerResponse) {

        var localCustomer = LocalCustomer.from(customer)
        localCustomer.isActive = true

        customerPerspectiveService.switchTo(customer = localCustomer)
    }

    fun bindData(customers: List<CustomerResponse>) {
        customersLiveData.postValue(DataResult.succes(customers))
    }

    fun outputCustomersDataResponse(): LiveData<DataResult<List<CustomerResponse>>> {
        return customersLiveData
    }
}
