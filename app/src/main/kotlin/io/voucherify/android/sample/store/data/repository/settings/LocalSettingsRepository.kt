package io.voucherify.android.sample.store.data.repository.settings

import io.voucherify.android.sample.store.data.local.model.LocalSettings

interface LocalSettingsRepository {

    fun fetch(): LocalSettings

    fun update(localSettings: LocalSettings)
}