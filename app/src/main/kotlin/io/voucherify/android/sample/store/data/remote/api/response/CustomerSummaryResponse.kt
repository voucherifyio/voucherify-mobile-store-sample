package io.voucherify.android.sample.store.data.remote.api.response

data class CustomerSummaryResponse(
    val redemptions: CustomerRedemptionsSummaryResponse,
    val orders: CustomerOrdersSummaryResponse
)