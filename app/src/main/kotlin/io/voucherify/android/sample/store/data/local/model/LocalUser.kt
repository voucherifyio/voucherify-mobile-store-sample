package io.voucherify.android.sample.store.data.local.model

data class LocalUser(
    val id: String,
    val login: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val isOwner: Boolean
) {

    constructor() : this(
        "",
        "",
        "",
        "",
        "",
        false
    )
}