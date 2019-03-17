package io.voucherify.android.sample.store.data.remote.api

import io.reactivex.Flowable
import io.voucherify.android.sample.store.data.remote.api.response.ProductPageListResponse
import retrofit2.http.GET

interface VoucherifyProductsApi {

    @GET("/v1/products")
    fun list(): Flowable<ProductPageListResponse>
}