package io.voucherify.android.sample.store.data.remote.api.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import paperparcel.PaperParcel
import paperparcel.PaperParcelable

@JsonClass(generateAdapter = true)
@PaperParcel
data class CustomerResponse(
    val id: String,
    @Json(name = "source_id") val sourceId: String?,
    val name: String?,
    val description: String?,
    val email: String?,
    val address: CustomerAddressResponse,
    val summary: CustomerSummaryResponse,
    val loyalty: CustomerLoyaltyResponse,
    val phone: String?
) : PaperParcelable {
    companion object {
        @JvmField
        val CREATOR = PaperParcelCustomerResponse.CREATOR
    }

}