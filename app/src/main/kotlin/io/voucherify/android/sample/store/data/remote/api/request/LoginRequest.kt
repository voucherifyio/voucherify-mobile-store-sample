package io.voucherify.android.sample.store.data.remote.api.request

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginRequest(
    @Json(name = "login_or_email") val loginOrEmail: String,
    val password: String
)