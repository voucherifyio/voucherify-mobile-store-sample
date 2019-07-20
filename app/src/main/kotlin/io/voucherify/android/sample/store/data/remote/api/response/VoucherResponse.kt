package io.voucherify.android.sample.store.data.remote.api.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import paperparcel.PaperParcel
import paperparcel.PaperParcelable
import java.util.*

@JsonClass(generateAdapter = true)
@PaperParcel
data class VoucherResponse(
    val id: String,
    val code: String,
    val category: String,
    val type: VoucherType,
    val active: Boolean,
    val discount: VoucherDiscountResponse?,
    val gift: GiftResponse?,
    @Json(name = "is_referral_code") val isReferralCode: Boolean,
    @Json(name = "created_at") val createdAt: Date,
    @Json(name = "updated_at") val updatedAt: Date?,
    @Json(name = "object") val objectName: String
) : PaperParcelable {
    companion object {
        @JvmField
        val CREATOR = PaperParcelVoucherResponse.CREATOR
    }
}