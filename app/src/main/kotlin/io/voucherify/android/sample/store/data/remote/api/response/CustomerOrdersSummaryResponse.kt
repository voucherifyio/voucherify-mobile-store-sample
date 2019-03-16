package io.voucherify.android.sample.store.data.remote.api.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import paperparcel.PaperParcel
import paperparcel.PaperParcelable

@JsonClass(generateAdapter = true)
@PaperParcel
data class CustomerOrdersSummaryResponse(
    @Json(name = "total_amount") val totalAmount: Int,
    @Json(name = "total_count") val totalCount: Int,
    @Json(name = "average_amount") val averageAmount: Int,
    @Json(name = "last_order_amount") val lastOrderAmount: Int
) : PaperParcelable {
    companion object {
        @JvmField
        val CREATOR = PaperParcelCustomerOrdersSummaryResponse.CREATOR
    }

}