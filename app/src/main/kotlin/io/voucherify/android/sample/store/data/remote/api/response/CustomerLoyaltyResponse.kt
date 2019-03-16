package io.voucherify.android.sample.store.data.remote.api.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import paperparcel.PaperParcel
import paperparcel.PaperParcelable

@JsonClass(generateAdapter = true)
@PaperParcel
data class CustomerLoyaltyResponse(
    val points: Int,
    @Json(name = "referred_customers") val referredCustomers: Int
) : PaperParcelable {
    companion object {
        @JvmField
        val CREATOR = PaperParcelCustomerLoyaltyResponse.CREATOR
    }

}