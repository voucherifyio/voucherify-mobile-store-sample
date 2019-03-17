package io.voucherify.android.sample.store.data.repository.products

import io.reactivex.Flowable
import io.voucherify.android.sample.store.data.remote.api.response.ProductPageListResponse

interface ProductsRepository {

    fun list(): Flowable<ProductPageListResponse>
}