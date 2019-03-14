package io.voucherify.android.sample.store.data.remote.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
open class PageListResponse {

    @Json(name = "has_more")
    var hasMore: Boolean = false

    var total: Int = 0
}