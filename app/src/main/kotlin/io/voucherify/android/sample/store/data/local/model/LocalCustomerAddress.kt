package io.voucherify.android.sample.store.data.local.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import paperparcel.PaperParcel
import paperparcel.PaperParcelable

@JsonClass(generateAdapter = true)
@PaperParcel
data class LocalCustomerAddress(
    val city: String?,
    val state: String?,
    val line_1: String?,
    val line_2: String?,
    val country: String?,
    @Json(name = "postal_code") val postalCode: String?
) : PaperParcelable {
    companion object {
        @JvmField
        val CREATOR = PaperParcelLocalCustomerAddress.CREATOR
    }

    constructor() : this(
        null,
        null,
        null,
        null,
        null,
        null
    )

    override fun toString(): String {
        return listOfNotNull(
            line_1,
            line_2,
            postalCode,
            city,
            country
        ).filter { it.isNotEmpty() }.joinToString("\n")
    }
}