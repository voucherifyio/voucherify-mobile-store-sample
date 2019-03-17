package io.voucherify.android.sample.store.data.remote.api.response

import io.voucherify.android.sample.store.data.remote.api.PageListResponse

data class ProductPageListResponse(val products: List<ProductResponse>) : PageListResponse()