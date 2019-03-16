package io.voucherify.android.sample.store.ui.dashboard.admin.customers.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.voucherify.android.sample.store.data.remote.api.DataResult
import io.voucherify.android.sample.store.data.remote.api.response.CustomerResponse
import io.voucherify.android.sample.store.data.service.customers.CustomersService
import io.voucherify.android.sample.store.ui.base.BaseViewModel

class CustomerDetailsViewModel : BaseViewModel() {

    private val customerDetailsLiveData: MutableLiveData<CustomerResponse> = MutableLiveData()

    fun setData(customerDetails: CustomerResponse) {
        customerDetailsLiveData.value = customerDetails
    }

    fun outputCustomerDetailsData(): LiveData<CustomerResponse> {
        return customerDetailsLiveData
    }

}
