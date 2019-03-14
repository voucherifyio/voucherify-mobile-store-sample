package io.voucherify.android.sample.store.data.remote.api.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CustomerLoyaltyResponse(
    val points: Int,
    @Json(name = "referred_customers") val referredCustomers: Int
)