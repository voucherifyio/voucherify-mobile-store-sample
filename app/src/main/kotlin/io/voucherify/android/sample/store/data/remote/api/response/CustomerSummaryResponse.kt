package io.voucherify.android.sample.store.data.remote.api.response

import paperparcel.PaperParcel
import paperparcel.PaperParcelable

@PaperParcel
data class CustomerSummaryResponse(
    val redemptions: CustomerRedemptionsSummaryResponse,
    val orders: CustomerOrdersSummaryResponse
) : PaperParcelable {
    companion object {
        @JvmField
        val CREATOR = PaperParcelCustomerSummaryResponse.CREATOR
    }

}