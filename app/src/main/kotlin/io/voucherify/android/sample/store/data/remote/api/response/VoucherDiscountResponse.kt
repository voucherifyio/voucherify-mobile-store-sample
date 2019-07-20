package io.voucherify.android.sample.store.data.remote.api.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import paperparcel.PaperParcel
import paperparcel.PaperParcelable

@JsonClass(generateAdapter = true)
@PaperParcel
data class VoucherDiscountResponse(
    val type: VoucherDiscountType,
    @Json(name = "amount_off") val amountOff: Int?,
    @Json(name = "amount_limit") val amountLimit: Int?,
    @Json(name = "percent_off") val percentOff: Double?,
    @Json(name = "unit_off") val unitOff: Double?,
    @Json(name = "unit_type") val unitType: String?

) : PaperParcelable {

    companion object {
        @JvmField
        val CREATOR = PaperParcelVoucherDiscountResponse.CREATOR
    }

    val discount: Double
        get() {
            return when (type) {
                VoucherDiscountType.AMOUNT -> {
                    amountOff?.toDouble() ?: 0.0
                }
                VoucherDiscountType.PERCENT -> {
                    percentOff ?: 0.0
                }
                VoucherDiscountType.UNIT -> {
                    unitOff ?: 0.0
                }
            }
        }
}