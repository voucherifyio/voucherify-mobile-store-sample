package io.voucherify.android.sample.store.data.repository.settings

import io.voucherify.android.sample.store.data.local.SettingsLocalPreferencesStorable
import io.voucherify.android.sample.store.data.local.model.LocalSettings

class VoucherifyLocalSettingsRepository(private val settingsLocalPreferences: SettingsLocalPreferencesStorable) :
    LocalSettingsRepository {

    override fun fetch(): LocalSettings {
        return settingsLocalPreferences.load() ?: LocalSettings()
    }

    override fun update(localSettings: LocalSettings) {
        settingsLocalPreferences.save(localSettings)
    }

}