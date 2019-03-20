package io.voucherify.android.sample.store.data.remote.api.response

import io.voucherify.android.sample.store.data.remote.api.PageListResponse

data class VoucherPageListResponse(val vouchers: List<VoucherResponse>) : PageListResponse()