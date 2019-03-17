package io.voucherify.android.sample.store.data.remote.api.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import paperparcel.PaperParcel
import paperparcel.PaperParcelable
import java.util.*

@JsonClass(generateAdapter = true)
@PaperParcel
data class ProductResponse(
    val id: String,
    @Json(name = "source_id") val sourceId: String,
    @Json(name = "object") val objectName: String,
    val name: String?,
//    val attributes: List<String>,
//    val metadata: Dictionary<String, Any>,
    @Json(name = "created_at") val createdAt: Date,
    val skus: ProductSKUPageListResponse
) : PaperParcelable {
    companion object {
        @JvmField
        val CREATOR = PaperParcelProductResponse.CREATOR
    }
}