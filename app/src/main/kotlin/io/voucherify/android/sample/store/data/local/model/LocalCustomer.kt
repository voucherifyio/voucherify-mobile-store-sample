package io.voucherify.android.sample.store.data.local.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import io.voucherify.android.sample.store.data.remote.api.response.CustomerResponse

@JsonClass(generateAdapter = true)
data class LocalCustomer(
    val id: String,
    @Json(name = "source_id") val sourceId: String?,
    val name: String?,
    val description: String?,
    val email: String?,
    var isActive: Boolean,
    var orders: List<LocalOrder>
) {

    companion object {

        fun from(customer: CustomerResponse): LocalCustomer {
            return LocalCustomer(
                id = customer.id,
                sourceId = customer.sourceId,
                name = customer.name,
                description = customer.description,
                email = customer.email,
                isActive = false,
                orders = emptyList()
            )
        }
    }

    constructor() : this(
        "",
        "",
        null,
        null,
        null,
        false,
        emptyList()
    )
}