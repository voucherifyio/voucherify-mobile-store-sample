package io.voucherify.android.sample.store.data.local.model

data class LocalSettings(var isOnboardingActive: Boolean) {

    constructor() : this(
        true
    )
}