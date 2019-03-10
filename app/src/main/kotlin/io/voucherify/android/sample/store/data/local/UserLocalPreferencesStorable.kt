package io.voucherify.android.sample.store.data.local

import android.content.SharedPreferences
import com.squareup.moshi.Moshi
import io.voucherify.android.sample.store.data.local.model.LocalUser
import io.voucherify.android.sample.store.utils.extensions.get
import io.voucherify.android.sample.store.utils.extensions.set

class UserLocalPreferencesStorable(private val sharedPreferences: SharedPreferences) : LocalPreferencesStorable<LocalUser> {

    override fun save(data: LocalUser?) {
        val jsonAdapter = Moshi.Builder().build().adapter(LocalUser::class.java)
        val json = jsonAdapter.toJson(data)

        sharedPreferences[LocalPreferencesKey.User.user] = json
    }

    override fun load(): LocalUser? {
        val json = sharedPreferences[LocalPreferencesKey.User.user, "{}"] ?: ""
        val jsonAdapter = Moshi.Builder().build().adapter(LocalUser::class.java)

        return jsonAdapter.fromJson(json)
    }
}