package io.voucherify.android.sample.store.data.local

import android.content.SharedPreferences
import com.squareup.moshi.Moshi
import io.voucherify.android.sample.store.data.local.model.LocalAccount
import io.voucherify.android.sample.store.utils.extensions.get
import io.voucherify.android.sample.store.utils.extensions.set

class AccountLocalPreferencesStorable(private val sharedPreferences: SharedPreferences) :
    LocalPreferencesStorable<LocalAccount> {

    override fun save(data: LocalAccount?) {
        val jsonAdapter = Moshi.Builder().build().adapter(LocalAccount::class.java)
        val json = jsonAdapter.toJson(data)

        sharedPreferences[LocalPreferencesKey.Account.account] = json
    }

    override fun load(): LocalAccount? {
        val json = sharedPreferences[LocalPreferencesKey.Account.account, "{}"] ?: ""
        val jsonAdapter = Moshi.Builder().build().adapter(LocalAccount::class.java)

        return jsonAdapter.fromJson(json)
    }
}