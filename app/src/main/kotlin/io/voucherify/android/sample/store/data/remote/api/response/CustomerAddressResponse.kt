package io.voucherify.android.sample.store.data.remote.api.response

data class CustomerAddressResponse(
    val city: String?,
    val state: String?,
    val line_1: String?,
    val line_2: String?,
    val country: String?,
    val postal_code: String?
)