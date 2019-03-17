package io.voucherify.android.sample.store.data.remote.api.response

import io.voucherify.android.sample.store.data.remote.api.PageListResponse
import paperparcel.PaperParcel
import paperparcel.PaperParcelable

@PaperParcel
data class ProductSKUPageListResponse(val data: List<ProductSKUResponse>) : PageListResponse(), PaperParcelable {
    companion object {
        @JvmField
        val CREATOR = PaperParcelProductSKUPageListResponse.CREATOR
    }
}