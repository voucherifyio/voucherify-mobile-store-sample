package io.voucherify.android.sample.store.data.remote.api

import io.reactivex.Single
import io.voucherify.android.sample.store.data.remote.api.request.LoginRequest
import io.voucherify.android.sample.store.data.remote.api.response.LoginResponse
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface VoucherifyAuthApi {

    @Headers("No-Authorization: true")
    @POST("/v1/auth")
    fun login(@Body loginRequest: LoginRequest): Single<LoginResponse>

}