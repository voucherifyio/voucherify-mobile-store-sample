package io.voucherify.android.sample.store.data.remote.api

import io.reactivex.Flowable
import io.voucherify.android.sample.store.data.remote.api.response.CustomerPageListResponse
import retrofit2.http.GET

interface VoucherifyCustomersApi {

    @GET("/v1/customers")
    fun list(): Flowable<CustomerPageListResponse>

}