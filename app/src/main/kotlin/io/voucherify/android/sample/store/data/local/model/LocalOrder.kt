package io.voucherify.android.sample.store.data.local.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import paperparcel.PaperParcel
import paperparcel.PaperParcelable
import java.util.*

@JsonClass(generateAdapter = true)
@PaperParcel
data class LocalOrder(
    val items: List<LocalOrderItem>,
    val id: String,
    val totalPrice: Double,
    @Json(name = "created_date") val createdAt: Date,
    @Json(name = "planned_delivery_date") val plannedDeliveryAt: Date
) : PaperParcelable {
    companion object {
        @JvmField
        val CREATOR = PaperParcelLocalOrder.CREATOR
    }
}