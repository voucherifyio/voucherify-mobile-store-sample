package io.voucherify.android.sample.store.data.remote.api.response

data class LoginResponse(
    val id: String,
    val userLogin: String,
    val user: UserResponse,
    val app: AppResponse
)