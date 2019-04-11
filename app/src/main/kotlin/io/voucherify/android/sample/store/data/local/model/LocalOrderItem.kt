package io.voucherify.android.sample.store.data.local.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import io.voucherify.android.sample.store.data.remote.api.response.ProductSKUResponse
import paperparcel.PaperParcel
import paperparcel.PaperParcelable

@JsonClass(generateAdapter = true)
@PaperParcel
data class LocalOrderItem(
    val sku: ProductSKUResponse,
    val id: String,
    @Json(name = "product_id") val productId: String,
    @Json(name = "product_source_id") val productSourceId: String,
    @Json(name = "product_name") val productName: String
    ) : PaperParcelable {
    companion object {
        @JvmField
        val CREATOR = PaperParcelLocalOrderItem.CREATOR
    }
}