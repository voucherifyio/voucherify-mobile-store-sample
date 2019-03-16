package io.voucherify.android.sample.store.data.remote.api.response

import paperparcel.PaperParcel
import paperparcel.PaperParcelable

@PaperParcel
data class CustomerAddressResponse(
    val city: String?,
    val state: String?,
    val line_1: String?,
    val line_2: String?,
    val country: String?,
    val postal_code: String?
) : PaperParcelable {
    companion object {
        @JvmField
        val CREATOR = PaperParcelCustomerAddressResponse.CREATOR
    }

}