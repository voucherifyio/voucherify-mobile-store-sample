package io.voucherify.android.sample.store.data.remote.api.response

data class CustomerResponse(
    val id: String,
    val source_id: String,
    val name: String?,
    val description: String?,
    val email: String?,
    val address: CustomerAddressResponse,
    val summary: CustomerSummaryResponse,
    val loyalty: CustomerLoyaltyResponse,
    val phone: String
)