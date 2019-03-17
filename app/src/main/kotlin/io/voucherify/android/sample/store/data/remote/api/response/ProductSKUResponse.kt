package io.voucherify.android.sample.store.data.remote.api.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import paperparcel.PaperParcel
import paperparcel.PaperParcelable
import java.util.*

@JsonClass(generateAdapter = true)
@PaperParcel
data class ProductSKUResponse(
    val id: String,
    @Json(name = "source_id") val sourceId: String,
    @Json(name = "object") val objectName: String,
    val sku: String,
    val currency: String?,
    val price: Double?,
//    val attributes: Dictionary<String, Any>,
//    val metadata: Dictionary<String, Any>,
    @Json(name = "created_at") val createdAt: Date
) : PaperParcelable {
    companion object {
        @JvmField
        val CREATOR = PaperParcelProductSKUResponse.CREATOR
    }
}