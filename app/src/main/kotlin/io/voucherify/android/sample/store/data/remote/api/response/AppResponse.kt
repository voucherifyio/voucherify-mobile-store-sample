package io.voucherify.android.sample.store.data.remote.api.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AppResponse(
    val name: String,
    val description: String,
    val timezone: String,
    val currency: String,
    @Json(name = "project_id") val projectId: String,
    @Json(name = "api_version") val apiVersion: String)