package io.voucherify.android.sample.store.ui.customer.products.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.voucherify.android.sample.store.data.remote.api.response.ProductResponse
import io.voucherify.android.sample.store.data.service.shoppingcart.ShoppingCartService
import io.voucherify.android.sample.store.ui.base.BaseViewModel

class CustomerProductDetailsViewModel(private val shoppingCartService: ShoppingCartService) : BaseViewModel() {

    private val productDetailsLiveData: MutableLiveData<ProductResponse> = MutableLiveData()

    fun setData(productDetails: ProductResponse) {
        productDetailsLiveData.value = productDetails
    }

    fun buy(productSkuIndex: Int) {
        productDetailsLiveData.value?.let {
            shoppingCartService.add(Pair(first = it, second = productSkuIndex))
        }
    }

    fun outputProductDetailsData(): LiveData<ProductResponse> {
        return productDetailsLiveData
    }

}
