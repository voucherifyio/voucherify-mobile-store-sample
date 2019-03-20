package io.voucherify.android.sample.store.data.remote.api

import io.reactivex.Flowable
import io.voucherify.android.sample.store.data.remote.api.response.VoucherPageListResponse
import retrofit2.http.GET

interface VoucherifyVouchersApi {

    @GET("/v1/vouchers")
    fun list(): Flowable<VoucherPageListResponse>
}