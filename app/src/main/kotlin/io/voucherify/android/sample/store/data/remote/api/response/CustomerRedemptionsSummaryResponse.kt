package io.voucherify.android.sample.store.data.remote.api.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import paperparcel.PaperParcel
import paperparcel.PaperParcelable

@JsonClass(generateAdapter = true)
@PaperParcel
data class CustomerRedemptionsSummaryResponse(
    @Json(name = "total_redeemed") val totalRedeemed: Int,
    @Json(name = "total_failed") val totalFailed: Int,
    @Json(name = "total_succeeded") val totalSucceeded: Int,
    @Json(name = "total_rolled_back") val totalRolledBack: Int,
    @Json(name = "total_rollback_failed") val totalRollbackFailed: Int,
    @Json(name = "total_rollback_succeeded") val totalRollbackSucceeded: Int
) : PaperParcelable {
    companion object {
        @JvmField
        val CREATOR = PaperParcelCustomerRedemptionsSummaryResponse.CREATOR
    }

}