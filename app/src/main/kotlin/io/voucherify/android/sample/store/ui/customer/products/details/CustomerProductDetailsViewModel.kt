package io.voucherify.android.sample.store.ui.customer.products.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.voucherify.android.sample.store.data.remote.api.response.ProductResponse
import io.voucherify.android.sample.store.ui.base.BaseViewModel

class CustomerProductDetailsViewModel : BaseViewModel() {

    private val productDetailsLiveData: MutableLiveData<ProductResponse> = MutableLiveData()

    fun setData(productDetails: ProductResponse) {
        productDetailsLiveData.value = productDetails
    }

    fun outputProductDetailsData(): LiveData<ProductResponse> {
        return productDetailsLiveData
    }
}
