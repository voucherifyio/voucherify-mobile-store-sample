package io.voucherify.android.sample.store.data.remote.api.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserResponse(
    val id: String,
    val login: String,
    val email: String,
    @Json(name = "first_name") val firstName: String,
    @Json(name = "last_name") val lastName: String,
    @Json(name = "is_owner") val isOwner: Boolean
)