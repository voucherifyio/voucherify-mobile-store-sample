package io.voucherify.android.sample.store.data.remote.api.response

import com.squareup.moshi.JsonClass
import paperparcel.PaperParcel
import paperparcel.PaperParcelable

@JsonClass(generateAdapter = true)
@PaperParcel
data class GiftResponse(
    val amount: Long,
    val balance: Long
) : PaperParcelable {
    companion object {
        @JvmField
        val CREATOR = PaperParcelGiftResponse.CREATOR
    }
}