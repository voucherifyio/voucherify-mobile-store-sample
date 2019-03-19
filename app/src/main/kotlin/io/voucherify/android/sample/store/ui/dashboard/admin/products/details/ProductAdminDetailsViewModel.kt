package io.voucherify.android.sample.store.ui.dashboard.admin.products.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.voucherify.android.sample.store.data.remote.api.DataResult
import io.voucherify.android.sample.store.data.remote.api.response.CustomerResponse
import io.voucherify.android.sample.store.data.remote.api.response.ProductResponse
import io.voucherify.android.sample.store.data.service.customers.CustomersService
import io.voucherify.android.sample.store.ui.base.BaseViewModel

class ProductAdminDetailsViewModel : BaseViewModel() {

    private val productDetailsLiveData: MutableLiveData<ProductResponse> = MutableLiveData()

    fun setData(productDetails: ProductResponse) {
        productDetailsLiveData.value = productDetails
    }

    fun outputProductDetailsData(): LiveData<ProductResponse> {
        return productDetailsLiveData
    }
}
