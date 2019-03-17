package io.voucherify.android.sample.store.data.repository.products

import io.reactivex.Flowable
import io.voucherify.android.sample.store.data.remote.api.VoucherifyProductsApi
import io.voucherify.android.sample.store.data.remote.api.response.ProductPageListResponse

class VoucherifyProductsRepository(private val productsApi: VoucherifyProductsApi) : ProductsRepository {

    override fun list(): Flowable<ProductPageListResponse> {
        return productsApi.list()
    }
}