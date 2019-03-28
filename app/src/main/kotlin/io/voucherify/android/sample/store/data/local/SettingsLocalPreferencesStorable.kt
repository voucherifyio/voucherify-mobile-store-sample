package io.voucherify.android.sample.store.data.local

import android.content.SharedPreferences
import com.squareup.moshi.Moshi
import io.voucherify.android.sample.store.data.local.model.LocalSettings
import io.voucherify.android.sample.store.utils.extensions.get
import io.voucherify.android.sample.store.utils.extensions.set

class SettingsLocalPreferencesStorable(private val sharedPreferences: SharedPreferences) : LocalPreferencesStorable<LocalSettings> {

    override fun save(data: LocalSettings?) {
        val jsonAdapter = Moshi.Builder().build().adapter(LocalSettings::class.java)
        val json = jsonAdapter.toJson(data)

        sharedPreferences[LocalPreferencesKey.Settings.appSettings] = json
    }

    override fun load(): LocalSettings? {
        val json = sharedPreferences[LocalPreferencesKey.Settings.appSettings, "{}"] ?: ""
        val jsonAdapter = Moshi.Builder().build().adapter(LocalSettings::class.java)

        return jsonAdapter.fromJson(json)
    }
}