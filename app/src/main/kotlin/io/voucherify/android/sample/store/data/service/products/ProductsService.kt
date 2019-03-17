package io.voucherify.android.sample.store.data.service.customers

import io.reactivex.Flowable
import io.voucherify.android.sample.store.data.remote.api.response.ProductPageListResponse

interface ProductsService {

    fun list(): Flowable<ProductPageListResponse>
}