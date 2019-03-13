package io.voucherify.android.sample.store.injection.module

import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.voucherify.android.sample.store.data.local.AccountLocalPreferencesStorable
import io.voucherify.android.sample.store.data.local.UserLocalPreferencesStorable

@Module
object DataModule {

    @Provides
    @Reusable
    fun provideUserLocalPreferences(sharedPreferences: SharedPreferences): UserLocalPreferencesStorable =
        UserLocalPreferencesStorable(sharedPreferences = sharedPreferences)

    @Provides
    @Reusable
    fun provideAccountLocalPreferences(sharedPreferences: SharedPreferences): AccountLocalPreferencesStorable =
        AccountLocalPreferencesStorable(sharedPreferences = sharedPreferences)

}